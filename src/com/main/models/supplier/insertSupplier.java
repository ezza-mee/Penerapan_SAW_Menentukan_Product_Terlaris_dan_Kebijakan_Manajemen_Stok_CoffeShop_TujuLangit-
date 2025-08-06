package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertSupplier {
    public static boolean insertData(int idStaff, String nameSupplier, double quantity, String unitSupplier,
            String description) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_supplier (idstaff, nameSupplier, quantity, unit, description, status, date) VALUES (?, ?, ?, ?, ?, 'Processing', now())";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setInt(1, idStaff);
            state.setString(2, nameSupplier);
            state.setDouble(3, quantity);
            state.setString(4, unitSupplier);
            state.setString(5, description);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
