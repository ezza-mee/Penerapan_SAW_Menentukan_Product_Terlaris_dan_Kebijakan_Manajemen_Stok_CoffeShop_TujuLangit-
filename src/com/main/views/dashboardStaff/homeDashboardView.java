package com.main.views.dashboardStaff;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.auth.sessionLogin;
import com.main.auth.utils.Role;
import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.product.loadDataProduct;
import com.main.models.rangking.loadDataRangking;
import com.main.models.transaction.loadDataTransaction;
import com.main.models.table.loadDataTable;
import com.main.routes.dashboardStaffView;

public class homeDashboardView extends contentPanel {

    private Role role;

    private dashboardStaffView parentView;

    private panelRounded panelProduct;
    private panelRounded panelHistoryTransaction;
    private panelRounded panelTable;
    private panelRounded panelTransaction;
    private panelRounded panelDiagramTransaction;

    private panelRounded panelSupplier;
    private panelRounded panelSupplierPending;
    private panelRounded panelSupplierStock;
    private panelRounded panelSupplierOutOfStock;
    private panelRounded panelDataSupplier;

    private textLabel labelProduct;
    private textLabel labelTable;
    private textLabel labelHistoryTransaction;
    private textLabel labelTransaction;

    private textLabel valueProduct;
    private textLabel valueTable;
    private textLabel valueHistoryTransaction;
    private textLabel valueTransaction;

    private appIcons appIcons = new appIcons();

    private imageIcon iconProduct = appIcons.getProductIconHover(55, 55);
    private imageIcon iconTable = appIcons.getTableIconHover(55, 55);
    private imageIcon iconHistoryTransaction = appIcons.getHistoryTransactionIconHover(55, 55);
    private imageIcon iconTransaction = appIcons.getTransactionIconHover(55, 55);

    int idStaff = sessionLogin.get().getIdStaff();

    private int quantyAllDataProduct = loadDataProduct.getAllQuantityDataProduct();
    private int quantyAllDataTable = loadDataTable.getAllQuantityDataTable();
    private int quantyAllDataHistoryTransaction = loadDataTransaction
            .getAllQuantityDataTransactionByStatusDone(idStaff);
    private int quantyAllDataTransaction = loadDataTransaction.getAllQuantityDataTransactionByStatusProcess(idStaff);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String today = sdf.format(new Date());

    private String selectedPriode = null;

    private datePickerField dateField;

    private tableNoActionButton dataRangking;
    private scrollTable scrollDataRangking;

    public homeDashboardView(dashboardStaffView parentView, Role role) {
        super();
        this.parentView = parentView;
        this.role = role;
        initContent();
    }

    @Override
    public void initContent() {
        setLayout();
        setColor();
        setFont();
        setAction();

        System.out.println("Role Dashboard Home : " + role);
        if (role == Role.CASHIER) {
            panelProduct.add(iconProduct);
            panelProduct.add(labelProduct);
            panelProduct.add(valueProduct);

            panelTable.add(iconTable);
            panelTable.add(labelTable);
            panelTable.add(valueTable);

            panelHistoryTransaction.add(iconHistoryTransaction);
            panelHistoryTransaction.add(labelHistoryTransaction);
            panelHistoryTransaction.add(valueHistoryTransaction);

            panelTransaction.add(iconTransaction);
            panelTransaction.add(labelTransaction);
            panelTransaction.add(valueTransaction);

            panelDiagramTransaction.add(dateField);
            panelDiagramTransaction.add(scrollDataRangking);

            add(panelProduct);
            add(panelHistoryTransaction);
            add(panelTable);
            add(panelTransaction);
            add(panelDiagramTransaction);
        } else if (role == Role.SUPPLIER) {
            add(panelSupplier);
            add(panelSupplierPending);
            add(panelSupplierStock);
            add(panelSupplierOutOfStock);
            add(panelDataSupplier);
        }

        setVisible(true);
    }

    private void setLayout() {
        // content home for staff cashier
        panelProduct = new panelRounded(40, 40, 230, 150, 10, 10);
        panelTable = new panelRounded(310, 40, 230, 150, 10, 10);
        panelHistoryTransaction = new panelRounded(580, 40, 230, 150, 10, 10);
        panelTransaction = new panelRounded(850, 40, 230, 150, 10, 10);
        panelDiagramTransaction = new panelRounded(40, 230, 1040, 400, 10, 10);

        labelProduct = new textLabel("Data Product", 0, 10, 230, 40);
        labelTable = new textLabel("Data Table", 0, 10, 230, 40);
        labelHistoryTransaction = new textLabel("History Transaction", 0, 10, 230, 40);
        labelTransaction = new textLabel("Data Transaction", 0, 10, 230, 40);

        String stringDataProduct = String.valueOf(quantyAllDataProduct);
        String stringDataTable = String.valueOf(quantyAllDataTable);
        String stringDataHistoryTransaction = String.valueOf(quantyAllDataHistoryTransaction);
        String stringDataTransaction = String.valueOf(quantyAllDataTransaction);

        valueProduct = new textLabel(stringDataProduct, 100, 45, 100, 80);
        valueTable = new textLabel(stringDataTable, 100, 45, 100, 80);
        valueHistoryTransaction = new textLabel(stringDataHistoryTransaction, 100, 45, 100, 80);
        valueTransaction = new textLabel(stringDataTransaction, 100, 45, 100, 80);

        iconProduct.setBounds(20, 55, 55, 55);
        iconTable.setBounds(20, 55, 55, 55);
        iconHistoryTransaction.setBounds(20, 55, 55, 55);
        iconTransaction.setBounds(20, 55, 55, 55);

        dateField = new datePickerField(20, 20, 300, 40, today);

        dataRangking = new tableNoActionButton(loadDataRangking.getAllDataRangking());
        scrollDataRangking = new scrollTable(dataRangking, 0, 80, 1050, 300);

        // content home for staff supplier
        panelSupplier = new panelRounded(40, 40, 230, 150, 10, 10);
        panelSupplierPending = new panelRounded(310, 40, 230, 150, 10, 10);
        panelSupplierStock = new panelRounded(580, 40, 230, 150, 10, 10);
        panelSupplierOutOfStock = new panelRounded(850, 40, 230, 150, 10, 10);
        panelDataSupplier = new panelRounded(40, 230, 1040, 400, 10, 10);

    }

    private void setColor() {
        panelProduct.setBackground(color.WHITE);
        panelHistoryTransaction.setBackground(color.WHITE);
        panelTable.setBackground(color.WHITE);
        panelTransaction.setBackground(color.WHITE);
        panelDiagramTransaction.setBackground(color.WHITE);

        panelSupplier.setBackground(color.WHITE);
        panelSupplierPending.setBackground(color.WHITE);
        panelSupplierStock.setBackground(color.WHITE);
        panelSupplierOutOfStock.setBackground(color.WHITE);
        panelDataSupplier.setBackground(color.WHITE);

        labelProduct.setForeground(color.DARKGREEN);
        labelTable.setForeground(color.DARKGREEN);
        labelHistoryTransaction.setForeground(color.DARKGREEN);
        labelTransaction.setForeground(color.DARKGREEN);

        valueProduct.setForeground(color.DARKGREEN);
        valueTable.setForeground(color.DARKGREEN);
        valueHistoryTransaction.setForeground(color.DARKGREEN);
        valueTransaction.setForeground(color.DARKGREEN);

    }

    private void setFont() {
        labelProduct.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));
        labelTable.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));
        labelHistoryTransaction.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));
        labelTransaction.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));

        valueProduct.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 22f));
        valueTable.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 22f));
        valueHistoryTransaction.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 22f));
        valueTransaction.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 22f));

        labelProduct.setHorizontalAlignment(JLabel.CENTER);
        labelTable.setHorizontalAlignment(JLabel.CENTER);
        labelHistoryTransaction.setHorizontalAlignment(JLabel.CENTER);
        labelTransaction.setHorizontalAlignment(JLabel.CENTER);

        valueProduct.setHorizontalAlignment(JLabel.CENTER);
        valueTable.setHorizontalAlignment(JLabel.CENTER);
        valueHistoryTransaction.setHorizontalAlignment(JLabel.CENTER);
        valueTransaction.setHorizontalAlignment(JLabel.CENTER);
    }

    private void setAction() {
        dateField.getDatePicker().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                try {
                    String fullDate = dateField.getSelectedDate();
                    if (fullDate != null) {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(fullDate);
                        selectedPriode = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);
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