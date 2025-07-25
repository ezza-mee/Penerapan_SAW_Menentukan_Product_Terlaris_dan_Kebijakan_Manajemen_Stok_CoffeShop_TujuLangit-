package com.main.services;

import java.util.ArrayList;

import com.main.models.convertion.deleteConvertion;
import com.main.models.convertion.insertConvertion;
import com.main.models.convertion.updateConvertion;
import com.main.models.entity.dataSearchConvertion;
import com.main.models.convertion.searchDataConvertion;

public class authDataConvertion {

    public static ArrayList<dataSearchConvertion> searchConverstionByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataConvertion.searchConvertion(keyword.trim());
    }

    public static boolean insertDataConvertion(int idComposition, String formUnit, String toUnit, double multiplier,
            String description) {
        return insertConvertion.insertData(idComposition, formUnit, toUnit, multiplier, description);
    }

    public static boolean updateDataConvertion(int idConvertion, String formUnit, String toUnit, double multiplier,
            String description) {
        return updateConvertion.updateData(idConvertion, formUnit, toUnit, multiplier, description);
    }

    public static boolean deleteDataConvertion(int idConvertion) {
        return deleteConvertion.deleteData(idConvertion);
    }

    public String validateConvertionInput(String formUnit, String toUnit, String multiplier,
            String description) {
        if ((formUnit == null || formUnit.isEmpty()) &&
                (toUnit == null || toUnit.isEmpty()) &&
                (multiplier == null || multiplier.isEmpty()) &&
                (description == null || description.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (formUnit == null || formUnit.isEmpty()) {
            return "FORM_UNIT_EMPTY";
        } else if (toUnit == null || toUnit.isEmpty()) {
            return "TO_UNIT_EMPTY";
        } else if (multiplier == null || multiplier.isEmpty()) {
            return "MULTIPLIER_EMPTY";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_EMPTY";
        } else {
            return "VALID";
        }
    }

}
