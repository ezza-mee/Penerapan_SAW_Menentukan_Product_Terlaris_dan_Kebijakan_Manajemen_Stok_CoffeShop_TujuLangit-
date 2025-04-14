package com.main.controller;

import com.layout.loginView.loginView;

public class controller {

    private static loginView frameLogin = new loginView();

    public static void showLogin() {
        frameLogin.initsFrameLogin();
        frameLogin.setVisible(true);
    }


}