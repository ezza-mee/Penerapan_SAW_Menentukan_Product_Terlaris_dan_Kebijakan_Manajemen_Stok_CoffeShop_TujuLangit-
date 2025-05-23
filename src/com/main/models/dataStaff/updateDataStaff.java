package com.main.models.dataStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateDataStaff {
    public static boolean updateStaff(int idStaff, String nameStaff, String email, String phoneNumber, String gender,
            String jobdesk, String address) {
        String query = "UPDATE tbl_data_staff SET name = ?, email = ?, phoneNumber = ?, gender = ?, jobdesk = ?, address = ?, status =  'Inactive' WHERE idStaff = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nameStaff);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setString(4, gender);
            stmt.setString(5, jobdesk);
            stmt.setString(6, address);
            stmt.setInt(7, idStaff);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Integer updateStaffAndReturnId(
            int idStaff,
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address) {

        String query = "UPDATE tbl_data_staff SET name = ?, email = ?, phoneNumber = ?, gender = ?, jobdesk = ?, address = ?, status =  'Inactive' WHERE idStaff = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, nameStaff);
            state.setString(2, email);
            state.setString(3, phoneNumber);
            state.setString(4, gender);
            state.setString(5, jobdesk);
            state.setString(6, address);
            state.setInt(7, idStaff);

            int affectedRows = state.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("UPDATE gagal: idStaff " + idStaff + " tidak ditemukan.");
                return idStaff;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
