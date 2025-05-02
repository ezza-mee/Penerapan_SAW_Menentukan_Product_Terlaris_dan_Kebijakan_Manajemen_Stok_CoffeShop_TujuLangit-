package com.main.views;

import com.main.components.panelApps.*;
import com.main.controller.appsController;
import com.main.layouts.login.admin.loginAdmin;

public class loginView extends containerPanel {

    private mainContent mainContent;

    private loginAdmin componentLoginAdmin;

    public loginView(mainContent mainContent) {
        super();
        this.mainContent = mainContent;
        componentLoginAdmin = new loginAdmin(this, mainContent.getMainFrame());
        showLoginAdmin();
    }

    private void showLoginAdmin() {
        add(componentLoginAdmin);
    }

    public void loginSuccess() {
        appsController.showDashboardAdmin();
    }

}
