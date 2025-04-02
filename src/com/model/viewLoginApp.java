package com.model;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.views.loginView.loadingScreen.loadingScreen;
import com.views.loginView.loginAdminView.loginAdminView;
import com.views.loginView.loginStaffView.loginStaffView;

public class viewLoginApp extends panelLogin {

    private loadingScreen componentLoadingScreen;
    private loginAdminView componentLoginAdminView;
    private loginStaffView componentLoginStaffView;

    public viewLoginApp(){
        super();

        componentLoadingScreen = new loadingScreen(this);
        componentLoginAdminView = new loginAdminView(this);
        componentLoginStaffView = new loginStaffView(this);

        showLoginAdminView();
    }

    public void showLoginAdminView() {

        panelLogin.add(componentLoginAdminView);


        setVisible(true);
    }
    
}
