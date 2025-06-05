package com.main.models.entity;

public class listTransactionProduct {
    public int idProduct;
    public String nameProduct;
    public int quantity;
    public int price;

    public listTransactionProduct(int idProduct, String nameProduct, int quantity, int price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdProduct(){
        return idProduct;
    }
}
