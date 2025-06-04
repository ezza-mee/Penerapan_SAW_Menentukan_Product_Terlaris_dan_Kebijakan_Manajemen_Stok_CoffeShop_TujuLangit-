package com.main.models.entity;

public class dataProduct {
    private int idProduct;
    private byte[] imageData;
    private String nameProduct;
    private int price;
    private String category;
    private String description;
    private String status;

    public dataProduct(int idProduct, byte[] imageData, String nameProduct, int price, String category,
            String description, String status) {
        this.idProduct = idProduct;
        this.imageData = imageData;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.description = description;
        this.status = status;

    }

    public int getIdProduct() {
        return idProduct;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

}
