package com.main.models.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteCompositionProduct {
    public static boolean deleteComposition(int idSupplier, int idProduct) {
        boolean success = false;

        String query = "DELETE FROM tbl_data_composition_product WHERE idSupplier = ? AND idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idSupplier);
            state.setInt(2, idProduct);

            if (state.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static boolean deleteAllCompositionByProduct(int idProduct) {
        boolean success = false;
        String query = "DELETE FROM tbl_data_composition_product WHERE idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idProduct);

            if (state.executeUpdate() >= 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
