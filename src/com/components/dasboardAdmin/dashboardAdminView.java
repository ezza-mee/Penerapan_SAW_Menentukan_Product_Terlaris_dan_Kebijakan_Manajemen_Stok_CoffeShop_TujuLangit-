package com.components.dasboardAdmin;

import com.main.resources.templates.panelContentApp.*;

public class dashboardAdminView extends containerPanel {

    public contentPanel contentPanel = new contentPanel();
    public headerPanel headerPanel = new headerPanel();
    public navbarPanel sidebarPanel = new navbarPanel();

    public dashboardAdminView() {
        super();
        initsDashboardAdmin();
    }

    public void initsDashboardAdmin() {
        configPanel();

        containerPanel.add(contentPanel);
        containerPanel.add(headerPanel);
        containerPanel.add(sidebarPanel);

        setVisible(true);
    }

    public void configPanel() {
        contentPanel.setBounds(240, 80, 1126, 698);
        headerPanel.setBounds(240, 0, 1126, 70);
    }

}
