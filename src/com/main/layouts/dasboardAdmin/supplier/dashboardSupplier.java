package com.main.layouts.dasboardAdmin.supplier;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class dashboardSupplier extends contentPanel {

    private textLabel headerLabel;

    private panelRounded contentSupplier;

    public dashboardSupplier() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentSupplier);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Supplier", 40, 0, 200, 80);
        contentSupplier = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);

        contentSupplier.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontSize.FONT_SIZE_25);

    }

}
