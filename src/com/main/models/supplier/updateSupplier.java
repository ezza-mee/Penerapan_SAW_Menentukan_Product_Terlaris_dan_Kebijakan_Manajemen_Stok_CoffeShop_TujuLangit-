package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateSupplier {
    public static boolean updateData(int idSupplier, int idStaff, String nameSupplier, double quantity, String unit,
            String description) {
        String query = "UPDATE tbl_data_supplier SET idStaff = ?, nameSupplier = ?, quantity = ?, unit = ?, description = ?, status = 'Processing' WHERE idSupplier = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idStaff);
            stmt.setString(2, nameSupplier);
            stmt.setDouble(3, quantity);
            stmt.setString(4, unit);
            stmt.setString(5, description);
            stmt.setInt(6, idSupplier);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean approveSupplier(int idSupplier, String status) {
        String query = "UPDATE tbl_data_supplier SET status = ?, dateApprove = NOW() WHERE idSupplier = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            stmt.setInt(2, idSupplier);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
