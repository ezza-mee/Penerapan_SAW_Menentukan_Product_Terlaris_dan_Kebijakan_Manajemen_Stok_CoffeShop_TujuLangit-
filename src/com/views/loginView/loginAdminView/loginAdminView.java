package com.views.loginView.loginAdminView;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.model.viewLoginApp;
import com.partials.*;

public class loginAdminView extends panelLogin {

    private viewLoginApp panelContent;

    private panelRounded panelRounded = new panelRounded(100, 100, 100, 100, 100, 100);

    public loginAdminView(viewLoginApp panelContent) {
        super();
        this.panelContent = panelContent;
        initsComponentLoginAdminView();
    }
    
    public void initsComponentLoginAdminView(){

        panelLogin.add(panelRounded);

        setVisible(true);
    }
}
