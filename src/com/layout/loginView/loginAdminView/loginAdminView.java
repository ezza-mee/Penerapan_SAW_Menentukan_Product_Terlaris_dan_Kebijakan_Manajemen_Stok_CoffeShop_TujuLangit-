package com.layout.loginView.loginAdminView;

import java.awt.Color;

import com.main.resources.templates.panelContentApp.loginPanel;
import com.partials.*;
import com.views.viewLoginApp;

public class loginAdminView extends loginPanel {

    private panelRounded containerPanel;

    private textLabel testText = new textLabel("Test Text", 0, 0, 1080, 720);

    public loginAdminView() {
        super();

        initsComponentLoginAdminView();

    }

    public void initsComponentLoginAdminView() {

        containerPanel = new panelRounded(0, 0, 1080, 720, 0, 0);

        panelLogin.add(containerPanel);

        configComponentLoginAdmin();
        setVisible(true);
    }

    public void configComponentLoginAdmin() {
        containerPanel.setBackground(Color.RED);
    }

}
