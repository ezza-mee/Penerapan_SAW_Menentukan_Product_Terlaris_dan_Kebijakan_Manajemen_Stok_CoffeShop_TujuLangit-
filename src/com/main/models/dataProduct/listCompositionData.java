package com.main.models.dataProduct;

public class listCompositionData {
    public int idSupplier;
    public String nameSupplier;
    public int quantity;
    public String unit;

    public listCompositionData(int idSupplier, String nameSupplier, int quantity, String unit) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
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
}
