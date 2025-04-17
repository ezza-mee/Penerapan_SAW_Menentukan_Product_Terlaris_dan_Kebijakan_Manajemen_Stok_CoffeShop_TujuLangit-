package com.components.login;

import com.main.resources.templates.frameApps.frameApps;
import com.views.viewLoginApp;

public class parentLogin extends frameApps {

    private viewLoginApp componentLoginApp = new viewLoginApp();

    public parentLogin() {
        super();
        initsFrameLogin();
    }

    public void initsFrameLogin() {

        panelFrame.add(componentLoginApp);

        setVisible(true);
    }

}
