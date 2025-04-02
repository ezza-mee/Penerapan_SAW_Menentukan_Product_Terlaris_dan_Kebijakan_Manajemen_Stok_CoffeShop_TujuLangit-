package com.views.loginView.loginStaffView;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.model.viewLoginApp;

public class loginStaffView extends panelLogin {

    private viewLoginApp panelContent;

    public loginStaffView(viewLoginApp panelContent) {
        super();
        this.panelContent = panelContent;

        initsComponentLoginStaffView();

    }

    public void initsComponentLoginStaffView() {

        setVisible(true);
    }

}
