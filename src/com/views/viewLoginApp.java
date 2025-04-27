package com.views;

import com.components.dasboardAdmin.dashboardAdminView;
import com.components.login.loginAdmin.loginAdmin;
import com.components.login.loginStaff.loginStaff;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class viewLoginApp extends wrapperPanel {

    private loginAdmin componentLoginAdminView;
    private loginStaff componentLoginStaffView = new loginStaff(this);

    private dashboardAdminView componentDashboardAdminView = new dashboardAdminView();

    private parentApps parentApps;

    public viewLoginApp(parentApps parentApps) {
        super();
        this.parentApps = parentApps;
        componentLoginAdminView = new loginAdmin(this, parentApps);
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

    public void showDashboardAdmin() {
        refreshContent();

        parentApps.showDashboardAdmin();

        wrapperPanel.add(componentDashboardAdminView);
        wrapperPanel.revalidate();
        wrapperPanel.repaint();

        setVisible(true);
    }

}
