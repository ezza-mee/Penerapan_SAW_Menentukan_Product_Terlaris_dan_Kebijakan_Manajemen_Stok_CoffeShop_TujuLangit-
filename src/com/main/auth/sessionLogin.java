package com.main.auth;

import com.main.auth.utils.Role;
import com.main.models.entity.accountDataStaff;

public class sessionLogin {
    private static accountDataStaff currentStaff;

    public static void set(accountDataStaff staff) {
        currentStaff = staff;
    }

    public static accountDataStaff get() {
        return currentStaff;
    }

    public static Role getRole() {
        if (currentStaff == null)
            return null;
        try {
            return Role.valueOf(currentStaff.getJobdesk().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static void clear() {
        currentStaff = null;
    }
}
