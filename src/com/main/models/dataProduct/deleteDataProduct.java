package com.main.models.dataProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteDataProduct {

    public static boolean deleteProduct(int idProduct) {
        String query = "UPDATE tbl_data_product SET status = 'Out of Stock' WHERE idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idProduct);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
