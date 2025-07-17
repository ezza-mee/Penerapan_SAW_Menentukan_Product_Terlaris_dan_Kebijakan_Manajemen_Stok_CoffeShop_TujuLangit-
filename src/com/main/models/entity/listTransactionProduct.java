package com.main.models.entity;

public class listTransactionProduct {
    public int idProduct;
    public String nameProduct;
    public int quantity;
    public int priceProduct;
    public int subPrice;

    public listTransactionProduct(int idProduct, String nameProduct, int quantity, int priceProduct, int subPrice) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.priceProduct = priceProduct;
        this.subPrice = subPrice;
    }

    public int getIdProduct() {
        return idProduct;
    }
}
