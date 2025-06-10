package com.main.models.bobotKriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import com.main.models.connectionDatabase;
import com.main.models.entity.dataConvertion;
import com.main.models.entity.dataBobotKriteria;

public class loadDataBobotKriteria {
    public static DefaultTableModel getAllDataBobotKriteria() {

        String[] dataHeader = { "ID", "Kriteria", "Weight", "Type", "Date", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_data_kriteria_weight";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "BK00" + resultData.getInt("idWeight"),
                        resultData.getString("Kriteria"),
                        resultData.getDouble("weight"),
                        resultData.getString("type"),
                        resultData.getString("lastUpdate") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static dataBobotKriteria getDataById(int idWeight) {
        String query = "SELECT * FROM tbl_data_kriteria_weight WHERE idWeight = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idWeight);
            ResultSet resultData = state.executeQuery();

            if (resultData.next()) {
                return new dataBobotKriteria(
                        resultData.getInt("idWeight"),
                        resultData.getString("Kriteria"),
                        resultData.getDouble("weight"),
                        resultData.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getWeightById(int idWeight) {
        double weight = 0.0;
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("SELECT weight FROM tbl_data_kriteria_weight WHERE idWeight = ?")) {
            stmt.setInt(1, idWeight);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                weight = rs.getDouble("weight");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weight;
    }

    public static boolean isTotalWeightExceedingLimit(double newWeight, double oldWeight) {
        double currentTotal = 0.0;

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("SELECT SUM(weight) AS weight FROM tbl_data_kriteria_weight");
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                currentTotal = rs.getDouble("weight");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        double adjustedTotal = (currentTotal - oldWeight) + newWeight;

        return adjustedTotal > 1.0;
    }

    public static double getTotalWeight() {
        double total = 0.0;
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("SELECT SUM(weight) AS weight FROM tbl_data_kriteria_weight");
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("weight");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

}
