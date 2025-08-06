package com.main.models.entity;

public class dataSupplierReady {
    private int idSupplier;
    private double quantity;
    private String nameSupplier, unit, description;

    public dataSupplierReady(int idSupplier, String nameSupplier, double quantity, String unit,
            String description) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
    }

    public int getIdSupplier() {
        return idSupplier;
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