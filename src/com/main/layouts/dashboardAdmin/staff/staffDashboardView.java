package com.main.layouts.dashboardAdmin.staff;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.layouts.popUp.popUpConfrim;
import com.main.models.dataStaff.loadDataStaff;
import com.main.services.authDataStaff;
import com.main.views.dashboardAdminView;
import com.main.models.dataStaff.getterDataStaff;
import com.main.views.mainFrame;

public class staffDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private textLabel headerLabel, totalStaffLabel;

    private textLabel valueTotalStaffLabel;

    private panelRounded headerPanel, contentPanel, lineQuantityStaff;

    private textField searchField;

    private buttonCustom buttonAdd;

    private tableCustom dataStaffTable;

    private scrollTable scrollDataStaff;

    private appIcons iconApps = new appIcons();

    private imageIcon iconUser = iconApps.getUserIconGreen(35, 35);

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT, buttonType.DELETE, buttonType.DETAIL);

    public staffDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
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
        handelButton();

        headerPanel.add(iconUser);
        headerPanel.add(totalStaffLabel);
        headerPanel.add(valueTotalStaffLabel);
        headerPanel.add(searchField);
        headerPanel.add(buttonAdd);
        headerPanel.add(lineQuantityStaff);

        contentPanel.add(scrollDataStaff);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Staff", 40, 0, 200, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);
        lineQuantityStaff = new panelRounded(320, 35, 5, 50, 3, 3);

        iconUser.setBounds(40, 40, 35, 35);

        totalStaffLabel = new textLabel("Total Staff : ", 100, 45, 200, 30);
        valueTotalStaffLabel = new textLabel("100", 210, 45, 200, 30);

        searchField = new textField(380, 45, 350, 10);
        searchField.setPlaceholder("Search Staff");

        buttonAdd = new buttonCustom("Add", 900, 40, 100, 40, 10);

        tableActionButton actionButton = new tableActionButton() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView
                            .showConfrimPopUp("Do you want to edit Data Staff?");
                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataStaffTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdStaff = dataStaffTable.getValueAt(selectedRow, 0).toString();
                                int idStaff = Integer.parseInt(stringIdStaff.replaceAll("[^0-9]", ""));

                                getterDataStaff selectedDataStaff = loadDataStaff.getDataById(idStaff);

                                if (selectedDataStaff != null) {
                                    parentApp.hideGlassPanel();
                                    parentView.setDataStaffToEdit(selectedDataStaff);
                                    parentView.showFormStaff();
                                } else {
                                    parentView.showFailedPopUp("Data Staff not found!");
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
                            .showConfrimPopUp("Do you want to delete Data Staff?");
                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataStaffTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdStaff = dataStaffTable.getValueAt(selectedRow, 0).toString();
                                int idStaff = Integer.parseInt(stringIdStaff.replaceAll("[^0-9]", ""));
                                boolean isSuccess = authDataStaff.resignStaffById(idStaff);

                                if (isSuccess) {
                                    parentApp.hideGlassPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Staff");
                                    parentView.showDashboardStaff();
                                } else {
                                    parentApp.hideGlassPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Staff");
                                    parentView.showDashboardStaff();
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
                    int selectedRow = dataStaffTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringIdStaff = dataStaffTable.getValueAt(selectedRow, 0).toString();
                        int idStaff = Integer.parseInt(stringIdStaff.replaceAll("[^0-9]", ""));
                        parentView.showDetailPopUpDataStaff(idStaff);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    parentView.showFailedPopUp("Data Staff not found!");
                }
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataStaffTable = new tableCustom(loadDataStaff.getAllDataStaff(), actionButton);

        int actionColumnIndex = 5;
        dataStaffTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataStaffTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataStaff = new scrollTable(dataStaffTable, 0, 0, 1050, 410);

        dataStaffTable.getColumnModel().getColumn(0).setMinWidth(80);
        dataStaffTable.getColumnModel().getColumn(0).setMaxWidth(80);
        dataStaffTable.getColumnModel().getColumn(0).setWidth(80);

        dataStaffTable.getColumnModel().getColumn(3).setMinWidth(120);
        dataStaffTable.getColumnModel().getColumn(3).setMaxWidth(120);
        dataStaffTable.getColumnModel().getColumn(3).setWidth(120);

        dataStaffTable.getColumnModel().getColumn(4).setMinWidth(90);
        dataStaffTable.getColumnModel().getColumn(4).setMaxWidth(90);
        dataStaffTable.getColumnModel().getColumn(4).setWidth(90);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);
        lineQuantityStaff.setBackground(color.DARKGREY);

        totalStaffLabel.setForeground(color.BLACK);
        valueTotalStaffLabel.setForeground(color.BLACK);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
        totalStaffLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 18f));
        valueTotalStaffLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 18f));
    }

    private void handelButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormStaff();
            }
        });
    }

}
