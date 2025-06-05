package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertSupplier {
    public static boolean insertData(String nameSupplier, double quantity, String unitSupplier, String description) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_supplier (date, nameSupplier, quantity, unit, description, status) VALUES (now(), ?, ?, ?, ?, 'Ready')";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setString(1, nameSupplier);
            state.setDouble(2, quantity);
            state.setString(3, unitSupplier);
            state.setString(4, description);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
