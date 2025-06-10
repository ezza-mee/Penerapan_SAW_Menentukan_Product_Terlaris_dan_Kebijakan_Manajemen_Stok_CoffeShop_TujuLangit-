package com.main.models.entity;

public class dataBobotKriteria {
    private int idWeight;
    private String kriteria, type;
    private double weight;

    public dataBobotKriteria(int idWeight, String kriteria, double weight, String type) {
        this.idWeight = idWeight;
        this.kriteria = kriteria;
        this.weight = weight;
        this.type = type;
    }

    public int getIdWeight() {
        return idWeight;
    }

    public String getKriteria() {
        return kriteria;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

}
