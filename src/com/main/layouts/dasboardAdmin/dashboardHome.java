package com.main.layouts.dasboardAdmin;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class dashboardHome extends contentPanel {

    private panelRounded panelProduct;
    private panelRounded panelStaff;
    private panelRounded panelSupplier;
    private panelRounded panelTransaction;
    private panelRounded panelDiagramTransaction;

    private appIcons appIcons = new appIcons();

    private imageIcon iconProduct = appIcons.getProductIconHover(55, 55);
    private imageIcon iconSupplier = appIcons.getSupplierIconHover(55, 55);
    private imageIcon iconStaff = appIcons.getStaffIconHover(55, 55);
    private imageIcon iconTransaction = appIcons.getTransactionIconHover(55, 55);

    public dashboardHome() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();

        panelProduct.add(iconProduct);
        panelSupplier.add(iconSupplier);
        panelStaff.add(iconStaff);
        panelTransaction.add(iconTransaction);

        add(panelProduct);
        add(panelStaff);
        add(panelSupplier);
        add(panelTransaction);
        add(panelDiagramTransaction);

        setVisible(true);
    }

    private void setPosition() {
        panelProduct = new panelRounded(40, 40, 230, 150, 10, 10);
        panelSupplier = new panelRounded(310, 40, 230, 150, 10, 10);
        panelStaff = new panelRounded(580, 40, 230, 150, 10, 10);
        panelTransaction = new panelRounded(850, 40, 230, 150, 10, 10);
        panelDiagramTransaction = new panelRounded(40, 230, 1040, 400, 10, 10);

        iconProduct.setBounds(20, 55, 55, 55);
        iconSupplier.setBounds(20, 55, 55, 55);
        iconStaff.setBounds(20, 55, 55, 55);
        iconTransaction.setBounds(20, 55, 55, 55);

    }

    private void setColor() {
        panelProduct.setBackground(color.WHITE);
        panelStaff.setBackground(color.WHITE);
        panelSupplier.setBackground(color.WHITE);
        panelTransaction.setBackground(color.WHITE);
        panelDiagramTransaction.setBackground(color.WHITE);
    }

}
