package com.main.models.dataStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;

public class loadDataStaff {
    public static DefaultTableModel getAllStaff() {

        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_data_staff";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "NS00" + resultData.getInt("id"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("jobdesk"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
