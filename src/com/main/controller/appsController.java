package com.main.controller;

import com.main.views.mainFrame;

public class appsController {

    private static mainFrame frameApp = new mainFrame();

    public static void showLogin() {
        frameApp.showLoginApp();
        frameApp.setVisible(true);

    }

    public static void showDashboardAdmin() {
        frameApp.showDashboardAdmin();
        frameApp.setVisible(true);
    }

}