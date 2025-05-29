package com.main.models.dataProduct;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Statement;

import com.main.models.connectionDatabase;

public class insertDataProduct {
    public static int insertProduct(String imageProduct, String nameProduct, int price, String category,
            String description) {
        int generatedId = -1;

        String query = "INSERT INTO tbl_data_product (date, imageProduct, nameProduct, price, category, description, status) VALUES (now(), ?, ?, ?, ?, ?, 'Ready')";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                InputStream inputImage = new FileInputStream(imageProduct)) {

            state.setBinaryStream(1, inputImage);
            state.setString(2, nameProduct);
            state.setInt(3, price);
            state.setString(4, category);
            state.setString(5, description);

            int rows = state.executeUpdate();

            if (rows > 0) {
                ResultSet rs = state.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
}
