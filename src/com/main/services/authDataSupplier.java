package com.main.services;

import java.util.List;

import com.main.models.entity.dataSupplier;
import com.main.models.supplier.deleteSupplier;
import com.main.models.supplier.insertSupplier;
import com.main.models.supplier.loadDataSupplier;
import com.main.models.supplier.updateSupplier;

public class authDataSupplier {

    public static boolean insertDataSupplier(
            String nameSupplier,
            int quantity,
            String unitSupplier,
            String description) {

        return insertSupplier.insertData(nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean updateDataSupplier(
            int supplierId,
            String nameSupplier,
            int quantity,
            String unitSupplier,
            String description) {

        return updateSupplier.updateData(supplierId, nameSupplier, quantity, unitSupplier, description);
    }

    public static boolean deleteDataSupplier(int supplierId, int quantity) {
        return deleteSupplier.deleteData(supplierId, quantity);
    }

    public static List<dataSupplier> loadDataSupplier() {
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
