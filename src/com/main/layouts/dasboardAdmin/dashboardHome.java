package com.main.layouts.dasboardAdmin;

import com.main.components.panelRounded;
import com.main.components.panelApps.*;
import com.main.components.*;

public class dashboardHome extends contentPanel {

    private panelRounded panelProduct;
    private panelRounded panelStaff;
    private panelRounded panelSupplier;
    private panelRounded panelTransaction;
    private panelRounded panelDiagramTransaction;

    public dashboardHome() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();

        add(panelProduct);
        add(panelStaff);
        add(panelSupplier);
        add(panelTransaction);
        add(panelDiagramTransaction);

        setVisible(true);
    }

    private void setPosition() {
        panelProduct = new panelRounded(40, 40, 230, 150, 10, 10);
        panelStaff = new panelRounded(310, 40, 230, 150, 10, 10);
        panelSupplier = new panelRounded(580, 40, 230, 150, 10, 10);
        panelTransaction = new panelRounded(850, 40, 230, 150, 10, 10);
        panelDiagramTransaction = new panelRounded(40, 230, 1040, 400, 10, 10);
    }

    private void setColor() {
        panelProduct.setBackground(color.WHITE);
        panelStaff.setBackground(color.WHITE);
        panelSupplier.setBackground(color.WHITE);
        panelTransaction.setBackground(color.WHITE);
        panelDiagramTransaction.setBackground(color.WHITE);
    }

}
