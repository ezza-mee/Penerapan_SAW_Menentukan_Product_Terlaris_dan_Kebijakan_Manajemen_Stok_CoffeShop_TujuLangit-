package com.main.layouts.dashboardAdmin.supplier;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.layouts.popUp.popUpConfrim;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.models.dataSupplier.loadDataSupplier;
import com.main.views.dashboardAdminView;
import com.main.services.authDataSupplier;
import com.main.views.mainFrame;

public class supplierDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded headerPanel, contentPanel;

    private linkLabel allLabel, pendingLabel, stockLabel, outStockLabel;

    private buttonCustom buttonAdd;

    private tableCustom dataSupplierTable;
    private scrollTable scrollDataSupplier;

    private int quantityAllDataSupplier = loadDataSupplier.getAllQuantityDataSupplier();

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT,
            buttonType.DELETE, buttonType.DETAIL);

    public supplierDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
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
        handleButton();

        headerPanel.add(allLabel);
        headerPanel.add(pendingLabel);
        headerPanel.add(stockLabel);
        headerPanel.add(outStockLabel);
        headerPanel.add(buttonAdd);

        contentPanel.add(scrollDataSupplier);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Supplier", 40, 0, 300, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        allLabel.setQuantity(quantityAllDataSupplier);
        pendingLabel = new linkLabel("Pending", 155, 40, 120, 30);
        stockLabel = new linkLabel("In Stock", 310, 40, 120, 30);
        outStockLabel = new linkLabel("Out Stock", 470, 40, 120, 30);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

        tableActionButton actionButton = new tableActionButton() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));

                                getterDataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                                if (selectedDataSupplier != null) {
                                    parentApp.hideGlassPanel();
                                    parentView.setDataSupplierToEdit(selectedDataSupplier);
                                    parentView.showFormSupplier();
                                } else {
                                    parentApp.hideGlassPanel();
                                    parentView.showFailedPopUp("Data Supplier not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassPanel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {

                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                                int quantity = 0;
                                boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                                if (isSuccess) {
                                    parentApp.hideGlassPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                } else {
                                    parentApp.hideGlassPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassPanel();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new tableCustom(loadDataSupplier.getAllDataSupplier(), actionButton);

        int actionColumnIndex = 6;
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataSupplier = new scrollTable(dataSupplierTable, 0, 0, 1050, 410);

        dataSupplierTable.getColumnModel().getColumn(0).setMinWidth(80);
        dataSupplierTable.getColumnModel().getColumn(0).setMaxWidth(80);
        dataSupplierTable.getColumnModel().getColumn(0).setWidth(80);

        dataSupplierTable.getColumnModel().getColumn(4).setMinWidth(90);
        dataSupplierTable.getColumnModel().getColumn(4).setMaxWidth(90);
        dataSupplierTable.getColumnModel().getColumn(4).setWidth(90);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

        allLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        pendingLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        stockLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        outStockLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));

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
