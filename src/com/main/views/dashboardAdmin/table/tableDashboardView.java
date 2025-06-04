package com.main.views.dashboardAdmin.table;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.models.entity.dataTable;
import com.main.models.table.loadDataTable;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;
import com.main.services.authDataTable;
import com.main.views.popUp.popUpConfrim;

public class tableDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private panelRounded headerPanel, contentPanel;

    private textLabel headerLabel;

    private linkLabel allLabel, cleaningLabel, availableLabel, reservedLabel;

    private buttonCustom buttonAdd;

    private tableCustom dataTable;

    private scrollTable scrollTable;

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT, buttonType.DELETE, buttonType.DETAIL);

    public tableDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
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
        headerPanel.add(cleaningLabel);
        headerPanel.add(availableLabel);
        headerPanel.add(reservedLabel);
        headerPanel.add(buttonAdd);

        contentPanel.add(scrollTable);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        headerLabel = new textLabel("Data Table", 40, 0, 200, 80);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        cleaningLabel = new linkLabel("Cleaning", 155, 40, 120, 30);
        availableLabel = new linkLabel("Available", 310, 40, 120, 30);
        reservedLabel = new linkLabel("Reserved", 470, 40, 120, 30);
        buttonAdd = new buttonCustom("Add", 900, 40, 100, 40, 10);

        tableActionButton actionButton = new tableActionButton() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView
                            .showConfrimPopUp("do you want to edit Data Table?");
                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringId = dataTable.getValueAt(selectedRow, 0).toString();
                                int idTable = Integer.parseInt(stringId.replaceAll("[^0-9]", ""));

                                dataTable selectedData = loadDataTable.getDataById(idTable);

                                if (selectedData != null) {
                                    parentApp.hideGlassPanel();
                                    parentView.setDataTableToEdit(selectedData);
                                    parentView.showFormTable();
                                } else {
                                    parentView.showFailedPopUp("Data Table not found!");
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
                    popUpConfrim messagePopUp = parentView
                            .showConfrimPopUp("do you want to delete Data Table?");
                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringId = dataTable.getValueAt(selectedRow, 0).toString();
                                int id = Integer.parseInt(stringId.replaceAll("[^0-9]", ""));
                                boolean isSuccess = authDataTable.deleteDataTable(id);

                                if (isSuccess) {
                                    parentApp.hideGlassPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Table");
                                    parentView.showDashboardTable();
                                } else {
                                    parentApp.hideGlassPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Table");
                                    parentView.showDashboardTable();
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
                try {
                    int selectedRow = dataTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringId = dataTable.getValueAt(selectedRow, 0).toString();
                        int id = Integer.parseInt(stringId.replaceAll("[^0-9]", ""));
                        // parentView.showDetailPopUpData(id);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    parentView.showFailedPopUp("Data  not found!");
                }
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataTable = new tableCustom(loadDataTable.getAllDataTable(), actionButton);

        int actionColumnIndex = 6;
        dataTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollTable = new scrollTable(dataTable, 0, 0, 1050, 410);

        dataTable.getColumnModel().getColumn(0).setMinWidth(80);
        dataTable.getColumnModel().getColumn(0).setMaxWidth(80);
        dataTable.getColumnModel().getColumn(0).setWidth(80);

        dataTable.getColumnModel().getColumn(1).setMinWidth(150);
        dataTable.getColumnModel().getColumn(1).setMaxWidth(150);
        dataTable.getColumnModel().getColumn(1).setWidth(150);

        dataTable.getColumnModel().getColumn(2).setMinWidth(100);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(100);
        dataTable.getColumnModel().getColumn(2).setWidth(100);

        dataTable.getColumnModel().getColumn(3).setMinWidth(100);
        dataTable.getColumnModel().getColumn(3).setMaxWidth(100);
        dataTable.getColumnModel().getColumn(3).setWidth(100);

        dataTable.getColumnModel().getColumn(5).setMinWidth(90);
        dataTable.getColumnModel().getColumn(5).setMaxWidth(90);
        dataTable.getColumnModel().getColumn(5).setWidth(90);

        dataTable.getColumnModel().getColumn(6).setMinWidth(180);
        dataTable.getColumnModel().getColumn(6).setMaxWidth(180);
        dataTable.getColumnModel().getColumn(6).setWidth(180);
    }

    private void setColor() {
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

        headerLabel.setForeground(color.BLACK);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
        allLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        cleaningLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        availableLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        reservedLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
    }

    private void handleButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormTable();
            }
        });
    }
}
