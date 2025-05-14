package com.main.layouts.dashboardAdmin;

import com.main.components.panelApps.headerPanel;

import com.main.components.*;

public class headerDashboardView extends headerPanel {

    private textLabel welcomeLabel;

    public headerDashboardView() {
        super();

        initContent();
    }

    private void initContent() {
        setPosition();
        setColor();
        setFont();

        add(welcomeLabel);

        setVisible(true);
    }

    private void setPosition() {
        welcomeLabel = new textLabel("Welcome", 40, 0, 100, 80);
    }

    private void setColor() {
        setBackground(color.WHITE);

        welcomeLabel.setForeground(color.DARKGREEN);
    }

    private void setFont() {
        welcomeLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
    }

}
