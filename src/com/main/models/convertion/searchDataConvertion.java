package com.main.models.convertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.main.models.entity.dataSearchConvertion;
import com.main.models.connectionDatabase;

public class searchDataConvertion {
    public static ArrayList<dataSearchConvertion> searchConvertion(String keyword) {
        ArrayList<dataSearchConvertion> convertionList = new ArrayList<>();
        String query = "SELECT * FROM vwalldataconvertion " +
                "WHERE LOWER(formUnit) LIKE ? OR LOWER(toUnit) LIKE ? " +
                "OR LOWER(description) LIKE ? OR CAST(multiplier AS CHAR) LIKE ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            String pattern = "%" + keyword.toLowerCase() + "%";
            for (int i = 1; i <= 4; i++) {
                stmt.setString(i, pattern);
            }

            ResultSet resultData = stmt.executeQuery();
            while (resultData.next()) {
                dataSearchConvertion convertion = new dataSearchConvertion(
                        resultData.getInt("idConvertion"),
                        resultData.getString("date"),
                        resultData.getString("formUnit"),
                        resultData.getString("toUnit"),
                        resultData.getDouble("multiplier"),
                        resultData.getString("description"));
                convertionList.add(convertion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertionList;
    }

}
