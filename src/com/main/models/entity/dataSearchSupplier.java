package com.main.models.entity;

public class dataSearchSupplier {
    private int idSupplier;
    private double quantity;
    private String nameStaff, nameSupplier, unit, status, date, dateApprove;

    public dataSearchSupplier(int idSupplier, String nameStaff, String nameSupplier, double quantity, String unit,
            String status, String date, String dateApprove) {
        this.idSupplier = idSupplier;
        this.nameStaff = nameStaff;
        this.nameSupplier = nameSupplier;
        this.quantity = quantity;
        this.unit = unit;
        this.status = status;
        this.date = date;
        this.dateApprove = dateApprove;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getDateApprove() {
        return dateApprove;
    }

    @Override
    public String toString() {
        return this.nameSupplier;
    }

}
