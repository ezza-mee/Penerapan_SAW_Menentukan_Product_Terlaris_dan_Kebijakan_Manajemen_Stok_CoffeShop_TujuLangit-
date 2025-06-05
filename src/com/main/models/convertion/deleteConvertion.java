package com.main.models.convertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteConvertion {
    public static boolean deleteData(int idConvertion) {
        boolean success = false;

        String query = "DELETE FROM tbl_unit_convertion WHERE idConvertion = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idConvertion);
            int result = stmt.executeUpdate();
            success = result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

}
