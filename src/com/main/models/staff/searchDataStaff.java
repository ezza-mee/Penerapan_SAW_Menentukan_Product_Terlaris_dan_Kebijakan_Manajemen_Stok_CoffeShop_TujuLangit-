package com.main.models.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.models.connectionDatabase;
import com.main.models.entity.dataStaff;

public class searchDataStaff {
    public static ArrayList<dataStaff> searchStaff(String keyword) {
        ArrayList<dataStaff> dataStaff = new ArrayList<>();
        try {
            Connection conn = connectionDatabase.getConnection();
            String query = "SELECT * FROM tbl_data_staff WHERE idStaff LIKE ? OR date LIKE ? OR name LIKE ? OR email LIKE ? OR phoneNumber LIKE ? OR gender LIKE ? OR jobdesk LIKE ? OR address LIKE ? OR status LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            String pattern = "%" + keyword + "%";
            for (int i = 1; i <= 9; i++) {
                stmt.setString(i, pattern);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dataStaff staff = new dataStaff(
                        rs.getInt("idStaff"),
                        rs.getString("date"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("gender"),
                        rs.getString("jobdesk"),
                        rs.getString("address"),
                        rs.getString("status"));
                dataStaff.add(staff);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataStaff;
    }
}
