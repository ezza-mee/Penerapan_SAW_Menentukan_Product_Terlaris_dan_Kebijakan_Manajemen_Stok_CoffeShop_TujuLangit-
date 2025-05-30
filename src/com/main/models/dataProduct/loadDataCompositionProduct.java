package com.main.models.dataProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.main.models.connectionDatabase;

public class loadDataCompositionProduct {
    public static List<listCompositionData> getDataCompositonById(int idProduct) {
        List<listCompositionData> compositionList = new ArrayList<>();
        String query = "SELECT * FROM tbl_data_composition_product WHERE idProduct = ?";

        try (Connection conn = connectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idProduct);
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                listCompositionData data = new listCompositionData(
                        rs.getInt("idSupplier"),
                        rs.getInt("idProduct"),
                        rs.getString("nameProduct"),
                        rs.getString("supplier"),
                        rs.getInt("quantity"),
                        rs.getString("unit"));
                compositionList.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return compositionList;
    }
}
