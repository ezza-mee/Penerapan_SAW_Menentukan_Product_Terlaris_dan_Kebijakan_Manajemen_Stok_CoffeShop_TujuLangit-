package com.main.models.dataTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class deleteDataTable {
    public static boolean deleteTable(int idTable) {
        boolean data = false;

        String query = "UPDATE tbl_data_table SET status = 'Out Of Order' WHERE idTable = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idTable);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
