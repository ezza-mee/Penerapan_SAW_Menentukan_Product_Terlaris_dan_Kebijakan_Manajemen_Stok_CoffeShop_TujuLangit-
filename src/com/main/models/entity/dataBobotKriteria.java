package com.main.models.entity;

public class dataBobotKriteria {
    private int idKriteria;
    private String kriteria, type;
    private int weight;

    public dataBobotKriteria(int idKriteria, String kriteria, int weight, String type) {
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

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

}
