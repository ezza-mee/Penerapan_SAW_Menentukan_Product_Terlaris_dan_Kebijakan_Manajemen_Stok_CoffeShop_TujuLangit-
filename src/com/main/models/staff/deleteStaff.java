package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteStaff {
    public static boolean resignStaff(int idStaff) {
        boolean data = false;

        String query = "UPDATE tbl_data_staff SET status = 'Resign' WHERE idStaff = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idStaff);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
