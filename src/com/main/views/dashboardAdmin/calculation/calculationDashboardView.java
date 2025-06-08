package com.main.views.dashboardAdmin.calculation;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.kriteria.loadDataKriteria;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;

public class calculationDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private panelRounded headerPanel, contentPanel;

    private datePickerField dateField;

    private tableCustomNoAction dataKriteria;

    private scrollTable scrollDataKriteria;

    private String selectedPriode = null;

    public calculationDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
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

        headerPanel.add(dateField);
        contentPanel.add(scrollDataKriteria);

        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        dateField = new datePickerField(40, 20, 300, 30, "Select Date");

        dataKriteria = new tableCustomNoAction(loadDataKriteria.getAllDataKriteria());
        scrollDataKriteria = new scrollTable(dataKriteria, 0, 0, 1050, 410);

        dateField.getDatePicker().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                try {
                    String fullDate = dateField.getSelectedDate();
                    if (fullDate != null) {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(fullDate);
                        selectedPriode = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);
                        loadTableData(selectedPriode);
                    } else {
                        parentView.showFailedPopUp("Please select a date to display the criteria data");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void setColor() {
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

    }

    private void setFont() {

    }

    private void loadTableData(String periode) {
        DefaultTableModel model;
        if (periode == null || periode.isEmpty()) {
            model = new DefaultTableModel();
        } else {
            model = loadDataKriteria.getAllDataKriteriaByPeriode(periode);
        }
        dataKriteria.setModel(model);
    }

}
