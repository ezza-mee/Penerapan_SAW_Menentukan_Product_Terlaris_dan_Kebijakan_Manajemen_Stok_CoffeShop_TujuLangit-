package com.views;

import com.components.login.loadingScreen.loadingScreen;
import com.components.login.loginAdmin.loginAdmin;
import com.components.login.loginStaff.loginStaff;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class viewLoginApp extends wrapperPanel {

    private loginAdmin componentLoginAdminView = new loginAdmin(this);
    private loginStaff componentLoginStaffView = new loginStaff(this);

    public viewLoginApp() {
        super();
        showLoginAdminView();
    }

    private void refreshContent() {
        try {
            wrapperPanel.removeAll();
            wrapperPanel.revalidate();
            wrapperPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsConfigLayoutScreen() {
        showLoginAdminView();
        setVisible(true);
    }

    public void showLoginAdminView() {
        refreshContent();

        wrapperPanel.add(componentLoginAdminView);
        wrapperPanel.revalidate();
        wrapperPanel.repaint();

        setVisible(true);
    }

    public void showLoginStaffView() {
        refreshContent();

        wrapperPanel.add(componentLoginStaffView);
        wrapperPanel.revalidate();
        wrapperPanel.repaint();

        setVisible(true);
    }

}
