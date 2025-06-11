package com.main.models.kriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataKriteria;

public class loadDataKriteria {
    public static DefaultTableModel getAllDataKriteria() {
        String[] dataHeader = {
                "ID Kriteria", "ID Produk", "ID Transaction", "ID Datail", "ID Out Stock", "Produk", "Harga", "Jumlah",
                "Out Stock", "Unit", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_kriteria WHERE DATE(lastUpdate) = CURDATE() ORDER BY lastUpdate DESC";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idKriteria"),
                        resultData.getInt("idProduct"),
                        resultData.getInt("idTransaction"),
                        resultData.getInt("idDetail"),
                        resultData.getInt("idOutStock"),
                        resultData.getString("product"),
                        resultData.getInt("price"),
                        resultData.getInt("quantity"),
                        String.format("%.2f", resultData.getDouble("outStock")),
                        resultData.getString("unit"),
                        resultData.getInt("frekuensi"),
                        resultData.getString("periode"),
                        resultData.getTimestamp("lastUpdate")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataKriteriaByPeriode(String periode) {
        String[] dataHeader = {
                "ID Kriteria", "ID Produk", "ID Transaction", "ID Datail", "ID Out Stock", "Produk", "Harga", "Jumlah",
                "Out Stock", "Unit", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_kriteria WHERE periode = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, periode);
            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idKriteria"),
                        resultData.getInt("idProduct"),
                        resultData.getInt("idTransaction"),
                        resultData.getInt("idDetail"),
                        resultData.getInt("idOutStock"),
                        resultData.getString("product"),
                        resultData.getInt("price"),
                        resultData.getInt("quantity"),
                        String.format("%.2f", resultData.getDouble("outStock")),
                        resultData.getString("unit"),
                        resultData.getInt("frekuensi"),
                        resultData.getString("periode"),
                        resultData.getTimestamp("lastUpdate")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static List<dataKriteria> getListKriteriaByPeriode(String periode) {
        List<dataKriteria> list = new ArrayList<>();
        String query = "SELECT * FROM tbl_data_kriteria WHERE periode = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, periode);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataKriteria k = new dataKriteria(
                        rs.getInt("idKriteria"),
                        rs.getString("product"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getDouble("outStock"),
                        rs.getInt("frekuensi"),
                        rs.getString("periode"));
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
