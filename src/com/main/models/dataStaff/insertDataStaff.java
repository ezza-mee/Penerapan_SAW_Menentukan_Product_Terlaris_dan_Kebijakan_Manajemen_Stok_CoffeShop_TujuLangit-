package com.main.models.dataStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertDataStaff {
    public static boolean insertStaff(String nameStaff, String email, String phoneNumber, String gender, String jobdesk,
            String address) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_staff (date, name, email, phoneNumber, gender, jobdesk, address, status) VALUES (now(), ?, ?, ?, ?, ?, ?, 'Aktif')";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setString(1, nameStaff);
            state.setString(2, email);
            state.setString(3, phoneNumber);
            state.setString(4, gender);
            state.setString(5, jobdesk);
            state.setString(6, address);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static Integer insertStaffAndGetId(String nameStaff, String email, String phoneNumber, String gender, String jobdesk, String address) {
        String query = "INSERT INTO tbl_data_staff (date, name, email, phoneNumber, gender, jobdesk, address, status) VALUES (now(), ?, ?, ?, ?, ?, ?, 'Aktif')";
    
        try (Connection conn = connectionDatabase.getConnection();
             PreparedStatement state = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
    
            state.setString(1, nameStaff);
            state.setString(2, email);
            state.setString(3, phoneNumber);
            state.setString(4, gender);
            state.setString(5, jobdesk);
            state.setString(6, address);
    
            int affectedRows = state.executeUpdate();
    
            if (affectedRows > 0) {
                try (var rs = state.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); 
                    }
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    public static boolean isEmailExist(String email) {
        String query = "SELECT COUNT(*) FROM tbl_data_staff WHERE email = ?";
        try (Connection conn = connectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean isPhoneExist(String phone) {
        String query = "SELECT COUNT(*) FROM tbl_data_staff WHERE phoneNumber = ?";
        try (Connection conn = connectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, phone);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
