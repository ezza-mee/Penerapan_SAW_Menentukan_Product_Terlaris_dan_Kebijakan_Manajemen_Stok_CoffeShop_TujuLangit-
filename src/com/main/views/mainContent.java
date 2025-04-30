package com.main.views;

import com.main.components.color;
import com.main.components.panelApps.wrapperPanel;

public class mainContent extends wrapperPanel {

    private mainFrame mainFrame;
    private loginView loginView;
    private dashboardAdminView dashboardAdminView;

    public mainContent(mainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        loginView = new loginView(this);
        dashboardAdminView = new dashboardAdminView();
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
        dashboardAdminView.showHomeDashboard();
        add(dashboardAdminView);
        setVisible(true);
    }

}
