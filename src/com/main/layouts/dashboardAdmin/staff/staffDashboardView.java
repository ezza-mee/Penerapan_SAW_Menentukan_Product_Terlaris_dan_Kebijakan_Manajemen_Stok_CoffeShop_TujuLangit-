package com.main.layouts.dashboardAdmin.staff;

import javax.swing.JOptionPane;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.models.dataStaff.loadDataStaff;
import com.main.services.authDataStaff;
import com.main.views.dashboardAdminView;
import com.main.models.dataStaff.getterDataStaff;

public class staffDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel, totalStaffLabel;

    private textLabel valueTotalStaffLabel;

    private panelRounded headerContent, contentStaff, lineQuantityStaff;

    private textField searchField;

    private buttonCustom buttonAdd;

    private table dataStaffTable;

    private scrollTable scrollDataStaff;

    private appIcons iconApps = new appIcons();

    private imageIcon iconUser = iconApps.getUserIconGreen(35, 35);

    public staffDashboardView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handelButton();

        headerContent.add(iconUser);
        headerContent.add(totalStaffLabel);
        headerContent.add(valueTotalStaffLabel);
        headerContent.add(searchField);
        headerContent.add(buttonAdd);
        headerContent.add(lineQuantityStaff);

        contentStaff.add(scrollDataStaff);

        add(headerLabel);
        add(headerContent);
        add(contentStaff);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Staff", 40, 0, 200, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentStaff = new panelRounded(40, 220, 1050, 410, 10, 10);
        lineQuantityStaff = new panelRounded(320, 35, 5, 50, 3, 3);

        iconUser.setBounds(40, 40, 35, 35);

        totalStaffLabel = new textLabel("Total Staff : ", 100, 45, 200, 30);
        valueTotalStaffLabel = new textLabel("100", 210, 45, 200, 30);

        searchField = new textField(380, 45, 350, 10);
        searchField.setPlaceholder("Search Staff");

        buttonAdd = new buttonCustom("Add", 900, 40, 100, 40, 10);

        dataStaffTable = new table(loadDataStaff.getAllDataStaff(), new tableActionButton() {
            @Override
            public void onEdit(int row) {
                try {
                    int selectedRow = dataStaffTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringIdStaff = dataStaffTable.getValueAt(selectedRow, 0).toString();
                        int idStaff = Integer.parseInt(stringIdStaff.replaceAll("[^0-9]", ""));

                        getterDataStaff selectedDataStaff = loadDataStaff.getDataById(idStaff);

                        if (selectedDataStaff != null) {
                            System.out.println("Edit baris ke: " + idStaff);

                            parentView.setDataStaffToEdit(selectedDataStaff); 
                            parentView.showFormStaff();

                            System.out.println("Name: " + selectedDataStaff.getName());
                            System.out.println("Email: " + selectedDataStaff.getEmail());
                            System.out.println("Phone: " + selectedDataStaff.getPhoneNumber());
                            System.out.println("Gender: " + selectedDataStaff.getGender());
                            System.out.println("Jobdesk: " + selectedDataStaff.getJobdesk());
                            System.out.println("Address: " + selectedDataStaff.getAddress());
                        } else {
                            System.out.println("Data staff tidak ditemukan.");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {
                    int selectedRow = dataStaffTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String stringIdStaff = dataStaffTable.getValueAt(selectedRow, 0).toString();
                        int idStaff = Integer.parseInt(stringIdStaff.replaceAll("[^0-9]", ""));
                        boolean isSuccess = authDataStaff.resignStaffById(idStaff);

                        if (isSuccess) {
                            parentView.showSuccessPopUp("Success Delete Data Staff");
                            parentView.showDashboardStaff();
                        } else {
                            parentView.showFailedPopUp("Failed Delete Data Staff");
                            parentView.showDashboardStaff();
                        }
                    }
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
                        System.out.println("Detail baris ke: " + idStaff);

                        parentView.showDetailPopUpDataStaff(idStaff);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Gagal menampilkan detail staff!");
                }
            }
        });

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
        headerContent.setBackground(color.WHITE);
        contentStaff.setBackground(color.WHITE);
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
