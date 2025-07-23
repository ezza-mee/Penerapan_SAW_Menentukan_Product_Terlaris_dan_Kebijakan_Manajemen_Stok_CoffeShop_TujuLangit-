package com.main.models.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataProduct;

public class loadDataProduct {
    public static ArrayList<dataProduct> getAllProducts() {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product WHERE status = 'Ready'";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                ResultSet rs = state.executeQuery()) {

            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                byte[] imageProduct = rs.getBytes("imageProduct");
                String name = rs.getString("nameProduct");
                int price = rs.getInt("price");
                String category = rs.getString("category");
                String description = rs.getString("description");
                String status = rs.getString("status");

                dataProduct product = new dataProduct(idProduct, imageProduct, name, price, category,
                        description, status);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static dataProduct getProductById(int idProduct) {
        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product WHERE idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idProduct);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("idProduct");
                byte[] imageProduct = rs.getBytes("imageProduct");
                String name = rs.getString("nameProduct");
                int price = rs.getInt("price");
                String category = rs.getString("category");
                String description = rs.getString("description");
                String status = rs.getString("status");

                return new dataProduct(id, imageProduct, name, price, category, description, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
