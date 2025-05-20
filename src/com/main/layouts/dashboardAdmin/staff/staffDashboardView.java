package com.main.layouts.dashboardAdmin.staff;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.tableActionButton;
import com.main.models.dataStaff.loadDataStaff;
import com.main.views.dashboardAdminView;

public class staffDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded headerContent;
    private panelRounded contentStaff;

    private buttonCustom buttonAdd;

    private table dataStaffTable;

    private scrollTable scrollDataStaff;

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

        headerContent.add(buttonAdd);

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

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

        dataStaffTable = new table(loadDataStaff.getAllStaff(), new tableActionButton() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit baris ke: " + row);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Hapus baris ke: " + row);
            }

            @Override
            public void onDetail(int row) {
                System.out.println("Detail baris ke: " + row);
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
        headerLabel.setForeground(color.DARKGREEN);
        headerContent.setBackground(color.WHITE);
        contentStaff.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
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
