package com.main.controller;

import com.views.parentApps;

public class controller {

    private static parentApps frameLogin = new parentApps();

    public static void showLogin() {
        frameLogin.initsFrameLogin();
        frameLogin.setVisible(true);
    }

}