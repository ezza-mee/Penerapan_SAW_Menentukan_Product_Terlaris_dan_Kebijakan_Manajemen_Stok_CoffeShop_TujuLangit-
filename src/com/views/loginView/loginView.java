package com.views.loginView;

import com.main.resources.templates.frameApps.frameApps;
import com.model.viewLoginApp;

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
