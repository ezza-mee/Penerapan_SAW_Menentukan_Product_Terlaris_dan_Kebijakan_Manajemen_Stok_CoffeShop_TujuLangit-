package com.main;

import com.main.resources.templates.frameDashboard.frameDashboard;
import com.main.resources.templates.frameLogin.frameLogin;
import com.views.dasboardAdminView.dashboardAdminView;

public class App {
    public static void main(String[] args) {
        // frameDashboard testFrame = new frameDashboard();
        // testFrame.setVisible(true);

        // frameLogin testFrame = new frameLogin();
        // testFrame.setVisible(true);

        dashboardAdminView testFrame = new dashboardAdminView();
        testFrame.setVisible(true);
    }
}
