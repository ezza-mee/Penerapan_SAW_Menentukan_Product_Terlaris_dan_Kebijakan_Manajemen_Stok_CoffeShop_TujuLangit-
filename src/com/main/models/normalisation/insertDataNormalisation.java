package com.main.models.normalisation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import com.main.models.connectionDatabase;

public class insertDataNormalisation {

    public static boolean insertNormalisation(
            int idAlternatif,
            String product,
            double k1, double k2, double k3, double k4,
            String periode) {
        String query = "INSERT INTO tbl_data_normalisation (idAlternatif, product, K1, K2, K3, K4, periode, createAt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idAlternatif);
            stmt.setString(2, product);
            stmt.setDouble(3, k1);
            stmt.setDouble(4, k2);
            stmt.setDouble(5, k3);
            stmt.setDouble(6, k4);
            stmt.setString(7, periode);
            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = stmt.executeUpdate();

            System.out.println("[INSERT] Data inserted for ID Alternatif: " + idAlternatif + " | Periode: " + periode);

            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println("[ERROR][INSERT] Failed to insert data for ID Alternatif: " + idAlternatif);
            e.printStackTrace();
            return false;
        }
    }
}
