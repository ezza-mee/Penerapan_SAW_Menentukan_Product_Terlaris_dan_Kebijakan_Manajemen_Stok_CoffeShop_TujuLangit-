package com.main.models.entity;

public class dataAlternatif {
    public int idAlternatif;
    public String product;
    public int price;
    public int quantity;
    public double outStock;
    public int frekuensi;
    public String periode;

    public dataAlternatif(int idAlternatif, String product, int price, int quantity, double outStock, int frekuensi,
            String periode) {
        this.idAlternatif = idAlternatif;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.outStock = outStock;
        this.frekuensi = frekuensi;
        this.periode = periode;
    }

    public int getIdAlternatif() {
        return idAlternatif;
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
