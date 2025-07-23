package com.main.services;

import com.main.models.bobotKriteria.insertBobotKriteria;
import com.main.models.bobotKriteria.updateBobotKriteria;
import com.main.models.entity.dataBobotKriteria;
import com.main.models.bobotKriteria.deleteBobotKriteria;
import com.main.models.bobotKriteria.loadDataBobotKriteria;

public class authDataBobotKriteria {

    public static Boolean insertBobotKriteria(String kriteria, int weight, String type) {
        return insertBobotKriteria.insertData(kriteria, weight, type);
    }

    public static Boolean updateBobotKriteria(int idWeight, String kriteria, int weight, String type) {
        return updateBobotKriteria.updateData(idWeight, kriteria, weight, type);
    }

    public static Boolean deleteBobotKriteria(int idWeight) {
        return deleteBobotKriteria.deleteData(idWeight);
    }

    public static double getWeightById(int idWeight) {
        dataBobotKriteria model = loadDataBobotKriteria.getDataById(idWeight);
        if (model != null) {
            return model.getWeight();
        } else {
            return 0.0;
        }
    }

    public String validateBobotKriteriaInput(String kriteria, String weight, String type) {
        if ((kriteria == null || kriteria.isEmpty()) &&
                (weight == null || weight.isEmpty()) &&
                (type == null || type.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (kriteria == null || kriteria.isEmpty()) {
            return "KRITERIA_EMPTY";
        } else if (weight == null || weight.isEmpty()) {
            return "WEIGHT_EMPTY";
        } else if (type == null || type.isEmpty()) {
            return "TYPE_EMPTY";
        } else {
            return "VALID";
        }
    }

}
