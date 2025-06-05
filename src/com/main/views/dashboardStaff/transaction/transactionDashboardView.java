package com.main.views.dashboardStaff.transaction;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.transaction.loadDataTransaction;
import com.main.routes.dashboardStaffView;
import com.main.controller.tableActionButton;

public class transactionDashboardView extends contentPanel {

    private dashboardStaffView parentView;

    private textLabel headerLabel;

    private panelRounded headerPanel, contentPanel;

    private buttonCustom buttonAdd;

    private tableCustom dataTransaction;
    private scrollTable scrollTableTransaction;

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.DETAIL, buttonType.APPROVE);

    public transactionDashboardView(dashboardStaffView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPostion();
        setColor();
        setFont();
        handleButton();

        headerPanel.add(buttonAdd);

        contentPanel.add(scrollTableTransaction);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPostion() {
        headerLabel = new textLabel("Data Transaction", 40, 0, 400, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

        tableActionButton actionButton = new tableActionButton() {
            @Override
            public void onEdit(int row) {
                // Not implemented
                System.out.println("onEdit row: " + row);
            }

            @Override
            public void onDelete(int row) {
                // Not implemented
                System.out.println("onDelete row: " + row);
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("onDetail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataTransaction = new tableCustom(loadDataTransaction.getAllDataTransaction(), actionButton);

        int actionColumnIndex = 8;
        dataTransaction.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataTransaction.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollTableTransaction = new scrollTable(dataTransaction, 0, 0, 1050, 410);

        dataTransaction.getColumnModel().getColumn(0).setMinWidth(80);
        dataTransaction.getColumnModel().getColumn(0).setMaxWidth(80);
        dataTransaction.getColumnModel().getColumn(0).setWidth(80);

        dataTransaction.getColumnModel().getColumn(1).setMinWidth(0);
        dataTransaction.getColumnModel().getColumn(1).setMaxWidth(0);
        dataTransaction.getColumnModel().getColumn(1).setWidth(0);

        dataTransaction.getColumnModel().getColumn(3).setMinWidth(80);
        dataTransaction.getColumnModel().getColumn(3).setMaxWidth(80);
        dataTransaction.getColumnModel().getColumn(3).setWidth(80);

        dataTransaction.getColumnModel().getColumn(5).setMinWidth(100);
        dataTransaction.getColumnModel().getColumn(5).setMaxWidth(100);
        dataTransaction.getColumnModel().getColumn(5).setWidth(100);

        dataTransaction.getColumnModel().getColumn(6).setMinWidth(120);
        dataTransaction.getColumnModel().getColumn(6).setMaxWidth(120);
        dataTransaction.getColumnModel().getColumn(6).setWidth(120);

        dataTransaction.getColumnModel().getColumn(7).setMinWidth(100);
        dataTransaction.getColumnModel().getColumn(7).setMaxWidth(100);
        dataTransaction.getColumnModel().getColumn(7).setWidth(100);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));
    }

    private void handleButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormTransaction();
            }
        });
    }

}
