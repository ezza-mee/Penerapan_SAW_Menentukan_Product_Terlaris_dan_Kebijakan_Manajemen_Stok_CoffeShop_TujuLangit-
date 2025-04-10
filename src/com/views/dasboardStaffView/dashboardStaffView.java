package com.views.dasboardStaffView;

import com.main.resources.templates.frameApps.frameApps;
import com.main.resources.templates.panelContentApp.*;;

public class dashboardStaffView extends frameApps {

    public panelHeader headerPanel = new panelHeader();
    public panelSidebar sidebarPanel = new panelSidebar();
    public panelContent contentPanel = new panelContent();

    public dashboardStaffView() {
        super();
        initsDashboardStaff();
    }

    public void initsDashboardStaff() {
        configPanel();

        panelFrame.add(headerPanel);
        panelFrame.add(sidebarPanel);
        panelFrame.add(contentPanel);

        setVisible(true);
    }

    public void configPanel() {
        headerPanel.setBounds(240, 0, 1126, 70);
        contentPanel.setBounds(240, 80, 1126, 80);
    }

}
