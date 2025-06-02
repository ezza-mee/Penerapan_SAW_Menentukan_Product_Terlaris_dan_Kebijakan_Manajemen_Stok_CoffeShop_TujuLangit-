package com.main.models.dataTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class insertDataTable {
    public static boolean insertTable(String number, String capacity, String description) {
        boolean data = false;

        String query = "INSERT INTO tbl_data_table (date, number, capacity, description, status) VALUES (now(), ?, ?, ?, 'Available')";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setString(1, number);
            state.setString(2, capacity);
            state.setString(3, description);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
