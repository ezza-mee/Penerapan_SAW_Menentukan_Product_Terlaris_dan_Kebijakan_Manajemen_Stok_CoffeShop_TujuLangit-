package com.main.models.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataProduct;

public class loadDataProduct {
    public static ArrayList<dataProduct> getAllProducts() {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product";

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

    public static ArrayList<dataProduct> getProductsByStatus(String status) {
        ArrayList<dataProduct> productList = new ArrayList<>();
        String query = "SELECT * FROM tbl_data_product WHERE LOWER(status) = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productList.add(new dataProduct(
                        rs.getInt("idProduct"),
                        rs.getBytes("imageProduct"),
                        rs.getString("nameProduct"),
                        rs.getInt("price"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("status")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static ArrayList<dataProduct> getProductsByCategoryAndStatus(String category, String status) {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status " +
                "FROM tbl_data_product WHERE category = ?";

        if (status != null && !status.isEmpty()) {
            query += " AND status = ?";
        }

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, category);

            if (status != null && !status.isEmpty()) {
                state.setString(2, status);
            }

            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                byte[] imageProduct = rs.getBytes("imageProduct");
                String name = rs.getString("nameProduct");
                int price = rs.getInt("price");
                String cat = rs.getString("category");
                String description = rs.getString("description");
                String stat = rs.getString("status");

                dataProduct product = new dataProduct(idProduct, imageProduct, name, price, cat, description, stat);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static ArrayList<dataProduct> getAllFoodProducts() {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product WHERE category = 'Food' ";

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

    public static ArrayList<dataProduct> getAllCoffeProducts() {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product WHERE category = 'Coffee' ";

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

    public static ArrayList<dataProduct> getAllDrinkProducts() {
        ArrayList<dataProduct> productList = new ArrayList<>();

        String query = "SELECT idProduct, imageProduct, nameProduct, price, category, description, status FROM tbl_data_product WHERE category = 'Drink' ";

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

    public static int getAllQuantityDataProduct() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_Product";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public static int getAllQuantityDataFoodProduct() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_Product WHERE category = 'Food' ";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public static int getAllQuantityDataCoffeeProduct() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_Product WHERE category = 'Coffee' ";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public static int getAllQuantityDataDrinkProduct() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_Product WHERE category = 'Drink' ";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}
