package com.main.services;

import java.util.ArrayList;

import com.main.models.staff.deleteStaff;
import com.main.models.entity.accountDataStaff;
import com.main.models.entity.dataStaff;
import com.main.models.staff.insertAccountStaff;
import com.main.models.staff.insertStaff;
import com.main.models.staff.loadDataStaff;
import com.main.models.staff.searchDataStaff;
import com.main.models.staff.updateAccountStaff;
import com.main.models.staff.updateStaff;

public class authDataStaff {

    public static ArrayList<dataStaff> searchStaffByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataStaff.searchStaff(keyword.trim());
    }

    public static boolean insertDataStaff(
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address) {
        return insertStaff.insertData(
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
        Integer idStaff = insertStaff.insertStaffAndGetId(nameStaff, email, phoneNumber, gender, jobdesk, address);

        if (idStaff == null) {
            System.out.println("Gagal insert data staff.");
            return false;
        }

        if (jobdesk.equalsIgnoreCase("Admin") || jobdesk.equalsIgnoreCase("Cashier")
                || jobdesk.equalsIgnoreCase("Supplier")) {
            if (accountEmail != null && accountPassword != null) {
                return insertAccountStaff.insertAccount(idStaff, accountEmail, accountPassword, jobdesk);
            } else {
                System.out.println("Data akun tidak lengkap.");
                return false;
            }
        }

        return true;
    }

    public static boolean updateDataStaff(
            int staffId,
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address) {
        return updateStaff.updateData(staffId, nameStaff, email, phoneNumber, gender, jobdesk, address);
    }

    public static boolean updateStaffWithAccount(
            int idStaff,
            String nameStaff,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address,
            String accountEmail,
            String accountPassword) {
        Integer resultUpdate = updateStaff.updateStaffAndReturnId(idStaff, nameStaff, email, phoneNumber, gender,
                jobdesk, address);

        if (resultUpdate == null) {
            System.out.println("Gagal update data staff.");
            return false;
        }

        if (jobdesk.equalsIgnoreCase("Admin") || jobdesk.equalsIgnoreCase("Cashier")
                || jobdesk.equalsIgnoreCase("Supplier")) {
            if (accountEmail != null && accountPassword != null) {
                return updateAccountStaff.updateAccount(resultUpdate, accountEmail, accountPassword, jobdesk);
            } else {
                System.out.println("Data akun tidak lengkap.");
                return false;
            }
        }

        return true;
    }

    public static boolean resignStaffById(int staffId) {
        return deleteStaff.resignStaff(staffId);
    }

    public static accountDataStaff getDataAccountById(int idStaff) {
        return loadDataStaff.getDataAccountById(idStaff);
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

    public static String validateStaffDataExistence(String email, String phoneNumber, String oldEmail,
            String oldPhoneNumber, int staffIdToEdit) {
        if (!email.equalsIgnoreCase(oldEmail) && insertStaff.isEmailExist(email, staffIdToEdit)) {
            return "EMAIL_ALREADY_EXISTS";
        }
        if (!phoneNumber.equalsIgnoreCase(oldPhoneNumber) && insertStaff.isPhoneExist(phoneNumber, staffIdToEdit)) {
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
        } else {
            return "VALID";
        }
    }

}