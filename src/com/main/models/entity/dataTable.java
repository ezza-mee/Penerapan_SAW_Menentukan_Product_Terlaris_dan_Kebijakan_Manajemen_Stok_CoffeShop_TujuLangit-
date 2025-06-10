package com.main.models.entity;

public class dataTable {
    private int idTable;
    private String number;
    private String capacity;
    private String description;

    public dataTable(int idTable, String number, String capacity, String description) {
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
