package com.main.auth;

import com.main.auth.utils.Role;

public class sessionManager {
    private static Role currentRole = sessionLogin.getRole();

    public static void setRole(Role role) {
        currentRole = role;
    }

    public static Role getRole() {
        return currentRole;
    }
}
