package com.main.controller;

import com.main.auth.utils.Role;
import com.main.routes.mainFrame;

public class appsController {

    private static final mainFrame parentApp = new mainFrame();

    public static void showLogin() {
        parentApp.showLoginApp();
        // setVisible sudah dipanggil di showLoginApp
    }

    public static void showDashboardAdmin() {
        parentApp.showDashboard(Role.ADMIN);
        // setVisible sudah dipanggil di showDashboard
    }

    public static void showDashboardByRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role tidak boleh null.");
        }

        switch (role) {
            case ADMIN:
            case CASHIER:
            case SUPPLIER:
                parentApp.showDashboard(role);
                break;
            default:
                throw new IllegalArgumentException("Role tidak dikenal: " + role);
        }
    }
}
