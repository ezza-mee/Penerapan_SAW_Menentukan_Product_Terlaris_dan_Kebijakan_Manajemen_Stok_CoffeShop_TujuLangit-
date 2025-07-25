package com.main.models.entity;

public class dataSearchTable {
    private int idTable;
    private String number;
    private String capacity;
    private String description;
    private String status;

    public dataSearchTable(int idTable, String number, String capacity, String description, String status) {
        this.idTable = idTable;
        this.number = number;
        this.capacity = capacity;
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
