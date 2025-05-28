package com.main.models.dataSupplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateDataSupplier {
    public static boolean updateSupplier(int idSupplier, String nameSupplier, int quantity, String unit,
            String description) {
        String query = "UPDATE tbl_data_supplier SET nameSupplier = ?, quantity = ?, unit = ?, description = ?, status =  'Ready' WHERE idSupplier = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nameSupplier);
            stmt.setInt(2, quantity);
            stmt.setString(3, unit);
            stmt.setString(4, description);
            stmt.setInt(5, idSupplier);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
