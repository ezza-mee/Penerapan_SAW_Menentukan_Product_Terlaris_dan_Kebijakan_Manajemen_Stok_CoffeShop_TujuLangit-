package com.main.models.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.models.entity.dataSearchTable;
import com.main.models.entity.dataStaff;
import com.main.models.entity.dataTable;
import com.main.models.connectionDatabase;

public class searchDataTable {
    public static ArrayList<dataSearchTable> searchTable(String keyword) {
        ArrayList<dataSearchTable> tableList = new ArrayList<>();
        try (Connection conn = connectionDatabase.getConnection()) {
            String query = "SELECT * FROM vwalldatatable WHERE " +
                    "CAST(idTable AS CHAR) LIKE ? OR " +
                    "date LIKE ? OR " +
                    "number LIKE ? OR " +
                    "capacity LIKE ? OR " +
                    "description LIKE ? OR " +
                    "status LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            String pattern = "%" + keyword + "%";
            for (int i = 1; i <= 6; i++) {
                stmt.setString(i, pattern);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dataSearchTable table = new dataSearchTable(
                        rs.getInt("idTable"),
                        rs.getString("number"),
                        rs.getString("capacity"),
                        rs.getString("description"),
                        rs.getString("status"));
                tableList.add(table);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    public static ArrayList<dataSearchTable> searchTableByKeywordAndStatus(String keyword, String status) {
        ArrayList<dataSearchTable> tableList = new ArrayList<>();
        try (Connection conn = connectionDatabase.getConnection()) {
            String query = "SELECT * FROM vwalldatatable WHERE " +
                    "(CAST(idTable AS CHAR) LIKE ? OR " +
                    "date LIKE ? OR " +
                    "number LIKE ? OR " +
                    "capacity LIKE ? OR " +
                    "description LIKE ? OR " +
                    "status LIKE ?) " +
                    "AND status = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            String pattern = "%" + keyword + "%";
            for (int i = 1; i <= 6; i++) {
                stmt.setString(i, pattern);
            }
            stmt.setString(7, status); // parameter ke-7 = status filter

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dataSearchTable table = new dataSearchTable(
                        rs.getInt("idTable"),
                        rs.getString("number"),
                        rs.getString("capacity"),
                        rs.getString("description"),
                        rs.getString("status"));
                tableList.add(table);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

}
