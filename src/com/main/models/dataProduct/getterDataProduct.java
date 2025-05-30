package com.main.models.dataProduct;

public class getterDataProduct {
    private int idProduct;
    private byte[] imageData;
    private String nameProduct;
    private int price;
    private String category;
    private String description;

    public getterDataProduct(int idProduct, byte[] imageData, String nameProduct, int price, String category,
            String description) {
        this.idProduct = idProduct;
        this.imageData = imageData;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.description = description;

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

}
