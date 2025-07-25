package com.main.models.entity;

public class dataSearchSupplier {
    private int idSupplier;
    private double quantity;
    private String date, nameSupplier, unit, status;

    public dataSearchSupplier(int idSupplier, String date, String nameSupplier, double quantity, String unit,
            String status) {
        this.idSupplier = idSupplier;
        this.date = date;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
        this.status = status;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public String getDate() {
        return date;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.nameSupplier;
    }

}
