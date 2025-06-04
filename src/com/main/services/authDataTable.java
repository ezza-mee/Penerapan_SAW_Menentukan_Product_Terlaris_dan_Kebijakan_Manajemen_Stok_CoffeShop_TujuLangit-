package com.main.services;

import com.main.models.table.deleteTable;
import com.main.models.table.insertTable;
import com.main.models.table.updateTable;

public class authDataTable {
    public static boolean insertDataTable(String number, String capacity, String description) {
        return insertTable.insertData(number, capacity, description);
    }

    public static boolean updateDataTable(int idTable, String number, String capacity, String description) {
        return updateTable.updateData(idTable, number, capacity, description);
    }

    public static boolean deleteDataTable(int idTable) {
        return deleteTable.deleteData(idTable);
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
