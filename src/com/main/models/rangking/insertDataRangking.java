package com.main.models.rangking;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.main.models.connectionDatabase;

public class insertDataRangking {

    public static void insertRangking(int idNormalisation, String product, double score, int rank, String periode) {
        String query = "INSERT INTO tbl_data_rangking (idNormalisation, product, score, `rank`, periode, createAt) " +
                "VALUES (?, ?, ?, ?, ?, NOW())";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idNormalisation);
            stmt.setString(2, product);
            stmt.setDouble(3, score);
            stmt.setInt(4, rank);
            stmt.setString(5, periode);

            stmt.executeUpdate();
            System.out.println("✅ Insert rangking success for product: " + product);

        } catch (Exception e) {
            System.err.println("❌ Failed to insert rangking for product: " + product);
            e.printStackTrace();
        }
    }
}
