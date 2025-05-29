package com.main.services;

import com.main.models.dataSupplier.insertDataSupplier;

import java.util.List;

import com.main.models.dataSupplier.deleteDataSupplier;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.models.dataSupplier.updateDataSupplier;
import com.main.models.dataSupplier.loadDataSupplier;

public class authDataSupplier {

    public static boolean insertDataSupplier(
            String nameSupplier,
            int quantity,
            String unitSupplier,
            String description) {

        return insertDataSupplier.insertSupplier(nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean updateDataSupplier(
            int supplierId,
            String nameSupplier,
            int quantity,
            String unitSupplier,
            String description) {

        return updateDataSupplier.updateSupplier(supplierId, nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean deleteDataSupplier(int supplierId, int quantity) {
        return deleteDataSupplier.deleteSupplier(supplierId, quantity);
    }

    public static List<getterDataSupplier> loadDataSupplier() {
        return loadDataSupplier.getAllReadySupplierNames();
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
            return "QUANTITY_INVALID";
        } else if (unitSupplier == null || unitSupplier.isEmpty()) {
            return "UNIT_EMPTY";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_EMPTY";
        } else {
            return "VALID";
        }
    }

}
