package com.views.loginView;

import com.main.resources.templates.frameLogin.frameLogin;
import com.main.resources.templates.panelContentApp.panelContent;

public class loginView extends frameLogin {

    public panelContent contentPanel = new panelContent();

    public loginView() {
        super();
        initsFrameLogin();
    }

    public void initsFrameLogin() {

        contentPanel.add(contentPanel);

        setVisible(true);
    }


    public void configContent() {
        contentPanel.setBounds(0,0,1126, 756);

    }
    
}
