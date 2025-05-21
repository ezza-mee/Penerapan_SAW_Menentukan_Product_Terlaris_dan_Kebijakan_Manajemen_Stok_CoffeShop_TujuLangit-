package com.main.services;

import com.main.models.dataStaff.insertDataStaff;
import com.main.models.dataStaff.insertAccountStaff;

public class authInsertDataStaff {

    public static boolean insertDataStaff(
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address) {
        return insertDataStaff.insertStaff(
                nameStaff,
                email,
                phoneNumber,
                gender,
                jobdesk,
                address);
    }

    public static boolean insertStaffWithAccount(
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address,
            String accountEmail,
            String accountPassword) {
        Integer idStaff = insertDataStaff.insertStaffAndGetId(nameStaff, email, phoneNumber, gender, jobdesk, address);

        if (idStaff == null) {
            System.out.println("Gagal insert data staff.");
            return false;
        }

        if (jobdesk.equalsIgnoreCase("cashier") || jobdesk.equalsIgnoreCase("supplier")) {
            if (accountEmail != null && accountPassword != null) {
                return insertAccountStaff.insertAccount(idStaff, accountEmail, accountPassword);
            } else {
                System.out.println("Data akun tidak lengkap.");
                return false;
            }
        }

        return true;
    }

    public String validateStaffInput(String name, String email, String phoneNumber,
            String gender, String jobdesk, String address) {

        if ((name == null || name.isEmpty()) &&
                (email == null || email.isEmpty()) &&
                (phoneNumber == null || phoneNumber.isEmpty()) &&
                (gender == null || gender.isEmpty()) &&
                (jobdesk == null || jobdesk.isEmpty()) &&
                (address == null || address.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (name == null || name.isEmpty()) {
            return "NAME_EMPTY";
        } else if (email == null || email.isEmpty()) {
            return "EMAIL_EMPTY";
        } else if (phoneNumber == null || phoneNumber.isEmpty()) {
            return "PHONE_EMPTY";
        } else if (gender == null || gender.isEmpty()) {
            return "GENDER_EMPTY";
        } else if (jobdesk == null || jobdesk.isEmpty()) {
            return "JOBDESK_EMPTY";
        } else if (address == null || address.isEmpty()) {
            return "ADDRESS_EMPTY";
        } else {
            return "VALID";
        }
    }

    public static String validateStaffDataExistence(String email, String phoneNumber) {
        if (insertDataStaff.isEmailExist(email)) {
            return "EMAIL_ALREADY_EXISTS";
        }
        if (insertDataStaff.isPhoneExist(phoneNumber)) {
            return "PHONE_ALREADY_EXISTS";
        }
        if (phoneNumber.length() > 13) {
            return "PHONE_TOO_LONG";
        }
        return "VALID";
    }    

    public String validateAccountInput(String email, String password, String confirmPassword) {
        if ((email == null || email.isEmpty()) && (password == null || password.isEmpty())) {
            return "ACCOUNT_EMAIL_PASSWORD_EMPTY";
        } else if (email == null || email.isEmpty()) {
            return "ACCOUNT_EMAIL_EMPTY";
        } else if (password == null || password.isEmpty()) {
            return "ACCOUNT_PASSWORD_EMPTY";
        } else if (confirmPassword == null || confirmPassword.isEmpty()) {
            return "CONFIRM_PASSWORD_EMPTY";
        } else if (!password.equals(confirmPassword)) {
            return "PASSWORD_MISMATCH";
        }else {
            return "VALID";
        }
    }

}