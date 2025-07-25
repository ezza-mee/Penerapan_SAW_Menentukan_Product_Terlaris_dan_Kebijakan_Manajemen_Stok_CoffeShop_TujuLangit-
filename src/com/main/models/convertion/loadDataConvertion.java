package com.main.models.convertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataConvertion;
import com.main.models.entity.dataSearchConvertion;
import com.main.models.entity.dataSearchTable;

public class loadDataConvertion {
    public static DefaultTableModel getAllDataConvertion() {

        String[] dataHeader = { "ID", "Date", "Form Unit", "To Unit", "Multiplier", "Description", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldataconvertion";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "CD00" + resultData.getInt("idConvertion"),
                        resultData.getString("date"),
                        resultData.getString("formUnit"),
                        resultData.getString("toUnit"),
                        resultData.getDouble("multiplier"),
                        resultData.getString("description") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static ArrayList<dataSearchConvertion> getAllConvertion() {
        ArrayList<dataSearchConvertion> convertionList = new ArrayList<>();
        String query = "SELECT * FROM vwalldataconvertion";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();
            while (resultData.next()) {
                dataSearchConvertion convertion = new dataSearchConvertion(
                        resultData.getInt("idConvertion"),
                        resultData.getString("date"),
                        resultData.getString("formUnit"),
                        resultData.getString("toUnit"),
                        resultData.getDouble("multiplier"),
                        resultData.getString("description"));
                convertionList.add(convertion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertionList;
    }

    public static dataConvertion getDataById(int idConvertion) {
        String query = "SELECT * FROM tbl_unit_convertion WHERE idConvertion = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idConvertion);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new dataConvertion(
                        rs.getInt("idConvertion"),
                        rs.getString("formUnit"),
                        rs.getString("toUnit"),
                        rs.getDouble("multiplier"),
                        rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
