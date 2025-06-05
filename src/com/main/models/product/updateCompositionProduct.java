package com.main.models.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateCompositionProduct {
    public static boolean updateComposition(int idSupplier, int idProduct,
            String nameProduct, String nameSupplier,
            double quantity, String unit) {

        String query = "UPDATE tbl_data_composition_product " +
                "SET nameProduct = ?, nameSupplier = ?, quantity = ?, unit = ? " +
                "WHERE idSupplier = ? AND idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, nameProduct);
            state.setString(2, nameSupplier);
            state.setDouble(3, quantity);
            state.setString(4, unit);
            state.setInt(5, idSupplier);
            state.setInt(6, idProduct);

            int rows = state.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
