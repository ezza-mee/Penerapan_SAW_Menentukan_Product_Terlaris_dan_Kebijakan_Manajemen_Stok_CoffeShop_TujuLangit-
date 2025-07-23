package com.main.models.bobotKriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import com.main.models.connectionDatabase;
import com.main.models.entity.dataBobotKriteria;

public class loadDataBobotKriteria {
    public static DefaultTableModel getAllDataBobotKriteria() {

        String[] dataHeader = { "ID", "Kriteria", "Weight", "Type", "Date", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_data_kriteria";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "BK00" + resultData.getInt("idKriteria"),
                        resultData.getString("Kriteria"),
                        resultData.getInt("weight"),
                        resultData.getString("type"),
                        resultData.getString("lastUpdate") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static dataBobotKriteria getDataById(int idKriteria) {
        String query = "SELECT * FROM tbl_data_kriteria WHERE idKriteria = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idKriteria);
            ResultSet resultData = state.executeQuery();

            if (resultData.next()) {
                return new dataBobotKriteria(
                        resultData.getInt("idKriteria"),
                        resultData.getString("Kriteria"),
                        resultData.getInt("weight"),
                        resultData.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTipeKriteria(String idKriteria) {
        String query = "SELECT tipe FROM tbl_data_kriteria WHERE idKriteria = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idKriteria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "benefit";
    }

}
