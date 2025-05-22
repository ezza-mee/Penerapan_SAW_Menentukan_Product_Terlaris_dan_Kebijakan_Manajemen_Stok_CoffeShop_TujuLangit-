package com.main.models.dataStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.models.connectionDatabase;

public class detailDataStaff {
    public static Object[] getDetailAkunStaff(int idStaff) {
        Object[] rowData = new Object[11];

        String query = "SELECT * FROM vwalldetaildatastaff WHERE idStaff = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, idStaff);
            ResultSet resultData = statement.executeQuery();

            if (resultData.next()) {
                rowData[0] = resultData.getInt("idStaff");
                rowData[1] = resultData.getInt("idAccount");
                rowData[2] = resultData.getString("date");
                rowData[3] = resultData.getString("name");
                rowData[4] = resultData.getString("email");
                rowData[5] = resultData.getString("phoneNumber");
                rowData[6] = resultData.getString("gender");
                rowData[7] = resultData.getString("jobdesk");
                rowData[8] = resultData.getString("address");
                rowData[9] = resultData.getString("password");
                rowData[10] = resultData.getString("status");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowData;
    }
}
