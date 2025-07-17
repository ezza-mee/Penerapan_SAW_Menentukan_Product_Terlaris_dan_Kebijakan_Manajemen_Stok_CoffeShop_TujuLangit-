package com.main.models.saw;

import java.sql.*;
import java.util.*;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataBobotKriteria;

public class processSAW {
    public static void runSAW(String periode) {
        try (Connection conn = connectionDatabase.getConnection()) {

            // 1. Ambil data dari tbl_data_kriteria sesuai periode
            String queryKriteria = "SELECT * FROM tbl_data_kriteria WHERE periode = ?";
            PreparedStatement state = conn.prepareStatement(queryKriteria);
            state.setString(1, periode);
            ResultSet rs = state.executeQuery();

            // Menyimpan nilai min & max setiap kriteria
            double maxQty = 0, maxPrice = 0, maxTotalRevenue = 0, maxFrekuensi = 0;
            double minQty = Double.MAX_VALUE, minPrice = Double.MAX_VALUE, minTotalRevenue = Double.MAX_VALUE,
                    minFrekuensi = Double.MAX_VALUE;

            List<Map<String, Object>> rawData = new ArrayList<>();

            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                double totalRevenue = rs.getDouble("totalRevenue"); // Diganti dari outStock
                int frekuensi = rs.getInt("frekuensi");

                maxQty = Math.max(maxQty, quantity);
                maxPrice = Math.max(maxPrice, price);
                maxTotalRevenue = Math.max(maxTotalRevenue, totalRevenue);
                maxFrekuensi = Math.max(maxFrekuensi, frekuensi);

                minQty = Math.min(minQty, quantity);
                minPrice = Math.min(minPrice, price);
                minTotalRevenue = Math.min(minTotalRevenue, totalRevenue);
                minFrekuensi = Math.min(minFrekuensi, frekuensi);

                Map<String, Object> data = new HashMap<>();
                data.put("idKriteria", rs.getInt("idKriteria"));
                data.put("product", rs.getString("product"));
                data.put("quantity", quantity);
                data.put("price", price);
                data.put("totalRevenue", totalRevenue); // Diganti dari outStock
                data.put("frekuensi", frekuensi);
                data.put("periode", rs.getString("periode"));

                rawData.add(data);
            }

            // 2. Ambil bobot dan tipe dari tbl_data_kriteria_weight berdasarkan idKriteria
            Map<Integer, dataBobotKriteria> bobotMap = new HashMap<>();
            String queryWeight = "SELECT * FROM tbl_data_kriteria";
            Statement weightStmt = conn.createStatement();
            ResultSet weightRs = weightStmt.executeQuery(queryWeight);

            while (weightRs.next()) {
                dataBobotKriteria bobot = new dataBobotKriteria(
                        weightRs.getInt("idWeight"),
                        weightRs.getString("kriteria"),
                        weightRs.getDouble("weight"),
                        weightRs.getString("type"));
                bobotMap.put(bobot.getIdKriteria(), bobot); // Gunakan idKriteria sebagai key
            }

            // DEBUG: Print available criteria IDs
            System.out.println("Available criteria IDs: " + bobotMap.keySet());

            // 3. Validasi apakah semua kriteria ada berdasarkan idKriteria yang dibutuhkan
            // Ambil semua idKriteria yang unik dari data
            Set<Integer> requiredCriteriaIds = new HashSet<>();
            for (Map<String, Object> item : rawData) {
                requiredCriteriaIds.add((Integer) item.get("idKriteria"));
            }

            // Validasi keberadaan semua kriteria yang diperlukan
            for (Integer criteriaId : requiredCriteriaIds) {
                if (!bobotMap.containsKey(criteriaId)) {
                    System.err.println("CRITICAL ERROR: Kriteria dengan ID '" + criteriaId
                            + "' tidak ditemukan dalam tbl_data_kriteria_weight!");
                    System.err.println("Pastikan semua kriteria memiliki bobot yang terdefinisi.");
                    return;
                }
            }

            // 4. Normalisasi dan hitung skor
            List<Map<String, Object>> resultWithScore = new ArrayList<>();

            for (Map<String, Object> item : rawData) {
                double q = (int) item.get("quantity");
                double p = (int) item.get("price");
                double tr = (double) item.get("totalRevenue"); // Diganti dari outStock
                double f = (int) item.get("frekuensi");

                Integer idKriteria = (Integer) item.get("idKriteria");

                // Ambil bobot kriteria berdasarkan idKriteria
                dataBobotKriteria bobotQuantity = findBobotByType(bobotMap, "quantity");
                dataBobotKriteria bobotPrice = findBobotByType(bobotMap, "price");
                dataBobotKriteria bobotTotalRevenue = findBobotByType(bobotMap, "totalRevenue");
                dataBobotKriteria bobotFrekuensi = findBobotByType(bobotMap, "frekuensi");

                // Pastikan tidak ada pembagian dengan 0 - gunakan type untuk menentukan
                // benefit/cost
                double nq = 0, np = 0, ntr = 0, nf = 0;

                if (maxQty > 0 && bobotQuantity != null) {
                    nq = bobotQuantity.getType().equalsIgnoreCase("benefit") ? (q / maxQty) : (minQty / q);
                }
                if (maxPrice > 0 && bobotPrice != null) {
                    np = bobotPrice.getType().equalsIgnoreCase("benefit") ? (p / maxPrice) : (minPrice / p);
                }
                if (maxTotalRevenue > 0 && bobotTotalRevenue != null) {
                    ntr = bobotTotalRevenue.getType().equalsIgnoreCase("benefit") ? (tr / maxTotalRevenue)
                            : (minTotalRevenue / tr);
                }
                if (maxFrekuensi > 0 && bobotFrekuensi != null) {
                    nf = bobotFrekuensi.getType().equalsIgnoreCase("benefit") ? (f / maxFrekuensi) : (minFrekuensi / f);
                }

                // Hitung skor berdasarkan bobot yang tersedia
                double score = 0;
                if (bobotQuantity != null)
                    score += (nq * bobotQuantity.getWeight());
                if (bobotPrice != null)
                    score += (np * bobotPrice.getWeight());
                if (bobotTotalRevenue != null)
                    score += (ntr * bobotTotalRevenue.getWeight());
                if (bobotFrekuensi != null)
                    score += (nf * bobotFrekuensi.getWeight());

                Map<String, Object> result = new HashMap<>();
                result.put("idKriteria", item.get("idKriteria"));
                result.put("product", item.get("product"));
                result.put("quantity", nq);
                result.put("price", np);
                result.put("totalRevenue", ntr); // Diganti dari outStock
                result.put("frekuensi", nf);
                result.put("score", score);
                result.put("periode", item.get("periode"));

                resultWithScore.add(result);
            }

            // 5. Hapus data lama sebelum insert (opsional, untuk menghindari duplikasi)
            String deleteOldNorm = "DELETE FROM tbl_data_normalisation WHERE periode = ?";
            PreparedStatement psDeleteNorm = conn.prepareStatement(deleteOldNorm);
            psDeleteNorm.setString(1, periode);
            psDeleteNorm.executeUpdate();

            String deleteOldRank = "DELETE FROM tbl_data_rangking WHERE periode = ?";
            PreparedStatement psDeleteRank = conn.prepareStatement(deleteOldRank);
            psDeleteRank.setString(1, periode);
            psDeleteRank.executeUpdate();

            // 6. Insert ke tbl_data_normalisation dan tbl_data_rangking
            String insertNorm = "INSERT INTO tbl_data_normalisation (idWeight, idKriteria, product, quantity, price, totalRevenue, frekuensi, periode, lastUpdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
            PreparedStatement psNorm = conn.prepareStatement(insertNorm, Statement.RETURN_GENERATED_KEYS);

            String insertRank = "INSERT INTO tbl_data_rangking (idNormalisation, product, score, `rank`, periode, createAt) VALUES (?, ?, ?, ?, ?, NOW())";
            PreparedStatement psRank = conn.prepareStatement(insertRank);

            // Urutkan berdasarkan skor tertinggi
            resultWithScore.sort((a, b) -> Double.compare((double) b.get("score"), (double) a.get("score")));

            int rank = 1;
            // Ambil idWeight pertama (asumsi semua menggunakan set bobot yang sama)
            int commonIdWeight = bobotMap.values().iterator().next().getIdKriteria();

            for (Map<String, Object> r : resultWithScore) {
                psNorm.setInt(1, commonIdWeight);
                psNorm.setInt(2, (int) r.get("idKriteria"));
                psNorm.setString(3, (String) r.get("product"));
                psNorm.setDouble(4, (double) r.get("quantity"));
                psNorm.setDouble(5, (double) r.get("price"));
                psNorm.setDouble(6, (double) r.get("totalRevenue")); // Diganti dari outStock
                psNorm.setDouble(7, (double) r.get("frekuensi"));
                psNorm.setString(8, (String) r.get("periode"));
                psNorm.executeUpdate();

                // Ambil ID normalisasi yang baru saja di-insert
                ResultSet rsKeys = psNorm.getGeneratedKeys();
                int idNorm = 0;
                if (rsKeys.next()) {
                    idNorm = rsKeys.getInt(1);
                }

                psRank.setInt(1, idNorm);
                psRank.setString(2, (String) r.get("product"));
                psRank.setDouble(3, (double) r.get("score"));
                psRank.setInt(4, rank++);
                psRank.setString(5, (String) r.get("periode"));
                psRank.executeUpdate();
            }

            System.out.println("Proses SAW selesai untuk periode: " + periode);
            System.out.println("Total data yang diproses: " + resultWithScore.size());

        } catch (Exception e) {
            System.err.println("Error dalam proses SAW: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method untuk mencari bobot berdasarkan type kriteria
    private static dataBobotKriteria findBobotByType(Map<Integer, dataBobotKriteria> bobotMap, String type) {
        for (dataBobotKriteria bobot : bobotMap.values()) {
            String kriteria = bobot.getKriteria().toLowerCase();
            if (kriteria.contains(type.toLowerCase())) {
                return bobot;
            }
        }
        return null;
    }
}