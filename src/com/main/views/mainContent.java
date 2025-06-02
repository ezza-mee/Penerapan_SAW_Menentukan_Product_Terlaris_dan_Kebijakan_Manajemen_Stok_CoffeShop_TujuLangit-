package com.main.views;

import com.main.components.panelApps.wrapperPanel;
import com.main.layouts.dashboardAdmin.parentDashboardView;

public class mainContent extends wrapperPanel {

    private mainFrame mainFrame;
    private loginView loginView;
    private dashboardAdminView dashboardAdminView;
    private parentDashboardView parentDashboard;

    public mainContent(mainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        loginView = new loginView(this);
        dashboardAdminView = new dashboardAdminView(this.mainFrame);
        parentDashboard = new parentDashboardView(dashboardAdminView);
    }

    private void refreshContent() {
        try {
            removeAll();
            revalidate();
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoginView() {
        refreshContent();
        setSize(1080, 720);
        add(loginView);
    }

    public void showDashboardAdmin() {
        refreshContent();
        setSize(1366, 768);
        dashboardAdminView.showDashboardTable();
        dashboardAdminView.resetLastContent();
        parentDashboard.getNavbar().showTableView();
        add(dashboardAdminView);
        setVisible(true);
    }

    // get mainFrame for add glass panel
    public mainFrame getMainFrame() {
        return mainFrame;
    }

}
