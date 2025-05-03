package com.main.components;

public class appIcons {

    private imageIcon loadIcon(String path, int width, int height) {
        return new imageIcon(path, width, height);
    }

    public imageIcon getUsernameIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/username(green).png", width, height);
    }

    public imageIcon getPasswordIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/password(green).png", width, height);
    }

    public imageIcon getShowPasswordIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/showPassword(green).png", width, height);
    }

    public imageIcon getHidePasswordIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/hidePassword(green).png", width, height);
    }

    public imageIcon getExitIconRed(int width, int height) {
        return loadIcon("src/com/main/resources/images/iconExit(red).png", width, height);
    }

    public imageIcon getExitIconWhite(int width, int height) {
        return loadIcon("src/com/main/resources/images/exit(white).png", width, height);
    }

    public imageIcon getCoffeAppIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/latte-art.png", width, height);
    }

    public imageIcon getCoffeOneIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/coffee-beans.png", width, height);
    }

    public imageIcon getCoffeTwoIcon(int width, int height) {
        return loadIcon("src/com/main/resources/images/coffe.png", width, height);
    }

    public imageIcon getHomeIconHover(int width, int height) {
        return loadIcon("src/com/main/resources/images/home(green).png", width, height);
    }

    public imageIcon getHomeIconDefault(int width, int height) {
        return loadIcon("src/com/main/resources/images/home(white).png", width, height);
    }

    public imageIcon getProductIconHover(int width, int height) {
        return loadIcon("src/com/main/resources/images/product(green).png", width, height);
    }

    public imageIcon getProductIconDefault(int width, int height) {
        return loadIcon("src/com/main/resources/images/product(white).png", width, height);
    }

    public imageIcon getSupplierIconHover(int width, int height) {
        return loadIcon("src/com/main/resources/images/Supplier(green).png", width, height);
    }

    public imageIcon getSupplierIconDefault(int width, int height) {
        return loadIcon("src/com/main/resources/images/Supplier(white).png", width, height);
    }

    public imageIcon getStaffIconHover(int width, int height) {
        return loadIcon("src/com/main/resources/images/staff(green).png", width, height);
    }

    public imageIcon getStaffIconDefault(int width, int height) {
        return loadIcon("src/com/main/resources/images/staff(white).png", width, height);
    }

    public imageIcon getTransactionIconHover(int width, int height) {
        return loadIcon("src/com/main/resources/images/transaction(green).png", width, height);
    }

    public imageIcon getTransactionIconDefault(int width, int height) {
        return loadIcon("src/com/main/resources/images/transaction(white).png", width, height);
    }
}
