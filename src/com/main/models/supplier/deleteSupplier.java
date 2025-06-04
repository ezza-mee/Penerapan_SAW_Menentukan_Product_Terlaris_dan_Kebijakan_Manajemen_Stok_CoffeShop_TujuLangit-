package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteSupplier {
    public static boolean deleteData(int idSupplier, int quantity) {
        boolean data = false;

        String query = "UPDATE tbl_data_supplier SET quantity = ?, status = 'Out Of Stock' WHERE idSupplier = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, quantity);
            state.setInt(2, idSupplier);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
