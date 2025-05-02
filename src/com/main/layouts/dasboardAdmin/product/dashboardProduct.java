package com.main.layouts.dasboardAdmin.product;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class dashboardProduct extends contentPanel {

    private textLabel headerLabel;

    private panelRounded contentProduct;

    public dashboardProduct() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentProduct);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Product", 40, 0, 200, 80);
        contentProduct = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);
        contentProduct.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontSize.FONT_SIZE_25);
    }

}
