package com.components.loginView;

import com.main.resources.templates.frameApps.frameApps;
import com.views.viewLoginApp;

public class loginView extends frameApps {

    private viewLoginApp componentLoginApp = new viewLoginApp();

    public loginView() {
        super();
        initsFrameLogin();
    }

    public void initsFrameLogin() {

        panelFrame.add(componentLoginApp);

        setVisible(true);
    }

}
