package com.main.views.dashboardStaff;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class homeDashboardView extends contentPanel {

    private panelRounded panelProduct;
    private panelRounded panelStaff;
    private panelRounded panelSupplier;
    private panelRounded panelTransaction;
    private panelRounded panelDiagramTransaction;

    private textLabel labelProduct;
    private textLabel labelSupplier;
    private textLabel labelStaff;
    private textLabel labelTransaction;

    private appIcons appIcons = new appIcons();

    private imageIcon iconProduct = appIcons.getProductIconHover(55, 55);
    private imageIcon iconSupplier = appIcons.getSupplierIconHover(55, 55);
    private imageIcon iconStaff = appIcons.getStaffIconHover(55, 55);
    private imageIcon iconTransaction = appIcons.getTransactionIconHover(55, 55);

    public homeDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        panelProduct.add(iconProduct);
        panelProduct.add(labelProduct);

        panelSupplier.add(iconSupplier);
        panelSupplier.add(labelSupplier);

        panelStaff.add(iconStaff);
        panelStaff.add(labelStaff);

        panelTransaction.add(iconTransaction);
        panelTransaction.add(labelTransaction);

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

        labelProduct = new textLabel("Data Product", 0, 10, 230, 40);
        labelSupplier = new textLabel("Data Supplier", 0, 10, 230, 40);
        labelStaff = new textLabel("Data Staff", 0, 10, 230, 40);
        labelTransaction = new textLabel("Data Transaction", 0, 10, 230, 40);

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

        labelProduct.setForeground(color.DARKGREEN);
        labelSupplier.setForeground(color.DARKGREEN);
        labelStaff.setForeground(color.DARKGREEN);
        labelTransaction.setForeground(color.DARKGREEN);

    }

    private void setFont() {
        labelProduct.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
        labelSupplier.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
        labelStaff.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
        labelTransaction.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));

        labelProduct.setHorizontalAlignment(JLabel.CENTER);
        labelSupplier.setHorizontalAlignment(JLabel.CENTER);
        labelStaff.setHorizontalAlignment(JLabel.CENTER);
        labelTransaction.setHorizontalAlignment(JLabel.CENTER);
    }

}