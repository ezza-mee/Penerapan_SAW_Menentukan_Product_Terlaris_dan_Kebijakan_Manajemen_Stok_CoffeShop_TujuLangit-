package com.main.views.dashboardAdmin.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.alternatif.loadDataAlternatif;
import com.main.models.entity.dataAlternatif;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;
import com.main.services.authDataSaw;

public class calculationDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private panelRounded headerPanel, contentPanel;

    private datePickerField dateField;

    private textLabel dataAlternatifLabel;

    private tableNoActionButton dataAlternatif, dataNormalisation, dataRanking;

    private scrollTable scrollDataAlternatif, scrollDataNormalisation, scrollDataRanking;

    private scrollPane scrollDataCalculation;

    private buttonCustom buttonAddBobot, buttonCalculation;

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
        handelButton();

        headerPanel.add(dateField);
        headerPanel.add(buttonAddBobot);

        contentPanel.add(dataAlternatifLabel);

        contentPanel.add(buttonCalculation);
        contentPanel.add(scrollDataAlternatif);
        contentPanel.add(scrollDataNormalisation);
        contentPanel.add(scrollDataRanking);

        add(headerPanel);
        add(scrollDataCalculation);

        setVisible(true);
    }

    private void setPosition() {
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        dataAlternatifLabel = new textLabel("Data Alternatif", 40, 20, 300, 40);

        buttonAddBobot = new buttonCustom("Add Bobot", 870, 35, 135, 40, 10);
        buttonCalculation = new buttonCustom("Calculation", 870, 35, 135, 40, 10);

        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);
        scrollDataCalculation = new scrollPane(contentPanel, 40, 220, 1050, 410);

        dateField = new datePickerField(40, 20, 300, 30, "Select Date");

        dataNormalisation = new tableNoActionButton(null);
        scrollDataNormalisation = new scrollTable(dataNormalisation, 0, 500, 1050, 300);

        dataRanking = new tableNoActionButton(null);
        scrollDataRanking = new scrollTable(dataRanking, 0, 900, 1050, 300);

        dataAlternatif = new tableNoActionButton(loadDataAlternatif.getAllDataAlternatif());
        scrollDataAlternatif = new scrollTable(dataAlternatif, 0, 80, 1050, 300);

        dataAlternatif.getColumnModel().getColumn(0).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(1).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(2).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(2).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(2).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(3).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(3).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(3).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(6).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setWidth(100);
 
        dataAlternatif.getColumnModel().getColumn(7).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(7).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(7).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(8).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(8).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(8).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(9).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(9).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(9).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(10).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(10).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(10).setWidth(100);

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

        dataAlternatifLabel.setForeground(color.BLACK);

    }

    private void setFont() {
        dataAlternatifLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));

    }

    private void handelButton() {
        buttonAddBobot.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showDashboardBobotKriteria();
            }
        });

        buttonCalculation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String periode = dateField.getSelectedDate();
                if (periode != null && !periode.isEmpty()) {
                    authDataSaw.executeSAW(periode);
                    parentView.showSuccessPopUp("Data Berhasil diNormalisation" + periode);
                } else {
                    parentView.showFailedPopUp("Silahkan Pilih Periode!");
                }
            }
        });
    }

    private void loadTableData(String periode) {
        DefaultTableModel model;
        if (periode == null || periode.isEmpty()) {
            model = new DefaultTableModel();
        } else {
            model = loadDataAlternatif.getAllDataAlternatifByPeriode(periode);
        }

        dataAlternatif.setModel(model);

        if (dataAlternatif instanceof tableNoActionButton customTable) {
            customTable.applyCustomStyle();
        }

        dataAlternatif.getColumnModel().getColumn(0).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(1).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(2).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(2).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(2).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(3).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(3).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(3).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(6).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setWidth(100);

        dataAlternatif.getColumnModel().getColumn(7).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(7).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(7).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(8).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(8).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(8).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(9).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(9).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(9).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(10).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(10).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(10).setWidth(100);

        for (int i = 1; i <= 4; i++) {
            dataAlternatif.getColumnModel().getColumn(i).setMinWidth(0);
            dataAlternatif.getColumnModel().getColumn(i).setMaxWidth(0);
            dataAlternatif.getColumnModel().getColumn(i).setWidth(0);
        }
    }

}
