package com.main.models.rangking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateDataRangking {

    public static void updateRangking(int idNormalisation, String product, double score, int rank, String periode) {
        String query = "UPDATE tbl_data_rangking SET product = ?, score = ?, `rank` = ?, createAt = NOW() " +
                "WHERE idNormalisation = ? AND periode = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product);
            stmt.setDouble(2, score);
            stmt.setInt(3, rank);
            stmt.setInt(4, idNormalisation);
            stmt.setString(5, periode);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                System.out.println("✅ Update rangking success for ID: " + idNormalisation);
            } else {
                System.out.println("⚠️ No rangking found to update for ID: " + idNormalisation);
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to update rangking for ID: " + idNormalisation);
            e.printStackTrace();
        }
    }

    public static void updateRankingOrder(String periode) {
        String selectQuery = "SELECT idNormalisation, score FROM tbl_data_rangking WHERE periode = ? ORDER BY score DESC";
        String updateQuery = "UPDATE tbl_data_rangking SET `rank` = ? WHERE idNormalisation = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            selectStmt.setString(1, periode);
            ResultSet rs = selectStmt.executeQuery();

            int newRank = 1;
            while (rs.next()) {
                int id = rs.getInt("idNormalisation");

                updateStmt.setInt(1, newRank);
                updateStmt.setInt(2, id);
                updateStmt.executeUpdate();

                newRank++;
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengurutkan ulang ranking: " + e.getMessage());
        }
    }

}
