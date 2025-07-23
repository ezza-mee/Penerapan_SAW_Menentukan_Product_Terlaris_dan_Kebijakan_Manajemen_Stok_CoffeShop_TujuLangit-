package com.main.models.normalisation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;

public class loadDataNormalisation {
    public static DefaultTableModel getAllDataNormalisation() {
        String[] dataHeader = {
                "ID", "ID Alternatif", "Product", "Price Product", "quantity",
                "subTotal", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_normalisation WHERE DATE(periode) = CURDATE() ORDER BY periode DESC";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idNormalisation"),
                        resultData.getInt("idAlternatif"),
                        resultData.getString("product"),
                        String.format("%.2f", resultData.getDouble(
                                "K1")),
                        String.format("%.2f", resultData.getDouble(
                                "K2")),
                        String.format("%.2f", resultData.getDouble(
                                "K3")),
                        String.format("%.2f", resultData.getDouble(
                                "K4")),
                        resultData.getString("periode"),
                        resultData.getString("createAt")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataNormalisationByPeriode(String periode) {
        String[] dataHeader = {
                "ID", "ID Alternatif", "Product", "Price Product", "quantity",
                "subTotal", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_normalisation WHERE periode = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, periode);
            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idNormalisation"),
                        resultData.getInt("idAlternatif"),
                        resultData.getString("product"),
                        String.format("%.2f", resultData.getDouble(
                                "K1")),
                        String.format("%.2f", resultData.getDouble(
                                "K2")),
                        String.format("%.2f", resultData.getDouble(
                                "K3")),
                        String.format("%.2f", resultData.getDouble(
                                "K4")),
                        resultData.getString("periode"),
                        resultData.getString("createAt")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static boolean isDataNormalisationExistForAlternatif(String periode, int idAlternatif) {
        String query = "SELECT COUNT(*) AS total FROM tbl_data_normalisation WHERE periode = ? AND idAlternatif = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, periode);
            stmt.setInt(2, idAlternatif);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("total");
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
