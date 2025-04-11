package com.views.loginView.loginAdminView;

import java.awt.Color;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.model.viewLoginApp;
import com.partials.panelRounded;

public class loginAdminView extends panelLogin {

    private viewLoginApp contentPanel;

    private panelRounded containerPanel = new panelRounded(0, 0, 1080, 720, 0, 0);

    public loginAdminView(viewLoginApp contentPanel) {
        super();
        this.contentPanel = contentPanel;
        initsComponentLoginAdminView();
    }

    public void initsComponentLoginAdminView() {

        panelLogin.add(containerPanel);

        configComponentLoginAdmin();
        setVisible(true);
    }

    public void configComponentLoginAdmin() {
        containerPanel.setBackground(Color.GRAY);
    }
}
