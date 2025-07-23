package com.main.models.normalisation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import com.main.models.connectionDatabase;

public class updateDataNormalisation {

    public static boolean updateNormalisation(
            int idAlternatif,
            String product,
            double k1, double k2, double k3, double k4,
            String periode) {
        String query = "UPDATE tbl_data_normalisation SET product = ?, K1 = ?, K2 = ?, K3 = ?, K4 = ?, createAt = ? "
                + "WHERE idAlternatif = ? AND periode = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product);
            stmt.setDouble(2, k1);
            stmt.setDouble(3, k2);
            stmt.setDouble(4, k3);
            stmt.setDouble(5, k4);
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(7, idAlternatif);
            stmt.setString(8, periode);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("[UPDATE] Data updated for ID Alternatif: " + idAlternatif + " | Periode: " + periode);

            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println("[ERROR][UPDATE] Failed to update data for ID Alternatif: " + idAlternatif);
            e.printStackTrace();
            return false;
        }
    }
}
