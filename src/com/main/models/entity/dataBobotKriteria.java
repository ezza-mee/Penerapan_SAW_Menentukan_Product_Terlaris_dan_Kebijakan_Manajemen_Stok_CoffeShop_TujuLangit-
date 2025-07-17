package com.main.models.entity;

public class dataBobotKriteria {
    private int idKriteria;
    private String kriteria, type;
    private double weight;

    public dataBobotKriteria(int idKriteria, String kriteria, double weight, String type) {
        this.idKriteria = idKriteria;
        this.kriteria = kriteria;
        this.weight = weight;
        this.type = type;
    }

    public int getIdKriteria() {
        return idKriteria;
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
