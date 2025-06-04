package com.main.routes;

import com.main.auth.sessionManager;
import com.main.auth.utils.Role;
import com.main.components.panelApps.*;
import com.main.controller.appsController;
import com.main.views.login.formLogin;

public class loginView extends containerPanel {

    private formLogin componentLogin;

    public loginView(mainContent mainContent) {
        super();
        componentLogin = new formLogin(this, mainContent.getMainFrame());
        add(componentLogin);
    }

    public void loginSuccess(Role role) {
        System.out.println("role : " + role);
        sessionManager.setRole(role);
        appsController.showDashboardByRole(role);
    }
}
