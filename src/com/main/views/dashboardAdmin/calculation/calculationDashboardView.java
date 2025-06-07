package com.main.views.dashboardAdmin.calculation;

import java.awt.FlowLayout;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;

public class calculationDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private panelRounded headerPanel, contentPanel;

    private datePickerField dateField;

    public calculationDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;

        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        headerPanel.add(dateField);

        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        dateField = new datePickerField(300, "Select Date");

        dateField.getDatePicker().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

            }
        });

    }

    private void setColor() {
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

    }

    private void setFont() {

    }

}
