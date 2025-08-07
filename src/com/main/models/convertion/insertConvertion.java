package com.main.models.convertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertConvertion {
    public static boolean insertData(int idComposition, String formUnit, String toUnit, double multiplier,
            String description) {
        boolean success = false;

        String query = "INSERT INTO tbl_unit_convertion (idConvertion, date, formUnit, toUnit, multiplier, description) VALUES (?, NOW(), ?, ?, ?, ?)";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt1 = conn.prepareStatement(query);
                PreparedStatement stmt2 = conn.prepareStatement(query)) {

            int newId = getNextId(conn); // Method bantu untuk ambil idConvertion berikutnya

            // Normal
            stmt1.setInt(1, newId);
            stmt1.setString(2, formUnit);
            stmt1.setString(3, toUnit);
            stmt1.setDouble(4, multiplier);
            stmt1.setString(5, description);

            // Reverse
            stmt2.setInt(1, newId);
            stmt2.setString(2, toUnit);
            stmt2.setString(3, formUnit);
            stmt2.setDouble(4, 1 / multiplier);
            stmt2.setString(5, "Reversed: " + description);

            int result1 = stmt1.executeUpdate();
            int result2 = stmt2.executeUpdate();

            success = result1 > 0 && result2 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Ambil idConvertion terakhir + 1 (manual autoincrement)
    private static int getNextId(Connection conn) throws SQLException {
        String sql = "SELECT MAX(idConvertion) AS maxId FROM tbl_unit_convertion";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("maxId") + 1;
            }
        }
        return 1;
    }

}
