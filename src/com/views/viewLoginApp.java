package com.views;

import com.components.login.loadingScreen.loadingScreen;
import com.components.login.loginAdmin.loginAdmin;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class viewLoginApp extends wrapperPanel {

    private loginAdmin componentLoginAdminView = new loginAdmin();
    private loadingScreen componentLoadingScreenView;

    public viewLoginApp() {
        super();
        componentLoadingScreenView = new loadingScreen(this);

        showLoginAdminView();
    }

    public void initsConfigLayoutScreen() {
        
    }

    public void showLoginAdminView() {
        wrapperPanel.add(componentLoginAdminView);
        setVisible(true);
    }

}
