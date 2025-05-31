package com.main.models.dataProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.models.connectionDatabase;

public class loadDataProduct {

    public static ArrayList<getterDataProduct> getAllProducts() {
        ArrayList<getterDataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description FROM tbl_data_product WHERE status = 'Ready'";

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

                getterDataProduct product = new getterDataProduct(idProduct, imageProduct, name, price, category,
                        description);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static getterDataProduct getProductById(int idProduct) {
        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description FROM tbl_data_product WHERE idProduct = ?";

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

                return new getterDataProduct(id, imageProduct, name, price, category, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int getProductIdByName(String nameProduct) {
        int idProduct = -1;
        String query = "SELECT idProduct FROM tbl_data_product WHERE nameProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nameProduct);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idProduct = rs.getInt("idProduct");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idProduct;
    }

}
