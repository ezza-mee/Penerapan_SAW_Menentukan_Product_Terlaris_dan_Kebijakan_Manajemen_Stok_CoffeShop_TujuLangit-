package com.main.layouts.dashboardAdmin.supplier;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.models.dataSupplier.loadDataSupplier;
import com.main.views.dashboardAdminView;
import com.main.services.authDataSupplier;

public class supplierDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded headerContent;
    private panelRounded contentSupplier;

    private linkLabel allLabel;
    private linkLabel pendingLabel;
    private linkLabel stocklabel;
    private linkLabel outStockLabel;

    private buttonCustom buttonAdd;

    private table dataSupplierTable;
    private scrollTable scrollDataSupplier;

    private int quantityAllDataSupplier = loadDataSupplier.getAllQuantityDataSupplier();

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT,
            buttonType.DELETE, buttonType.DETAIL);

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

        headerContent.add(allLabel);
        headerContent.add(pendingLabel);
        headerContent.add(stocklabel);
        headerContent.add(outStockLabel);
        headerContent.add(buttonAdd);

        contentSupplier.add(scrollDataSupplier);

        add(headerLabel);
        add(headerContent);
        add(contentSupplier);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Supplier", 40, 0, 300, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentSupplier = new panelRounded(40, 220, 1050, 410, 10, 10);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        allLabel.setQuantity(quantityAllDataSupplier);
        pendingLabel = new linkLabel("Pending", 155, 40, 120, 30);
        stocklabel = new linkLabel("In Stock", 310, 40, 120, 30);
        outStockLabel = new linkLabel("Out Stock", 470, 40, 120, 30);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

        tableActionButton actionButton = new tableActionButton() {
            @Override
            public void onEdit(int row) {

                try {
                    int selectedRow = dataSupplierTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                        int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                        
                        getterDataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                        if (selectedDataSupplier != null) {
                            System.out.println("Edit row: " + row);

                            parentView.setDataSupplierToEdit(selectedDataSupplier);
                            parentView.showFormSupplier();

                            System.out.println("Name Supplier : " + selectedDataSupplier.getNameSupplier());
                            System.out.println("Quantity : " + selectedDataSupplier.getQuantity());
                            System.out.println("Unit : " + selectedDataSupplier.getUnit());
                            System.out.println("Description : " + selectedDataSupplier.getDescription());
                        } else {

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {
                    int selectedRow = dataSupplierTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                        int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                        int quantity = 0;
                        boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                        if (isSuccess) {
                            parentView.showSuccessPopUp("Success Delete Data Delete");
                            parentView.showDashboardSupplier();
                        } else {
                            parentView.showFailedPopUp("Failed Delete Data Delete");
                            parentView.showDashboardSupplier();
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new table(loadDataSupplier.getAllDataSupplier(), actionButton);

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
        headerContent.setBackground(color.WHITE);
        contentSupplier.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

        allLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        pendingLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        stocklabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
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
