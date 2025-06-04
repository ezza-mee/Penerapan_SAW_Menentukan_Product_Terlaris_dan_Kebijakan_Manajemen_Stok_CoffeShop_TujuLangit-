package com.main.services;

import com.main.auth.sessionLogin;
import com.main.models.entity.accountDataStaff;
import com.main.models.staff.verifyAccounStaff;

public class authLogin {

    public static String validateLogin(String email, String password) {
        if (email.isEmpty() && password.isEmpty()) {
            return "EMAIL_PASSWORD_EMPTY";
        } else if (email.isEmpty()) {
            return "EMAIL_EMPTY";
        } else if (password.isEmpty()) {
            return "PASSWORD_EMPTY";
        }

        accountDataStaff staff = verifyAccounStaff.verifyStaffLogin(email, password);

        if (staff == null) {
            return "INVALID_CREDENTIALS";
        }
        sessionLogin.set(staff);
        return "SUCCESS";
    }

}
