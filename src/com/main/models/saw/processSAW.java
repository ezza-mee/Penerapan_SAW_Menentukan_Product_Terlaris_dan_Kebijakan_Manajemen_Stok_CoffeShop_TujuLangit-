package com.main.models.saw;

import java.sql.*;
import java.util.*;

import com.main.models.connectionDatabase;
import com.main.models.rangking.insertDataRangking;
// Import class yang berisi method pengecekan
import com.main.models.rangking.loadDataRangking;
import com.main.models.rangking.updateDataRangking;
import com.main.models.normalisation.insertDataNormalisation;
import com.main.models.normalisation.loadDataNormalisation;
import com.main.models.normalisation.updateDataNormalisation;

public class processSAW {
    public static void runSAW(String periode, List<Integer> idProductList) {
        try (Connection conn = connectionDatabase.getConnection()) {

            // STEP 1: Ambil data alternatif berdasarkan periode dan id produk
            StringBuilder placeholders = new StringBuilder();
            for (int i = 0; i < idProductList.size(); i++) {
                placeholders.append("?");
                if (i < idProductList.size() - 1) {
                    placeholders.append(", ");
                }
            }

            String queryAlternatif = "SELECT idAlternatif, product, K1, K2, K3, K4 FROM tbl_data_alternatif WHERE DATE(periode) = ?";
            PreparedStatement stmt = conn.prepareStatement(queryAlternatif);
            stmt.setString(1, periode);

            ResultSet rs = stmt.executeQuery();
            List<Map<String, Object>> alternatifList = new ArrayList<>();
            double[] max = new double[4];
            double[] min = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };

            while (rs.next()) {
                Map<String, Object> alt = new HashMap<>();
                alt.put("idAlternatif", rs.getInt("idAlternatif"));
                alt.put("product", rs.getString("product"));
                for (int i = 0; i < 4; i++) {
                    double value = rs.getDouble("K" + (i + 1));
                    alt.put("K" + (i + 1), value);
                    max[i] = Math.max(max[i], value);
                    min[i] = Math.min(min[i], value);
                }
                alternatifList.add(alt);
            }

            // Debug alternatif
            System.out.println("=== Data Alternatif ===");
            for (Map<String, Object> a : alternatifList) {
                System.out.println(a);
            }

            // STEP 2: Ambil data kriteria
            String queryKriteria = "SELECT * FROM tbl_data_kriteria ORDER BY idKriteria ASC";
            ResultSet rsKriteria = conn.createStatement().executeQuery(queryKriteria);

            List<Integer> rawBobotList = new ArrayList<>();
            List<Double> bobotList = new ArrayList<>(); // hasil normalisasi bobot
            List<String> tipeList = new ArrayList<>();

            double totalBobot = 0.0;

            while (rsKriteria.next()) {
                int rawBobot = rsKriteria.getInt("weight"); // bobot 1 sampai 5
                totalBobot += rawBobot;
                rawBobotList.add(rawBobot);
                tipeList.add(rsKriteria.getString("type").trim().toLowerCase());
            }

            // Normalisasi bobot ke nilai pecahan
            for (int raw : rawBobotList) {
                double normalised = raw / totalBobot;
                bobotList.add(normalised);
            }

            // Debug kriteria
            System.out.println("\n=== Bobot dan Tipe Kriteria ===");
            for (int i = 0; i < bobotList.size(); i++) {
                System.out.printf("K%d: %s, raw bobot = %d, bobot normalisasi = %.3f\n",
                        (i + 1), tipeList.get(i), rawBobotList.get(i), bobotList.get(i));
            }

            // STEP 3: Proses normalisasi dan hitung skor
            System.out.println("\n=== Perhitungan Normalisasi dan Skor SAW ===");
            for (Map<String, Object> alt : alternatifList) {
                double score = 0;
                System.out.println("\nProduk: " + alt.get("product"));

                for (int i = 0; i < 4; i++) {
                    double nilai = (double) alt.get("K" + (i + 1));
                    double normalisasi = 0;

                    if (tipeList.get(i).equals("benefit")) {
                        normalisasi = nilai / max[i];
                    } else if (tipeList.get(i).equals("cost")) {
                        normalisasi = min[i] / nilai;
                    }

                    double bobot = bobotList.get(i);
                    double kontribusi = normalisasi * bobot;
                    score += kontribusi;

                    System.out.printf("K%d (%s): %.3f → norm: %.3f, bobot: %.2f, kontribusi: %.3f\n",
                            (i + 1), tipeList.get(i), nilai, normalisasi, bobot, kontribusi);
                }

                alt.put("score", score);
                System.out.printf("Total Skor SAW: %.4f\n", score);
            }

            // STEP 4: Ranking
            System.out.println("\n=== Hasil Ranking ===");
            alternatifList.sort((a, b) -> Double.compare((double) b.get("score"), (double) a.get("score")));
            for (int i = 0; i < alternatifList.size(); i++) {
                Map<String, Object> alt = alternatifList.get(i);
                System.out.printf("RANK %d: %s (Skor: %.4f)\n", i + 1, alt.get("product"), alt.get("score"));
            }

            // === STEP 4 & 6: Simpan ke tbl_data_normalisation dan tbl_data_rangking ===
            for (int i = 0; i < alternatifList.size(); i++) {
                Map<String, Object> alt = alternatifList.get(i);

                int idAlternatif = (int) alt.get("idAlternatif");
                String product = (String) alt.get("product");
                double k1 = (double) alt.get("K1");
                double k2 = (double) alt.get("K2");
                double k3 = (double) alt.get("K3");
                double k4 = (double) alt.get("K4");
                double skor = (double) alt.get("score");
                int rank = i + 1;

                // Hitung normalisasi untuk masing-masing K1–K4 (ulang dari logika sebelumnya)
                double normK1 = tipeList.get(0).equals("benefit") ? k1 / max[0] : min[0] / k1;
                double normK2 = tipeList.get(1).equals("benefit") ? k2 / max[1] : min[1] / k2;
                double normK3 = tipeList.get(2).equals("benefit") ? k3 / max[2] : min[2] / k3;
                double normK4 = tipeList.get(3).equals("benefit") ? k4 / max[3] : min[3] / k4;

                // === STEP 4: Simpan atau update data normalisasi ===
                if (loadDataNormalisation.isDataNormalisationExistForAlternatif(periode, idAlternatif)) {
                    updateDataNormalisation.updateNormalisation(idAlternatif, product, normK1, normK2, normK3, normK4,
                            periode);
                } else {
                    insertDataNormalisation.insertNormalisation(idAlternatif, product, normK1, normK2, normK3, normK4,
                            periode);
                }

                // Ambil idNormalisation untuk referensi ke tbl_data_rangking
                int idNormalisation = -1;
                String getIdQuery = "SELECT idNormalisation FROM tbl_data_normalisation WHERE periode = ? AND idAlternatif = ?";
                try (PreparedStatement stmtGetId = conn.prepareStatement(getIdQuery)) {
                    stmtGetId.setString(1, periode);
                    stmtGetId.setInt(2, idAlternatif);
                    ResultSet rsId = stmtGetId.executeQuery();
                    if (rsId.next()) {
                        idNormalisation = rsId.getInt("idNormalisation");
                    }
                }

                if (idNormalisation != -1) {
                    // === STEP 6: Simpan atau update data rangking ===
                    if (loadDataRangking.isDataRankingExistForNormalisation(periode, idNormalisation)) {
                        updateDataRangking.updateRangking(idNormalisation, product, skor, rank, periode);
                    } else {
                        insertDataRangking.insertRangking(idNormalisation, product, skor, rank, periode);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Terjadi error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
