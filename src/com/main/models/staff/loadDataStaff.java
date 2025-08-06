package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.main.models.connectionDatabase;
import com.main.models.entity.accountDataStaff;
import com.main.models.entity.dataStaff;
import com.main.models.entity.entityDataStaff;

public class loadDataStaff {
    public static DefaultTableModel getAllDataStaff() {

        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatastaff";
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

    public static ArrayList<dataStaff> getAllStaff() {
        ArrayList<dataStaff> staffList = new ArrayList<>();
        String query = "SELECT * FROM vwalldatastaff";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();
            while (resultData.next()) {
                dataStaff staff = new dataStaff(
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

    public static dataStaff getStaffById(int idStaff) {
        dataStaff staff = null;
        String query = "SELECT * FROM vwalldatastaff WHERE idStaff = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);
            ResultSet resultData = state.executeQuery();

            if (resultData.next()) {
                staff = new dataStaff(
                        resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("Email"),
                        resultData.getString("phoneNumber"),
                        resultData.getString("gender"),
                        resultData.getString("jobdesk"),
                        resultData.getString("address"),
                        resultData.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staff;
    }

    public static ArrayList<dataStaff> getAllStaffByStatus(String status) {
        ArrayList<dataStaff> staffList = new ArrayList<>();
        String query = "SELECT * FROM vwalldatastaff";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, status);
            ResultSet resultData = state.executeQuery();
            while (resultData.next()) {
                dataStaff staff = new dataStaff(
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

    public static DefaultTableModel getAllDataStaffActive() {
        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM vwalldatastaff WHERE status = 'Active'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "NS00" + resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("jobdesk"),
                        resultData.getString("status")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataStaffInActive() {
        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM vwalldatastaff WHERE status = 'Inactive'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "NS00" + resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("jobdesk"),
                        resultData.getString("status")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static DefaultTableModel getAllDataStaffResign() {
        String[] dataHeader = { "ID", "Date", "Name", "Jobdesk", "Status", "Aksi" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        String query = "SELECT * FROM vwalldatastaff WHERE status = 'Resign'";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "NS00" + resultData.getInt("idStaff"),
                        resultData.getString("date"),
                        resultData.getString("name"),
                        resultData.getString("jobdesk"),
                        resultData.getString("status")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static int getAllQuantityDataStaff() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_staff";

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

    public static int getAllQuantityDataStaffActive() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_staff WHERE status = 'Active'";

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

    public static int getAllQuantityDataStaffInActive() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_staff WHERE status = 'Inactive'";

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

    public static int getAllQuantityDataStaffResign() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM tbl_data_staff WHERE status = 'Resign'";

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

    public static entityDataStaff getDataStaffById(int idStaff) {
        String query = "SELECT * FROM tbl_data_staff WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new entityDataStaff(
                        rs.getInt("idStaff"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("gender"),
                        rs.getString("jobdesk"),
                        rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static accountDataStaff getDataAccountById(int idStaff) {
        String query = "SELECT * FROM tbl_data_account_staff WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                return new accountDataStaff(
                        rs.getInt("idAccount"),
                        rs.getInt("idStaff"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("jobdesk"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
