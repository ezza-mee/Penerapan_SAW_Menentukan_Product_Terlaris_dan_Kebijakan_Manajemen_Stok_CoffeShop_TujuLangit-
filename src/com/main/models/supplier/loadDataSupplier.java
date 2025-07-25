package com.main.models.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataSearchSupplier;
import com.main.models.entity.dataSupplier;

public class loadDataSupplier {
    public static DefaultTableModel getAllDataSupplier() {

        String[] dataHeader = { "ID", "Date", "Supplier", "Quantity", "Unit", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatasupplier";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "SU00" + resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllStockDataSupplier() {

        String[] dataHeader = { "ID", "Date", "Supplier", "Quantity", "Unit", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatasupplier WHERE status = 'Ready' ";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "SU00" + resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllOutStockDataSupplier() {

        String[] dataHeader = { "ID", "Date", "Supplier", "Quantity", "Unit", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatasupplier WHERE status = 'Out of Stock' ";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "SU00" + resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllPendingDataSupplier() {

        String[] dataHeader = { "ID", "Date", "Supplier", "Quantity", "Unit", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatasupplier WHERE status = 'Process' ";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "SU00" + resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static List<dataSupplier> getAllReadySupplierNames() {
        List<dataSupplier> supplierNames = new ArrayList<>();
        String query = "SELECT DISTINCT idSupplier, nameSupplier FROM vwalldatasupplier WHERE status = 'Ready' ";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                ResultSet rs = state.executeQuery()) {

            while (rs.next()) {
                int idSupplier = rs.getInt("idSupplier");
                String nameSupplier = rs.getString("nameSupplier");

                supplierNames.add(new dataSupplier(idSupplier, nameSupplier, 0, "", ""));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplierNames;
    }

    public static dataSupplier getDataById(int idSupplier) {
        String query = "SELECT * FROM tbl_data_supplier WHERE idSupplier = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idSupplier);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new dataSupplier(
                        rs.getInt("idSupplier"),
                        rs.getString("nameSupplier"),
                        rs.getDouble("quantity"),
                        rs.getString("unit"),
                        rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<dataSearchSupplier> getAllSupplier() {
        ArrayList<dataSearchSupplier> supplierList = new ArrayList<>();
        String query = "SELECT * FROM vwalldatasupplier";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();
            while (resultData.next()) {
                dataSearchSupplier dataSupplier = new dataSearchSupplier(
                        resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status"));
                supplierList.add(dataSupplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return supplierList;

    }

    public static ArrayList<dataSearchSupplier> getAllSupplierByStatus(String status) {
        ArrayList<dataSearchSupplier> supplierList = new ArrayList<>();
        String query = "SELECT * FROM vwalldatasupplier";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, status);
            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                dataSearchSupplier dataSupplier = new dataSearchSupplier(
                        resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getDouble("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status"));
                supplierList.add(dataSupplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return supplierList;

    }

    public static int getAllQuantityDataSupplier() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_supplier";

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

    public static int getAllQuantityPendingDataSupplier() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_supplier WHERE status = 'Process' ";

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

    public static int getAllQuantityStockDataSupplier() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_supplier WHERE status = 'Ready' ";

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

    public static int getAllQuantityOutStockDataSupplier() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_supplier WHERE LOWER(status) = 'Out of Stock' ";

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
