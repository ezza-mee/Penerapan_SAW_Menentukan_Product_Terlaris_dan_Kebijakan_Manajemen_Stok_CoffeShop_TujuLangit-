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
            double maxQty = 0, maxPrice = 0, maxOutStock = 0, maxFrekuensi = 0;
            double minQty = Double.MAX_VALUE, minPrice = Double.MAX_VALUE, minOutStock = Double.MAX_VALUE,
                    minFrekuensi = Double.MAX_VALUE;

            List<Map<String, Object>> rawData = new ArrayList<>();

            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                double outStock = rs.getDouble("outStock");
                int frekuensi = rs.getInt("frekuensi");

                maxQty = Math.max(maxQty, quantity);
                maxPrice = Math.max(maxPrice, price);
                maxOutStock = Math.max(maxOutStock, outStock);
                maxFrekuensi = Math.max(maxFrekuensi, frekuensi);

                minQty = Math.min(minQty, quantity);
                minPrice = Math.min(minPrice, price);
                minOutStock = Math.min(minOutStock, outStock);
                minFrekuensi = Math.min(minFrekuensi, frekuensi);

                Map<String, Object> data = new HashMap<>();
                data.put("idKriteria", rs.getInt("idKriteria"));
                data.put("product", rs.getString("product"));
                data.put("quantity", quantity);
                data.put("price", price);
                data.put("outStock", outStock);
                data.put("frekuensi", frekuensi);
                data.put("periode", rs.getString("periode"));

                rawData.add(data);
            }

            // 2. Ambil bobot dan tipe dari tbl_data_kriteria_weight
            Map<String, dataBobotKriteria> bobotMap = new HashMap<>();
            String queryWeight = "SELECT * FROM tbl_data_kriteria_weight";
            Statement weightStmt = conn.createStatement();
            ResultSet weightRs = weightStmt.executeQuery(queryWeight);

            while (weightRs.next()) {
                dataBobotKriteria bobot = new dataBobotKriteria(
                        weightRs.getInt("idWeight"),
                        weightRs.getString("kriteria"),
                        weightRs.getDouble("weight"),
                        weightRs.getString("type"));
                bobotMap.put(bobot.getKriteria().toLowerCase(), bobot);
            }

            // DEBUG: Print available criteria keys
            System.out.println("Available criteria keys: " + bobotMap.keySet());

            // 3. Validasi apakah semua kriteria ada - sesuaikan dengan nama di database
            String[] requiredCriteria = { "jumlah penjualan product", "harga product", "out stock supplier",
                    "frekuensi penjualan product" };
            for (String criteria : requiredCriteria) {
                if (!bobotMap.containsKey(criteria)) {
                    System.err.println("CRITICAL ERROR: Kriteria '" + criteria
                            + "' tidak ditemukan dalam tbl_data_kriteria_weight!");
                    System.err.println("Pastikan nama kriteria di database sesuai dengan yang diharapkan.");
                    return;
                }
            }

            // 4. Normalisasi dan hitung skor
            List<Map<String, Object>> resultWithScore = new ArrayList<>();

            for (Map<String, Object> item : rawData) {
                double q = (int) item.get("quantity");
                double p = (int) item.get("price");
                double o = (double) item.get("outStock");
                double f = (int) item.get("frekuensi");

                // Pastikan tidak ada pembagian dengan 0 - gunakan nama kriteria sesuai database
                double nq = 0, np = 0, no = 0, nf = 0;

                if (maxQty > 0) {
                    nq = bobotMap.get("jumlah penjualan product").getType().equalsIgnoreCase("benefit") ? (q / maxQty)
                            : (minQty / q);
                }
                if (maxPrice > 0) {
                    np = bobotMap.get("harga product").getType().equalsIgnoreCase("benefit") ? (p / maxPrice)
                            : (minPrice / p);
                }
                if (maxOutStock > 0) {
                    no = bobotMap.get("out stock supplier").getType().equalsIgnoreCase("benefit") ? (o / maxOutStock)
                            : (minOutStock / o);
                }
                if (maxFrekuensi > 0) {
                    nf = bobotMap.get("frekuensi penjualan product").getType().equalsIgnoreCase("benefit")
                            ? (f / maxFrekuensi)
                            : (minFrekuensi / f);
                }

                double score = (nq * bobotMap.get("jumlah penjualan product").getWeight()) +
                        (np * bobotMap.get("harga product").getWeight()) +
                        (no * bobotMap.get("out stock supplier").getWeight()) +
                        (nf * bobotMap.get("frekuensi penjualan product").getWeight());

                Map<String, Object> result = new HashMap<>();
                result.put("idKriteria", item.get("idKriteria"));
                result.put("product", item.get("product"));
                result.put("quantity", nq);
                result.put("price", np);
                result.put("outStock", no);
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

            String deleteOldRank = "DELETE FROM tbl_data_rangking WHERE priode = ?";
            PreparedStatement psDeleteRank = conn.prepareStatement(deleteOldRank);
            psDeleteRank.setString(1, periode);
            psDeleteRank.executeUpdate();

            // 6. Insert ke tbl_data_normalisation dan tbl_data_rangking
            String insertNorm = "INSERT INTO tbl_data_normalisation (idWeight, idKriteria, product, quantity, price, outStock, frekuensi, periode, lastUpdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
            PreparedStatement psNorm = conn.prepareStatement(insertNorm, Statement.RETURN_GENERATED_KEYS);

            String insertRank = "INSERT INTO tbl_data_rangking (idNormalisation, product, score, `rank`, priode, createAt) VALUES (?, ?, ?, ?, ?, NOW())";
            PreparedStatement psRank = conn.prepareStatement(insertRank);

            // Urutkan berdasarkan skor tertinggi
            resultWithScore.sort((a, b) -> Double.compare((double) b.get("score"), (double) a.get("score")));

            int rank = 1;
            // Ambil idWeight pertama (asumsi semua menggunakan set bobot yang sama)
            int commonIdWeight = bobotMap.values().iterator().next().getIdWeight();

            for (Map<String, Object> r : resultWithScore) {
                psNorm.setInt(1, commonIdWeight);
                psNorm.setInt(2, (int) r.get("idKriteria"));
                psNorm.setString(3, (String) r.get("product"));
                psNorm.setDouble(4, (double) r.get("quantity"));
                psNorm.setDouble(5, (double) r.get("price"));
                psNorm.setDouble(6, (double) r.get("outStock"));
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
}