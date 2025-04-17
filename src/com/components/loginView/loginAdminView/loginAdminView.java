package com.components.loginView.loginAdminView;

import java.awt.Color;

import com.main.resources.templates.panelContentApp.loginPanel;
import com.partials.*;
import com.views.viewLoginApp;

public class loginAdminView extends loginPanel {

    private panelRounded containerPanel;
    private panelRounded cardPanel;
    private panelRounded shapeOne;
    private panelRounded shapeTwo;
    private panelRounded shapeThree;

    public loginAdminView() {
        super();

        initsComponentLoginAdminView();
        slideInPanel();
    }

    public void initsComponentLoginAdminView() {

        containerPanel = new panelRounded(0, 0, 1080, 720, 0, 0);
        cardPanel = new panelRounded(0, 0, 500, 500, 0, 0);

        loginPanel.add(containerPanel);

        configComponentLoginAdmin();

        setVisible(true);
    }

    public void configComponentLoginAdmin() {
        containerPanel.setBackground(Color.GREEN);
    }

    public void slideInPanel() {

        loginPanel.setLocation(0, 720);

        final javax.swing.Timer timer = new javax.swing.Timer(15, null);
        final int targetY = 0;

        timer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                boolean done = true;

                if (loginPanel.getY() > targetY) {
                    loginPanel.setLocation(0, getY() - 20);
                    loginPanel.repaint();
                    done = false;
                }

                if (done) {
                    timer.stop();
                }
            }
        });

        timer.start();
    }

}
