package com.main.layouts.dasboardAdmin.Report;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class reportDashboardView extends contentPanel {
    private textLabel headerLabel;

    private panelRounded contentReport;

    public reportDashboardView() {
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
        headerLabel.setForeground(color.DARKGREEN);

        contentReport.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

    }
}
