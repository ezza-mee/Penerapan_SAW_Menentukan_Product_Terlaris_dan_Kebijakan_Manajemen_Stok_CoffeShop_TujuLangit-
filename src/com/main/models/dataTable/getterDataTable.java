package com.main.models.dataTable;

public class getterDataTable {
    int idTable;
    String number;
    String capacity;
    String description;

    public getterDataTable(int idTable, String number, String capacity, String description) {
        this.idTable = idTable;
        this.number = number;
        this.capacity = capacity;
        this.description = description;
    }

    public int getIdtable() {
        return idTable;
    }

    public String getNumber() {
        return number;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

}
