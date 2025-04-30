package com.main.layouts.dasboardAdmin;

import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.components.panelApps.contentPanel;
import com.main.components.panelApps.headerPanel;
import com.main.components.panelApps.navigationPanel;
import com.main.views.dashboardAdminView;

public class parentDashboard extends containerPanel {

    private dashboardAdminView parentView;

    private headerPanel headerPanel = new headerPanel();
    private navigationPanel navigationPanel = new navigationPanel();
    private contentPanel contentPanel = new contentPanel();

    private navBar navBar;

    public parentDashboard(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        this.navBar = new navBar(this.parentView);
        setSize(1366, 768);

        initsLayoutParent();
    }

    private void initsLayoutParent() {
        setPosition();
        setColor();

        navigationPanel.add(navBar);

        add(headerPanel);
        add(navigationPanel);
        add(contentPanel);

        setVisible(true);
    }

    public void setContent(contentPanel content) {
        contentPanel.removeAll();
        contentPanel.add(content);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void setPosition() {
        contentPanel.setBounds(240, 80, 1126, 698);
        headerPanel.setBounds(240, 0, 1126, 80);
    }

    private void setColor() {
        navigationPanel.setBackground(color.GREEN);
    }

    public navBar getNavbar() {
        return navBar;
    }

}
