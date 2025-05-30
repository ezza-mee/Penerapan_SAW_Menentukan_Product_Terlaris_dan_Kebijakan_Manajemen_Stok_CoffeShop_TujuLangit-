package com.main.models.dataProduct;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

import com.main.models.connectionDatabase;

public class updateDataProduct {
    public static boolean updateProduct(int idProduct, String imageProduct, String nameProduct, int price,
            String category, String description) {

        String query = "UPDATE tbl_data_product SET imageProduct = ?, nameProduct = ?, price = ?, category = ?, description = ?, status = 'Ready' WHERE idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                InputStream inputImage = new FileInputStream(imageProduct)) {

            state.setBinaryStream(1, inputImage);
            state.setString(2, nameProduct);
            state.setInt(3, price);
            state.setString(4, category);
            state.setString(5, description);
            state.setInt(7, idProduct);

            int rows = state.executeUpdate();
            return rows > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
