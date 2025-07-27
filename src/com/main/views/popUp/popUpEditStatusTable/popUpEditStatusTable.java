package com.main.views.popUp.popUpEditStatusTable;

import com.main.components.panelApps.popUpPanel;
import com.main.routes.dashboardStaffView;
import com.main.routes.mainFrame;
import com.main.services.authDataTable;

import javax.swing.JLabel;

import com.main.components.*;

public class popUpEditStatusTable extends popUpPanel {

    private mainFrame parentApp;
    private dashboardStaffView parentView;

    private textLabel headerLabel;

    private comboBox<String> statusField;

    private buttonCustom buttonCancel, buttonConfrim;

    private int idTable;

    public popUpEditStatusTable(mainFrame parentApp, dashboardStaffView parentView, int idTable) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;
        this.idTable = idTable;
        setSize(400, 260);
        initComponent();
    }

    private void initComponent() {
        setLayout();
        setFont();
        setColor();
        setAction();

        add(headerLabel);
        add(statusField);
        add(buttonCancel);
        add(buttonConfrim);

        setVisible(true);
    }

    private void setLayout() {
        headerLabel = new textLabel("Edit Status Table", 0, 0, 400, 80);

        String[] statusFields = { null, "Available", "Cleaning", "Out of Order", "Reserved" };
        statusField = new comboBox<>(statusFields, 40, 100, 320, 30, 10);
        statusField.setPlaceholder("Select status");

        buttonCancel = new buttonCustom("Cancel", 40, 190, 140, 40, 10);
        buttonConfrim = new buttonCustom("Save", 220, 190, 140, 40, 10);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));

        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
    }

    private void setAction() {
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentApp.hideGlassNotificationPanel();
            }
        });

        buttonConfrim.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String selectedStatus = (String) statusField.getSelectedItem();

                if (selectedStatus == null || selectedStatus.trim().isEmpty()) {
                    parentView.showFailedPopUp("Please Select a Status");
                    return;
                }

                boolean success = authDataTable.updateStatusTable(idTable, selectedStatus);
                if (success) {
                    parentView.showSuccessPopUp("Status updated successfully!");
                    parentApp.hideGlassFormPanel();
                    parentView.showDashboardTable();
                } else {
                    parentView.showFailedPopUp("Failed to update status.");
                }
            }
        });
    }

}
