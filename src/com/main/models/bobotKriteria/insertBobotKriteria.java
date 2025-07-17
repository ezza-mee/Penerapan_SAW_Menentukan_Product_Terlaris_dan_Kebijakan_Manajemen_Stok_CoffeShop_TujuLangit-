package com.main.models.bobotKriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertBobotKriteria {
    public static boolean insertData(String kriteria, double weight, String type) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_kriteria (kriteria, weight, type, lastUpdate) VALUES (?, ?, ?, NOW())";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setString(1, kriteria);
            state.setDouble(2, weight);
            state.setString(3, type);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
