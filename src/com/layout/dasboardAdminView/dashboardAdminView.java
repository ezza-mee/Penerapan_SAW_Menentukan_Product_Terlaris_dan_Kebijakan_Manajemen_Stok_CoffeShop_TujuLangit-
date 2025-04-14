package com.layout.dasboardAdminView;

import com.main.resources.templates.frameApps.frameApps;
import com.main.resources.templates.panelContentApp.*;

public class dashboardAdminView extends frameApps {

    public contentPanel contentPanel = new contentPanel();
    public headerPanel headerPanel = new headerPanel();
    public navbarPanel sidebarPanel = new navbarPanel();

    public dashboardAdminView() {
        super();
        initsDashboardAdmin();
    }

    public void initsDashboardAdmin() {
        configPanel();

        panelFrame.add(contentPanel);
        panelFrame.add(headerPanel);
        panelFrame.add(sidebarPanel);

        setVisible(true);
    }

    public void configPanel() {
        contentPanel.setBounds(240, 80, 1126, 698);
        headerPanel.setBounds(240, 0, 1126, 70);
    }

}
