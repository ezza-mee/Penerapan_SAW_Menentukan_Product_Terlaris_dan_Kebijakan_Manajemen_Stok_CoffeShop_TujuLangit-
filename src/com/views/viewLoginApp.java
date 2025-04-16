package com.views;

import com.components.loginView.loadingScreen.loadingScreen;
import com.components.loginView.loginAdminView.loginAdminView;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class viewLoginApp extends wrapperPanel {

    private loginAdminView componentLoginAdminView = new loginAdminView();
    private loadingScreen componentLoadingScreenView;

    public viewLoginApp() {
        super();
        componentLoadingScreenView = new loadingScreen(this);

        initsConfigLayoutScreen();
    }

    public void initsConfigLayoutScreen() {

        wrapperPanel.add(componentLoadingScreenView);
    }

    public void showLoginAdminView() {
        wrapperPanel.add(componentLoginAdminView);
    }

}
