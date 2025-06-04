package com.main.models.supplier;

public class dataSupplier {
    private int idSupplier;
    private int quantity;
    private String nameSupplier, unit, description;

    public dataSupplier(int idSupplier, String nameSupplier, int quantity, String unit, String description) {
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

    public int getQuantity() {
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
