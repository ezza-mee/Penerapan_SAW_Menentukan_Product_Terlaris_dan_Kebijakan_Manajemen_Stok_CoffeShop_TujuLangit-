package com.main.layouts.dashboardAdmin.supplier;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.views.dashboardAdminView;

public class supplierDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded headerContent;
    private panelRounded contentSupplier;

    private buttonCustom buttonAdd;

    public supplierDashboardView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handleButton();

        headerContent.add(buttonAdd);

        add(headerLabel);
        add(headerContent);
        add(contentSupplier);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Supplier", 40, 0, 300, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentSupplier = new panelRounded(40, 220, 1050, 410, 10, 10);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerContent.setBackground(color.WHITE);
        contentSupplier.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

    }

    private void handleButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                parentView.showFormSupplier();
            }
        });
    }

}
