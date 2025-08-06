package com.main.views.dashboardStaff.Report;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class reportCashierDashboardView extends contentPanel {
    private textLabel headerLabel;

    private panelRounded contentReport;

    public reportCashierDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentReport);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Report", 40, 0, 200, 80);
        contentReport = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);

        contentReport.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));

    }
}
