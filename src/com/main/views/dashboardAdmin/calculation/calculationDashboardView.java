package com.main.views.dashboardAdmin.calculation;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.alternatif.loadDataAlternatif;
import com.main.models.normalisation.loadDataNormalisation;
import com.main.models.rangking.loadDataRangking;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;

public class calculationDashboardView extends contentPanel {

    private mainFrame parentApp;

    private dashboardAdminView parentView;

    private panelRounded headerPanel, containerPanel, contentPanel;

    private datePickerField dateField;

    private textLabel dataAlternatifLabel;

    private tableNoActionButton dataAlternatif, dataNormalisation, dataRangking;

    private scrollTable scrollDataAlternatif, scrollDataNormalisation, scrollDataRangking;

    private scrollPane scrollDataCalculation;

    private buttonCustom buttonAddBobot;

    private String selectedPriode = null;

    public calculationDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;

        initContent();
    }

    @Override
    public void initContent() {
        setLayout();
        setColor();
        setFont();
        setAction();

        headerPanel.add(dateField);
        headerPanel.add(buttonAddBobot);

        contentPanel.add(dataAlternatifLabel);

        contentPanel.add(scrollDataAlternatif);
        contentPanel.add(scrollDataNormalisation);
        contentPanel.add(scrollDataRangking);

        containerPanel.add(contentPanel);

        add(headerPanel);
        add(scrollDataCalculation);

        setVisible(true);
    }

    private void setLayout() {
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        dataAlternatifLabel = new textLabel("Data Alternatif", 40, 20, 300, 40);
        buttonAddBobot = new buttonCustom("Add Bobot", 870, 35, 135, 40, 10);

        containerPanel = new panelRounded(40, 220, 1050, 1200, 0, 0);

        scrollDataCalculation = new scrollPane(containerPanel, 40, 220, 1050, 410);

        contentPanel = new panelRounded(0, 0, 1050, 1200, 10, 10);

        dateField = new datePickerField(40, 20, 300, 30, "Select Date");

        dataAlternatif = new tableNoActionButton(loadDataAlternatif.getAllDataAlternatif());
        scrollDataAlternatif = new scrollTable(dataAlternatif, 0, 80, 1050, 300);

        dataNormalisation = new tableNoActionButton(loadDataNormalisation.getAllDataNormalisation());
        scrollDataNormalisation = new scrollTable(dataNormalisation, 0, 460, 1050, 300);

        dataRangking = new tableNoActionButton(loadDataRangking.getAllDataRangking());
        scrollDataRangking = new scrollTable(dataRangking, 0, 880, 1050, 300);

        setHeaderTableAlternatif();
        setHeaderTableNormalisation();
        setHeaderTableRangking();
    }

    private void setColor() {
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

        dataAlternatifLabel.setForeground(color.BLACK);

    }

    private void setFont() {
        dataAlternatifLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));
    }

    private void setAction() {

        buttonAddBobot.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showDashboardBobotKriteria();
            }
        });

        dateField.getDatePicker().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                try {
                    String fullDate = dateField.getSelectedDate();
                    if (fullDate != null) {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(fullDate);
                        selectedPriode = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);
                        loadTableAlternatif(selectedPriode);
                        loadTableNormalisation(selectedPriode);
                        loadTableRangking(selectedPriode);
                    } else {
                        parentView.showFailedPopUp("Please select a date to display the criteria data");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void loadTableAlternatif(String periode) {
        DefaultTableModel modelAlternatif;
        if (periode == null || periode.isEmpty()) {
            modelAlternatif = new DefaultTableModel();
        } else {
            modelAlternatif = loadDataAlternatif.getAllDataAlternatifByPeriode(periode);
        }

        dataAlternatif.setModel(modelAlternatif);

        if (dataAlternatif instanceof tableNoActionButton customTable) {
            customTable.applyCustomStyle();
        }

        setHeaderTableAlternatif();
    }

    private void loadTableNormalisation(String periode) {
        DefaultTableModel modelNormalisation;
        if (periode == null || periode.isEmpty()) {
            modelNormalisation = new DefaultTableModel();
        } else {
            modelNormalisation = loadDataNormalisation.getAllDataNormalisationByPeriode(periode);
        }

        dataNormalisation.setModel(modelNormalisation);

        if (dataNormalisation instanceof tableNoActionButton customTable) {
            customTable.applyCustomStyle();
        }

        setHeaderTableNormalisation();
    }

    private void loadTableRangking(String periode) {
        DefaultTableModel modelRangking;
        if (periode == null || periode.isEmpty()) {
            modelRangking = new DefaultTableModel();
        } else {
            modelRangking = loadDataRangking.getAllDataRangkingByPeriode(periode);
        }

        dataRangking.setModel(modelRangking);

        if (dataRangking instanceof tableNoActionButton customTable) {
            customTable.applyCustomStyle();
        }

        setHeaderTableRangking();
    }

    private void setHeaderTableAlternatif() {

        dataAlternatif.getColumnModel().getColumn(0).setMinWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setMaxWidth(80);
        dataAlternatif.getColumnModel().getColumn(0).setWidth(80);

        dataAlternatif.getColumnModel().getColumn(1).setMinWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(1).setWidth(0);

        dataAlternatif.getColumnModel().getColumn(2).setMinWidth(300);
        dataAlternatif.getColumnModel().getColumn(2).setMaxWidth(0);
        dataAlternatif.getColumnModel().getColumn(2).setWidth(300);

        dataAlternatif.getColumnModel().getColumn(3).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(3).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(3).setWidth(100);

        dataAlternatif.getColumnModel().getColumn(4).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(4).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(4).setWidth(100);

        dataAlternatif.getColumnModel().getColumn(5).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(5).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(5).setWidth(100);

        dataAlternatif.getColumnModel().getColumn(6).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(6).setWidth(100);

        dataAlternatif.getColumnModel().getColumn(7).setMinWidth(100);
        dataAlternatif.getColumnModel().getColumn(7).setMaxWidth(100);
        dataAlternatif.getColumnModel().getColumn(7).setWidth(100);

    }

    private void setHeaderTableNormalisation() {

        dataNormalisation.getColumnModel().getColumn(0).setMinWidth(80);
        dataNormalisation.getColumnModel().getColumn(0).setMaxWidth(80);
        dataNormalisation.getColumnModel().getColumn(0).setWidth(80);

        dataNormalisation.getColumnModel().getColumn(1).setMinWidth(0);
        dataNormalisation.getColumnModel().getColumn(1).setMaxWidth(0);
        dataNormalisation.getColumnModel().getColumn(1).setWidth(0);

        dataNormalisation.getColumnModel().getColumn(2).setMinWidth(300);
        dataNormalisation.getColumnModel().getColumn(2).setMaxWidth(0);
        dataNormalisation.getColumnModel().getColumn(2).setWidth(300);

        dataNormalisation.getColumnModel().getColumn(3).setMinWidth(100);
        dataNormalisation.getColumnModel().getColumn(3).setMaxWidth(100);
        dataNormalisation.getColumnModel().getColumn(3).setWidth(100);

        dataNormalisation.getColumnModel().getColumn(4).setMinWidth(100);
        dataNormalisation.getColumnModel().getColumn(4).setMaxWidth(100);
        dataNormalisation.getColumnModel().getColumn(4).setWidth(100);

        dataNormalisation.getColumnModel().getColumn(5).setMinWidth(100);
        dataNormalisation.getColumnModel().getColumn(5).setMaxWidth(100);
        dataNormalisation.getColumnModel().getColumn(5).setWidth(100);

        dataNormalisation.getColumnModel().getColumn(6).setMinWidth(100);
        dataNormalisation.getColumnModel().getColumn(6).setMaxWidth(100);
        dataNormalisation.getColumnModel().getColumn(6).setWidth(100);

        dataNormalisation.getColumnModel().getColumn(7).setMinWidth(100);
        dataNormalisation.getColumnModel().getColumn(7).setMaxWidth(100);
        dataNormalisation.getColumnModel().getColumn(7).setWidth(100);

    }

    private void setHeaderTableRangking() {

        dataRangking.getColumnModel().getColumn(0).setMinWidth(80);
        dataRangking.getColumnModel().getColumn(0).setMaxWidth(80);
        dataRangking.getColumnModel().getColumn(0).setWidth(80);

        dataRangking.getColumnModel().getColumn(1).setMinWidth(0);
        dataRangking.getColumnModel().getColumn(1).setMaxWidth(0);
        dataRangking.getColumnModel().getColumn(1).setWidth(0);

        dataRangking.getColumnModel().getColumn(2).setMinWidth(300);
        dataRangking.getColumnModel().getColumn(2).setMaxWidth(300);
        dataRangking.getColumnModel().getColumn(2).setWidth(300);

        dataRangking.getColumnModel().getColumn(4).setMinWidth(150);
        dataRangking.getColumnModel().getColumn(4).setMaxWidth(150);
        dataRangking.getColumnModel().getColumn(4).setWidth(150);
    }

}
