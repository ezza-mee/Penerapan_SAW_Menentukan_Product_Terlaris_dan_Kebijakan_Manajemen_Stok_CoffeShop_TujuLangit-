package com.main.models.alternatif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.models.connectionDatabase;

public class getPeriodeTransaction {
    public static String getPeriodeByTransaction(int idTransaction) {
        String periode = null;

        String query = """
                SELECT DISTINCT
                    DATE(dt.date) AS periode,
                    dt.idTransaction,
                    ddt.idProduct,
                    da.idAlternatif
                FROM tbl_data_transaction dt
                JOIN tbl_detail_transaction ddt ON dt.idTransaction = ddt.idTransaction
                JOIN tbl_data_alternatif da ON ddt.idProduct = da.idProduct
                WHERE dt.idTransaction = ?
                LIMIT 1
                """;

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idTransaction);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                periode = rs.getString("periode");

                // Debug info
                System.out.println("DEBUG: idTransaction: " + rs.getInt("idTransaction"));
                System.out.println("DEBUG: idDetailTransaction: " + rs.getInt("idProduct"));
                System.out.println("DEBUG: idAlternatif: " + rs.getInt("idAlternatif"));
                System.out.println("DEBUG: Periode: " + periode);
            } else {
                System.out.println("❌ Tidak ada data yang cocok untuk idTransaction: " + idTransaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return periode;
    }

    public static List<Integer> getIdProductsByTransaction(int idTransaction) {
        List<Integer> idProducts = new ArrayList<>();
        String query = "SELECT idProduct FROM tbl_detail_transaction WHERE idTransaction = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idTransaction);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                idProducts.add(rs.getInt("idProduct"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idProducts;
    }

}
