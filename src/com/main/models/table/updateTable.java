package com.main.models.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.models.connectionDatabase;

public class updateTable {
    public static boolean updateData(int idTable, String number, String capacity, String description) {
        String query = "UPDATE tbl_data_table SET number = ?, capacity = ?,  description = ?, status =  'Available' WHERE idTable = ?";
        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, number);
            stmt.setString(2, capacity);
            stmt.setString(3, description);
            stmt.setInt(4, idTable);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
