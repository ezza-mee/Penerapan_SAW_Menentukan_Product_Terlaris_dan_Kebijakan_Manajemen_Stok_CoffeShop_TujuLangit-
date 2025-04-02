package com.views.loginView.loadingScreen;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.model.viewLoginApp;

public class loadingScreen extends panelLogin {

    private viewLoginApp contentPanel;

    public loadingScreen(viewLoginApp contentPanel) {
        super();
        this.contentPanel = contentPanel;

        initsComponentLoadingScreen();
    }

    public void initsComponentLoadingScreen() {
        setVisible(true);
    }
}
