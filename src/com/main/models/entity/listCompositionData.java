package com.main.models.entity;

public class listCompositionData {
    public int idSupplier;
    public int idProduct;
    public String nameProduct;
    public String nameSupplier;
    public int quantity;
    public String unit;

    public listCompositionData(int idSupplier, int idProduct, String nameProduct, String nameSupplier, int quantity,
            String unit) {
        this.idSupplier = idSupplier;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
