package com.views;

import java.awt.CardLayout;

import com.layout.loginView.loadingScreen.loadingScreen;
import com.layout.loginView.loginAdminView.loginAdminView;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class viewLoginApp extends wrapperPanel {

    private loadingScreen componentLoadingScreenView = new loadingScreen();
    private loginAdminView componentLoginAdminView = new loginAdminView();

    private CardLayout cardLayout;

    public viewLoginApp() {
        super();
        initsConfigLayoutScreen();
    }

    public void initsConfigLayoutScreen() {
        cardLayout = (CardLayout) getWrapperPanel().getLayout();

        getWrapperPanel().add(componentLoadingScreenView, "loading");
        getWrapperPanel().add(componentLoginAdminView, "login");

        showLoadingScreenView();
    }

    public void showLoadingScreenView() {
        cardLayout.show(getWrapperPanel(), "loading");
    }
}
