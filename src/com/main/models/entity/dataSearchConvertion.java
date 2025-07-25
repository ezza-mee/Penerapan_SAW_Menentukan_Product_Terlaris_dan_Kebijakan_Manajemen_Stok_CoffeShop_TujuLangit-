package com.main.models.entity;

public class dataSearchConvertion {
    private int idConvertion;
    private String date, formUnit, toUnit, description;
    private double multiplier;

    public dataSearchConvertion(int idConvertion, String date, String formUnit, String toUnit, double multiplier,
            String description) {
        this.idConvertion = idConvertion;
        this.date = date;
        this.formUnit = formUnit;
        this.toUnit = toUnit;
        this.multiplier = multiplier;
        this.description = description;
    }

    public int getIdConvertion() {
        return idConvertion;
    }

    public String getDate() {
        return date;
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
