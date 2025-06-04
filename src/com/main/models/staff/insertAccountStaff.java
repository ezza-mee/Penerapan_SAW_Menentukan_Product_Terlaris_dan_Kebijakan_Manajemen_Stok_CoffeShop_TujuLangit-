package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertAccountStaff {
    public static boolean insertAccount(int idStaff, String email, String password, String jobdesk) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_account_staff (idStaff, date, email, password, jobdesk) VALUES (?, now(), ?, ?, ?)";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setInt(1, idStaff);
            state.setString(2, email);
            state.setString(3, password);
            state.setString(4, jobdesk);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
