package com.main.models.dataProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertDataCompositionProduct {
    public static boolean insertCompositionProduct(int idProduct, int idSupplier, String nameProduct,
            String nameSupplier,
            int quantity, String unit) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_composition_product (idProduct, idSupplier, nameProduct, supplier, quantity, unit) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setInt(1, idProduct);
            state.setInt(2, idSupplier);
            state.setString(3, nameProduct);
            state.setString(4, nameSupplier);
            state.setInt(5, quantity);
            state.setString(6, unit);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
