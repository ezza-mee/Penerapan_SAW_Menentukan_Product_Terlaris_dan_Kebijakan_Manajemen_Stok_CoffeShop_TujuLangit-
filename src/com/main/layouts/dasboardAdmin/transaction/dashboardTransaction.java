package com.main.layouts.dasboardAdmin.transaction;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class dashboardTransaction extends contentPanel {

    private textLabel headerLabel;
    private panelRounded contentTransaction;

    public dashboardTransaction() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentTransaction);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Transaction", 40, 0, 300, 80);
        contentTransaction = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);

        contentTransaction.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontSize.FONT_SIZE_25);
    }

}
