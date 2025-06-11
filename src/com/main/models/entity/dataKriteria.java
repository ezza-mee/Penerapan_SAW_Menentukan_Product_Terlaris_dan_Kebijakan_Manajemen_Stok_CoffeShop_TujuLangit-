package com.main.models.entity;

public class dataKriteria {
    public int idKriteria;
    public String product;
    public int price;
    public int quantity;
    public double outStock;
    public int frekuensi;
    public String periode;

    public dataKriteria(int idKriteria, String product, int price, int quantity, double outStock, int frekuensi,
            String periode) {
        this.idKriteria = idKriteria;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.outStock = outStock;
        this.frekuensi = frekuensi;
        this.periode = periode;
    }

    public int getIdKriteria() {
        return idKriteria;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getOutStock() {
        return outStock;
    }

    public int getPrice() {
        return price;
    }

    public int getFrekuensi() {
        return frekuensi;
    }

    public String getPeriode() {
        return periode;
    }

}
