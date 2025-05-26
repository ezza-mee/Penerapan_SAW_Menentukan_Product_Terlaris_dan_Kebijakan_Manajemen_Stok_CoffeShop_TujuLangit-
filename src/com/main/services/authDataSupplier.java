package com.main.services;

import com.main.models.dataSupplier.insertDataSupplier;

public class authDataSupplier {

    public static boolean insertSupplier(
            String nameSupplier,
            int quantity,
            String unitSupplier,
            String description) {

        return insertDataSupplier.insertSupplier(nameSupplier, quantity, unitSupplier, description);
    }

    public String validateSupplierInput(String nameSupplier, int quantity, String unitSupplier, String description) {
        if ((nameSupplier == null || nameSupplier.isEmpty()) ||
                (quantity <= 0) ||
                (unitSupplier == null || unitSupplier.isEmpty()) ||
                (description == null || description.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (nameSupplier == null || nameSupplier.isEmpty()) {
            return "NAME_SUPPLIER_EMPTY";
        } else if (quantity <= 0) {
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
