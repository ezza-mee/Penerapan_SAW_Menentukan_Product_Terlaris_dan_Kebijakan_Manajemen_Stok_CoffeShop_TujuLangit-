package com.main.models.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.auth.sessionLogin;
import com.main.models.connectionDatabase;

public class loadDataTransaction {
    public static DefaultTableModel getAllDataTransaction() {

        String[] dataHeader = { "ID", "ID Staff", "Date", "Table", "Customer", "Sub Quantity", "Sub Price", "status",
                "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatatransactionwithstaff WHERE idStaff = ? AND status = 'Process'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            int idStaff = sessionLogin.get().getIdStaff();
            state.setInt(1, idStaff);

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "STLK00" + resultData.getInt("idTransaction"),
                        resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("numberTable"),
                        resultData.getString("customer"),
                        resultData.getInt("subQuantity"),
                        resultData.getInt("subPrice"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataTransactionDone() {

        String[] dataHeader = { "ID", "Date", "Table", "Customer", "Sub Quantity", "Sub Price", "status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatatransactionwithstaff WHERE  status = 'Done'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "STLK00" + resultData.getInt("idTransaction"),
                        resultData.getString("date"),
                        resultData.getString("numberTable"),
                        resultData.getString("customer"),
                        resultData.getInt("subQuantity"),
                        resultData.getInt("subPrice"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataTransactionDoneByStaff() {

        String[] dataHeader = { "ID", "ID Staff", "Date", "Table", "Customer", "Sub Quantity", "Sub Price", "status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatatransactionwithstaff WHERE idStaff = ? AND status = 'Done'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            int idStaff = sessionLogin.get().getIdStaff();
            state.setInt(1, idStaff);

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "STLK00" + resultData.getInt("idTransaction"),
                        resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("numberTable"),
                        resultData.getString("customer"),
                        resultData.getInt("subQuantity"),
                        resultData.getInt("subPrice"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static int getAllQuantityDataTransaction() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_transaction";

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
