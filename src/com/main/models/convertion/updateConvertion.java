package com.main.models.convertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateConvertion {
    public static boolean updateData(int idConvertion, String formUnit, String toUnit, double multiplier,
            String description) {
        boolean success = false;

        String updateNormal = "UPDATE tbl_unit_convertion SET date = NOW(), formUnit = ?, toUnit = ?, multiplier = ?, description = ? WHERE idConvertion = ? AND formUnit = ? AND toUnit = ?";
        String updateReverse = "UPDATE tbl_unit_convertion SET date = NOW(), formUnit = ?, toUnit = ?, multiplier = ?, description = ? WHERE idConvertion = ? AND formUnit = ? AND toUnit = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt1 = conn.prepareStatement(updateNormal);
                PreparedStatement stmt2 = conn.prepareStatement(updateReverse)) {

            // Update arah normal
            stmt1.setString(1, formUnit);
            stmt1.setString(2, toUnit);
            stmt1.setDouble(3, multiplier);
            stmt1.setString(4, description);
            stmt1.setInt(5, idConvertion);
            stmt1.setString(6, formUnit);
            stmt1.setString(7, toUnit);

            // Update arah balik
            stmt2.setString(1, toUnit);
            stmt2.setString(2, formUnit);
            stmt2.setDouble(3, 1 / multiplier);
            stmt2.setString(4, "Reversed: " + description);
            stmt2.setInt(5, idConvertion);
            stmt2.setString(6, toUnit);
            stmt2.setString(7, formUnit);

            int result1 = stmt1.executeUpdate();
            int result2 = stmt2.executeUpdate();

            success = result1 > 0 && result2 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

}
