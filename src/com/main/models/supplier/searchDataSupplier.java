package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.models.entity.dataSearchSupplier;

import com.main.models.connectionDatabase;

public class searchDataSupplier {

    public static ArrayList<dataSearchSupplier> searchSupplier(String keyword) {
        ArrayList<dataSearchSupplier> listSupplier = new ArrayList<>();
        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM vwalldatasupplierwithstaff " +
                    "WHERE idSupplier LIKE ? OR date LIKE ? OR LOWER(nameSupplier) LIKE ? " +
                    "OR quantity LIKE ? OR unit LIKE ? OR LOWER(status) = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword + "%";

            // Set keyword patterns
            for (int i = 1; i <= 6; i++) {
                stmt.setString(i, pattern);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataSearchSupplier supplier = new dataSearchSupplier(
                        rs.getInt("idSupplier"),
                        rs.getString("nameStaff"),
                        rs.getString("nameSupplier"),
                        rs.getDouble("quantity"),
                        rs.getString("unit"),
                        rs.getString("status"),
                        rs.getString("date"),
                        rs.getString("dateApprove"));
                listSupplier.add(supplier);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSupplier;
    }

    public static ArrayList<dataSearchSupplier> searchSupplierByStatus(String keyword, String status) {
        ArrayList<dataSearchSupplier> listSupplier = new ArrayList<>();
        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM vwalldatasupplierwithstaff " +
                    "WHERE (CAST(idSupplier AS CHAR) LIKE ? OR date LIKE ? OR LOWER(nameSupplier) LIKE ? " +
                    "OR CAST(quantity AS CHAR) LIKE ? OR unit LIKE ?) " +
                    "AND LOWER(status) = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword.toLowerCase() + "%";

            // Set keyword patterns (1–5)
            stmt.setString(1, pattern); // idSupplier
            stmt.setString(2, pattern); // date
            stmt.setString(3, pattern); // nameSupplier
            stmt.setString(4, pattern); // quantity
            stmt.setString(5, pattern); // unit

            // Set status lowercase (param 6)
            stmt.setString(6, status.toLowerCase());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataSearchSupplier supplier = new dataSearchSupplier(
                        rs.getInt("idSupplier"),
                        rs.getString("nameStaff"),
                        rs.getString("nameSupplier"),
                        rs.getDouble("quantity"),
                        rs.getString("unit"),
                        rs.getString("status"),
                        rs.getString("date"),
                        rs.getString("dateApprove"));
                listSupplier.add(supplier);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSupplier;
    }

}
