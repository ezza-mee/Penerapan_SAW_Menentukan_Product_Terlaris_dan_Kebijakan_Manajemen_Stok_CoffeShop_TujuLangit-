package com.main.models.dataProduct;

import com.main.models.connectionDatabase;

import java.sql.*;
import java.util.ArrayList;

public class searchDataProduct {
    public static ArrayList<getterDataProduct> searchProducts(String keyword) {
        ArrayList<getterDataProduct> products = new ArrayList<>();

        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM tbl_data_product WHERE nameProduct LIKE ? OR description LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword + "%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                getterDataProduct product = new getterDataProduct(
                        rs.getInt("idProduct"),
                        rs.getBytes("imageProduct"),
                        rs.getString("nameProduct"),
                        rs.getInt("price"),
                        rs.getString("category"),
                        rs.getString("description"));
                products.add(product);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
