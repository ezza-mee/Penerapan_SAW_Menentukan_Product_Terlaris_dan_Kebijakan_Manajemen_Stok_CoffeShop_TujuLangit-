package com.main.models.dataStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;

public class loadDataStaff {
    public static DefaultTableModel getAllDataStaff() {

        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatastaff WHERE status IN ('Active', 'Inactive')";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = {
                        "NS00" + resultData.getInt("idStaff"),
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

    public static ArrayList<getterDataStaff> getAllStaff() {
        ArrayList<getterDataStaff> staffList = new ArrayList<>();
        String query = "SELECT * FROM vwalldatastaff WHERE status IN ('Active', 'Inactive')";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();
            while (resultData.next()) {
                getterDataStaff staff = new getterDataStaff(
                        resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("Email"),
                        resultData.getString("phoneNumber"),
                        resultData.getString("gender"),
                        resultData.getString("jobdesk"),
                        resultData.getString("address"),
                        resultData.getString("status"));
                staffList.add(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staffList;
    }

    public static getterDataStaff getDataById(int idStaff) {
        String query = "SELECT * FROM tbl_data_staff WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new getterDataStaff(
                        rs.getInt("idStaff"),
                        rs.getString("date"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("gender"),
                        rs.getString("jobdesk"),
                        rs.getString("address"),
                        rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static getterAccountStaff getDataAccountById(int idStaff) {
        String query = "SELECT * FROM tbl_data_account_staff WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new getterAccountStaff(
                        rs.getInt("idAccount"),
                        rs.getInt("idStaff"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
