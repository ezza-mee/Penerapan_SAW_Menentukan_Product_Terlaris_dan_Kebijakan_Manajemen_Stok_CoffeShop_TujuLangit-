package com.main.views.popUp.popUpBobotKriteria;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.controller.actionButtonTable;
import com.main.models.bobotKriteria.loadDataBobotKriteria;
import com.main.models.entity.dataBobotKriteria;
import com.main.routes.dashboardAdminView;
import com.main.views.popUp.popUpConfrim;
import com.main.routes.mainFrame;
import com.main.services.authDataBobotKriteria;

public class popUpDataBobotKriteria extends popUpPanel {

    private mainFrame parentApp;
    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private tableActionButton dataBobotKriteria;

    private scrollTable scrollDataBobotKriteria;

    private buttonCustom buttonBack, buttonAdd;

    private appIcons appIcons = new appIcons();
    private imageIcon backIcon = appIcons.getBackIconWhite(25, 25);
    private imageIcon addIcon = appIcons.getAddIconWhite(25, 25);

    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT, buttonType.DELETE);

    public popUpDataBobotKriteria(mainFrame parentApp, dashboardAdminView parentView) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;

        setSize(1000, 500);
        initComponent();
    }

    private void initComponent() {
        setLayout();
        setColor();
        setFont();
        handleButton();

        add(scrollDataBobotKriteria);

        add(headerLabel);
        add(buttonBack);
        add(buttonAdd);

        setVisible(true);
    }

    private void setLayout() {
        headerLabel = new textLabel("Data Nilai Bobot Kriteria", 50, 20, 400, 80);
        buttonBack = new buttonCustom("", 50, 400, 50, 40, 10);
        buttonAdd = new buttonCustom("", 880, 40, 50, 40, 10);

        buttonBack.setIcon(backIcon);
        buttonAdd.setIcon(addIcon);

        actionButtonTable actionButton = new actionButtonTable() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataBobotKriteria.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSBobotKriteria = dataBobotKriteria.getValueAt(selectedRow,
                                        0).toString();
                                int idBobotKriteria = Integer.parseInt(stringIdSBobotKriteria.replaceAll("[^0-9]", ""));

                                dataBobotKriteria selectedDataSBobotKriteria = loadDataBobotKriteria
                                        .getDataById(idBobotKriteria);

                                if (selectedDataSBobotKriteria != null) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFormDataKriteria();
                                    parentView.setDataBobotKriteriaToEdit(selectedDataSBobotKriteria);
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Data BobotKriteria not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
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
                            .showConfrimPopUp("do you want to delete data Bobot Kriteria?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataBobotKriteria.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdBobotKriteria = dataBobotKriteria.getValueAt(selectedRow, 0).toString();
                                int idBobotKriteria = Integer.parseInt(stringIdBobotKriteria.replaceAll("[^0-9]", ""));
                                boolean isSuccess = authDataBobotKriteria.deleteBobotKriteria(idBobotKriteria);

                                if (isSuccess) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showDashboardBobotKriteria();
                                    parentView.showSuccessPopUp("Success Delete Data BobotKriteria");
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showDashboardBobotKriteria();
                                    parentView.showFailedPopUp("Failed Delete Data BobotKriteria");
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
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

        dataBobotKriteria = new tableActionButton(loadDataBobotKriteria.getAllDataBobotKriteria(), actionButton);

        int actionColumnIndex = 5;
        dataBobotKriteria.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataBobotKriteria.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataBobotKriteria = new scrollTable(dataBobotKriteria, 0, 100, 1000,
                300);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));

    }

    private void handleButton() {
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentApp.hideGlassDashboardPanel();
            }
        });

        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormDataKriteria();
            }
        });
    }
}
