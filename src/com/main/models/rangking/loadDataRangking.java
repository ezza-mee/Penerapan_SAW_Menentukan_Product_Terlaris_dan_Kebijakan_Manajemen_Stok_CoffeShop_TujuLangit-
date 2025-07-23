package com.main.models.rangking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;

public class loadDataRangking {
    public static DefaultTableModel getAllDataRangking() {
        String[] dataHeader = {
                "ID", "ID Product", "Product", "score", "rank", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_rangking WHERE DATE(periode) = CURDATE() ORDER BY `rank` ASC";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idRangking"),
                        resultData.getInt("idNormalisation"),
                        resultData.getString("product"),
                        String.format("%.2f", resultData.getDouble("score")),
                        resultData.getInt("rank"),
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

    public static DefaultTableModel getAllDataRangkingByPeriode(String periode) {
        String[] dataHeader = {
                "ID", "ID Product", "Product", "score", "rank", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_rangking WHERE periode = ? ORDER BY  `rank` ASC";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, periode);
            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idRangking"),
                        resultData.getInt("idNormalisation"),
                        resultData.getString("product"),
                        String.format("%.2f", resultData.getDouble("score")),
                        resultData.getInt("rank"),
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

    public static boolean isDataRankingExistForNormalisation(String periode, int idNormalisation) {
        String query = "SELECT COUNT(*) AS total FROM tbl_data_rangking WHERE periode = ? AND idNormalisation = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, periode);
            stmt.setInt(2, idNormalisation);
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
