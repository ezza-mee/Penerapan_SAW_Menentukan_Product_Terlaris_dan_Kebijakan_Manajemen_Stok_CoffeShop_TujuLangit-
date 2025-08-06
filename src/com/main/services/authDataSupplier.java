package com.main.services;

import java.util.ArrayList;
import java.util.List;

import com.main.models.entity.dataSearchSupplier;
import com.main.models.entity.dataSupplier;
import com.main.models.entity.dataSupplierReady;
import com.main.models.supplier.deleteSupplier;
import com.main.models.supplier.insertSupplier;
import com.main.models.supplier.loadDataSupplier;
import com.main.models.supplier.searchDataSupplier;
import com.main.models.supplier.updateSupplier;

public class authDataSupplier {

    public static ArrayList<dataSearchSupplier> searchSupplierByKeywordAndStatus(String keyword, String status) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataSupplier.searchSupplierByStatus(keyword.trim(), status);
    }

    public static ArrayList<dataSearchSupplier> searchSupplierByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataSupplier.searchSupplier(keyword.trim());
    }

    public static boolean insertDataSupplier(
            int idStaff,
            String nameSupplier,
            double quantity,
            String unitSupplier,
            String description) {

        return insertSupplier.insertData(idStaff, nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean updateDataSupplier(
            int supplierId,
            int idStaff,
            String nameSupplier,
            double quantity,
            String unitSupplier,
            String description) {

        return updateSupplier.updateData(supplierId, idStaff, nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean deleteDataSupplier(int supplierId, double quantity) {
        return deleteSupplier.deleteData(supplierId, quantity);
    }

    public static List<dataSupplierReady> loadDataSupplier() {
        return loadDataSupplier.getAllReadySupplierNames();
    }

    public static boolean updateStatusSupplier(int idSupplier, String status) {
        return updateSupplier.approveSupplier(idSupplier, status);
    }

    public String validateSupplierInput(String nameSupplier, String quantity, String unitSupplier, String description) {
        if ((nameSupplier == null || nameSupplier.isEmpty()) &&
                (quantity == null || quantity.isEmpty()) &&
                (unitSupplier == null || unitSupplier.isEmpty()) &&
                (description == null || description.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (nameSupplier == null || nameSupplier.isEmpty()) {
            return "NAME_SUPPLIER_EMPTY";
        } else if (quantity == null || quantity.isEmpty()) {
            return "QUANTITY_EMPTY";
        } else if (unitSupplier == null || unitSupplier.isEmpty()) {
            return "UNIT_EMPTY";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_EMPTY";
        } else {
            return "VALID";
        }
    }

}
