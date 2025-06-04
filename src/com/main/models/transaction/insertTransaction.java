package com.main.models.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.main.models.connectionDatabase;

public class insertTransaction {
    public static int insertData(int idStaff, int idTable, String staff, String numberTable, String customer,
            int subQuantity, int subPrice, String description, String payment) {
        int generatedId = -1;

        String query = "INSERT INTO tbl_data_transaction (idStaff, idTable, date, staff, numberTable, customer, subQuantity, subPrice, description, payment) VALUES (?, ?, now(), ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            state.setInt(1, idStaff);
            state.setInt(2, idTable);
            state.setString(3, staff);
            state.setString(4, numberTable);
            state.setString(5, customer);
            state.setInt(6, subQuantity);
            state.setInt(7, subPrice);
            state.setString(8, description);
            state.setString(9, payment);

            int rows = state.executeUpdate();

            if (rows > 0) {
                ResultSet rs = state.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
}
