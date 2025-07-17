package com.main.models.alternatif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataAlternatif;

public class loadDataAlternatif {
    public static DefaultTableModel getAllDataAlternatif() {
        String[] dataHeader = {
                "ID Alternatif",  "ID Transaction", "ID Detail",  "ID Produck", "Product", "Price Product", "quantity",
                "subTotal", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_alternatif WHERE DATE(lastUpdate) = CURDATE() ORDER BY lastUpdate DESC";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idAlternatif"),
                        resultData.getInt("idTransaction"),
                        resultData.getInt("idDetailTransaction"),
                        resultData.getInt("idProduct"),
                        resultData.getString("product"),
                        resultData.getInt("price"),
                        resultData.getInt("quantity"),
                        resultData.getInt("totalRevenue"),
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

    public static DefaultTableModel getAllDataAlternatifByPeriode(String periode) {
        String[] dataHeader = {
                "ID Alternatif", "ID Produk", "ID Transaction", "ID Detail", "Product", "price", "quantity",
                "total Revenue", "Frekuensi", "Periode", "Last Update"
        };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM tbl_data_alternatif WHERE periode = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, periode);
            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "DK00" + resultData.getInt("idAlternatif"),
                        resultData.getInt("idTransaction"),
                        resultData.getInt("idDetailTransaction"),
                        resultData.getInt("idProduct"),
                        resultData.getString("product"),
                        resultData.getInt("price"),
                        resultData.getInt("quantity"),
                        resultData.getInt("totalRevenue"),
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

    public static List<dataAlternatif> getListAlternatifByPeriode(String periode) {
        List<dataAlternatif> list = new ArrayList<>();
        String query = "SELECT * FROM tbl_data_Alternatif WHERE periode = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, periode);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataAlternatif k = new dataAlternatif(
                        rs.getInt("idAlternatif"),
                        rs.getString("product"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getInt("totalRevenue"),
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
