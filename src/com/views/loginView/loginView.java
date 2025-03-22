package com.views.loginView;

import com.main.resources.templates.frameLogin.frameLogin;
import com.main.resources.templates.panelContentApp.panelLogin;

public class loginView extends frameLogin {

    public panelLogin panelLogin = new panelLogin();

    public loginView() {
        super();
        initsFrameLogin();
    }

    public void initsFrameLogin() {

        panelFrame.add(panelLogin);

        setVisible(true);
    }

}
