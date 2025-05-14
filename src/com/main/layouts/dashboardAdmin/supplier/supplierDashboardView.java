package com.main.layouts.dashboardAdmin.supplier;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class supplierDashboardView extends contentPanel {

    private textLabel headerLabel;

    private panelRounded headerContent;
    private panelRounded contentSupplier;

    private button buttonAdd;

    public supplierDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

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

        buttonAdd = new button("Add", 900, 35, 100, 40, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);
        headerContent.setBackground(color.WHITE);
        contentSupplier.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

    }

}
