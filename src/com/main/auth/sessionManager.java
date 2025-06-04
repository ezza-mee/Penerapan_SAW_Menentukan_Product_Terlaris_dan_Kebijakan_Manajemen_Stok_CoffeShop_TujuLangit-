package com.main.auth;

import com.main.auth.utils.Role;
import com.main.models.entity.dataStaff;

public class sessionManager {
    private static Role currentRole = sessionLogin.getRole();
    private static dataStaff currentStaffData; // ✅ Tambahan: data lengkap staff

    public static void setRole(Role role) {
        currentRole = role;
    }

    public static Role getRole() {
        return currentRole;
    }

    public static void setStaffData(dataStaff staffData) {
        currentStaffData = staffData;
    }

    public static dataStaff getStaffData() {
        return currentStaffData;
    }

    public static void clear() {
        currentRole = null;
        currentStaffData = null;
    }
}
