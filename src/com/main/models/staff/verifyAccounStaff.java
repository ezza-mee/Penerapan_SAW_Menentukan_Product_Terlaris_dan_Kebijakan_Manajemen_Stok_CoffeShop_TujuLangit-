package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.models.connectionDatabase;
import com.main.models.entity.accountDataStaff;

public class verifyAccounStaff {
    public static accountDataStaff verifyStaffLogin(String email, String password) {
        String query = "SELECT * FROM tbl_data_account_staff WHERE email = ? AND password = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, email);
            state.setString(2, password);

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

    public static accountDataStaff verifyDataStaff(String email, String password) {
        String query = "SELECT * FROM account_data_staff WHERE email = ? AND password = ?";
        accountDataStaff staff = null;

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {
            state.setString(1, email);
            state.setString(2, password);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                int idAccount = rs.getInt("id_account");
                int idStaff = rs.getInt("id_staff");
                String role = rs.getString("role");
                staff = new accountDataStaff(idAccount, idStaff, email, password, role);
            }

            rs.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staff;
    }

}
