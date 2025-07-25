package com.main.models.product;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataProduct;

import java.sql.*;
import java.util.ArrayList;

public class searchDataProduct {
    public static ArrayList<dataProduct> searchProducts(String keyword) {
        ArrayList<dataProduct> products = new ArrayList<>();

        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM tbl_data_product WHERE nameProduct LIKE ? OR description LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword + "%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataProduct product = new dataProduct(
                        rs.getInt("idProduct"),
                        rs.getBytes("imageProduct"),
                        rs.getString("nameProduct"),
                        rs.getInt("price"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("status"));
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

    public static ArrayList<dataProduct> searchProductsByKeywordAndCategory(String keyword, String category) {
        ArrayList<dataProduct> products = new ArrayList<>();

        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM tbl_data_product WHERE category = ? AND (nameProduct LIKE ? OR description LIKE ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword + "%";
            stmt.setString(1, category);
            stmt.setString(2, pattern);
            stmt.setString(3, pattern);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataProduct product = new dataProduct(
                        rs.getInt("idProduct"),
                        rs.getBytes("imageProduct"),
                        rs.getString("nameProduct"),
                        rs.getInt("price"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("status"));
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
