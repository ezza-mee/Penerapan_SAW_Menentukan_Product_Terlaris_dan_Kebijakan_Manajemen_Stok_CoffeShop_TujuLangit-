package com.main.services;

import java.util.ArrayList;
import java.util.List;

import com.main.models.table.deleteTable;
import com.main.models.table.insertTable;
import com.main.models.table.updateTable;
import com.main.models.table.loadDataTable;
import com.main.models.table.searchDataTable;
import com.main.models.entity.dataSearchTable;
import com.main.models.entity.dataTable;

public class authDataTable {

    public static ArrayList<dataSearchTable> searchTableByKeywordAndStatus(String keyword, String status) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataTable.searchTableByKeywordAndStatus(keyword.trim(), status);
    }

    public static ArrayList<dataSearchTable> searchTableByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataTable.searchTable(keyword.trim());
    }

    public static boolean insertDataTable(String number, String capacity, String description) {
        return insertTable.insertData(number, capacity, description);
    }

    public static boolean updateDataTable(int idTable, String number, String capacity, String description) {
        return updateTable.updateData(idTable, number, capacity, description);
    }

    public static boolean deleteDataTable(int idTable) {
        return deleteTable.deleteData(idTable);
    }

    public static boolean updateStatusTable(int idTable, String status) {
        return updateTable.updateStatusOnly(idTable, status);
    }

    public static List<dataTable> loadDataTable() {
        return loadDataTable.getAllAvailableNumberTable();
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
