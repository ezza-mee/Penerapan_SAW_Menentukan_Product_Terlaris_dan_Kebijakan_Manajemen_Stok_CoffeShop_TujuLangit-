package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateAccountStaff {
    public static boolean updateAccount(int idStaff, String email, String password, String jobdesk) {
        String query = "UPDATE tbl_data_account_staff SET email = ?, password = ?, jobdesk = ? WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, jobdesk);
            stmt.setInt(4, idStaff);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
