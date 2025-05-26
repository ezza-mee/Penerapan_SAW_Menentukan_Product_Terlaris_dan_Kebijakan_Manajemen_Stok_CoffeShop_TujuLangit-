package com.main.models.dataSupplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;

public class loadDataSupplier {
    public static DefaultTableModel getAllDataSupplier() {

        String[] dataHeader = { "ID", "Date", "Supplier", "Quantity", "Unit", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatasupplier WHERE status = 'Ready'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "SU00" + resultData.getInt("idSupplier"),
                        resultData.getString("date"),
                        resultData.getString("nameSupplier"),
                        resultData.getInt("quantity"),
                        resultData.getString("unit"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
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

}
