package com.main.models.entity;

public class dataConvertion {
    private int idConvertion;
    private String formUnit, toUnit, description;
    private double multiplier;

    public dataConvertion(int idConvertion, String formUnit, String toUnit, double multiplier, String description) {
        this.idConvertion = idConvertion;
        this.formUnit = formUnit;
        this.toUnit = toUnit;
        this.multiplier = multiplier;
        this.description = description;
    }

    public int getIdConvertion() {
        return idConvertion;
    }

    public String getFormUnit() {
        return formUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getDescription() {
        return description;
    }
}
