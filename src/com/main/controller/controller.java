package com.main.controller;

import com.components.login.parentLogin;

public class controller {

    private static parentLogin frameLogin = new parentLogin();

    public static void showLogin() {
        frameLogin.initsFrameLogin();
        frameLogin.setVisible(true);
    }


}