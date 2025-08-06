package com.main.models.entity;

public class dataSupplier {
    private int idSupplier;
    private int idStaff;
    private double quantity;
    private String nameSupplier, unit, description;

    public dataSupplier(int idSupplier, int idStaff, String nameSupplier, double quantity, String unit, String description) {
        this.idSupplier = idSupplier;
        this.idStaff = idStaff;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public int getIdStaff() {
        return idStaff;
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

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.nameSupplier;
    }

}
