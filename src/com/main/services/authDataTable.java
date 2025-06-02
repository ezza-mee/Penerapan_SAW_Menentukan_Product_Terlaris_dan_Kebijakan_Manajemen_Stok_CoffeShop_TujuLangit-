package com.main.services;

import com.main.models.dataTable.insertDataTable;
import com.main.models.dataTable.updateDataTable;
import com.main.models.dataTable.deleteDataTable;

public class authDataTable {
    public static boolean insertDataTable(String number, String capacity, String description) {
        return insertDataTable.insertTable(number, capacity, description);
    }

    public static boolean updateDataTable(int idTable, String number, String capacity, String description) {
        return updateDataTable.updateTable(idTable, number, capacity, description);
    }

    public static boolean deleteDataTable(int idTable) {
        return deleteDataTable.deleteTable(idTable);
    }

    public String validateTableInput(String number, String capacity, String description) {
        if ((number == null || number.isEmpty()) &&
                (capacity == null || capacity.isEmpty()) &&
                (description == null || description.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (number == null || number.isEmpty()) {
            return "NUMBER_EMPTY";
        } else if (capacity == null || capacity.isEmpty()) {
            return "CAPACITY_INVALID";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_EMPTY";
        } else {
            return "VALID";
        }
    }
}
