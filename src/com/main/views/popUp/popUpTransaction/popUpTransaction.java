package com.main.views.popUp.popUpTransaction;

import java.util.List;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import com.main.auth.sessionLogin;
import com.main.auth.sessionManager;
import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.models.entity.dataTable;
import com.main.models.entity.listTransactionProduct;
import com.main.routes.dashboardStaffView;
import com.main.routes.mainFrame;
import com.main.services.authDataProcessStokManager;
import com.main.services.authDataTable;
import com.main.services.authDataTransaction;

public class popUpTransaction extends popUpPanel {

    private mainFrame parentApp;

    private dashboardStaffView parentView;

    private textLabel headerLabel, numberTableLabel, nameLabel, descriptionLabel, paymentLabel;

    private textLabel numberTableEmptyLabel, nameEmptyLabel, descriptionEmptyLabel, paymentEmptyLabel;

    private textField nameField;

    private textArea descriptionField;

    private comboBox<String> paymentField;
    private comboBox<dataTable> numberTableField;

    private scrollPane scrollDescription;

    private buttonCustom buttonConfrim, buttonCancel;

    private List<listTransactionProduct> listProduct;

    private int subQuantity, subPrice;

    public popUpTransaction(mainFrame parentApp, dashboardStaffView parentView,
            List<listTransactionProduct> listProduct, int subQuantity, int subPrice) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;
        this.listProduct = listProduct;
        this.subQuantity = subQuantity;
        this.subPrice = subPrice;

        System.out.println("list product : " + listProduct);
        System.out.println("sub quantity : " + subQuantity);
        System.out.println("sub price : " + subPrice);
        setSize(600, 600);
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();
        handleButton();

        add(headerLabel);
        add(numberTableLabel);
        add(nameLabel);
        add(descriptionLabel);
        add(paymentLabel);

        add(numberTableField);
        add(nameField);
        add(scrollDescription);
        add(paymentField);

        add(buttonConfrim);
        add(buttonCancel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Input Data Transaction", 0, 30, 600, 50);

        numberTableLabel = new textLabel("Name Table", 70, 100, 300, 40);
        nameLabel = new textLabel("Name", 70, 190, 300, 40);
        descriptionLabel = new textLabel("Description", 70, 280, 300, 40);
        paymentLabel = new textLabel("payment", 70, 410, 300, 40);

        numberTableEmptyLabel = new textLabel("Number Table is Empty", 70, 155, 300, 40);
        nameEmptyLabel = new textLabel("Name is Empty", 70, 245, 300, 40);
        descriptionEmptyLabel = new textLabel("Description is Empty", 70, 380, 300, 40);
        paymentEmptyLabel = new textLabel("Payment is Empty", 70, 460, 455, 40);

        List<dataTable> tableList = authDataTable.loadDataTable();

        if (tableList.isEmpty()) {
            tableList.add(new dataTable(0, "Data Table Not Found", "", ""));
        }

        numberTableField = new comboBox<>(
                tableList.toArray(new dataTable[0]), 70, 135, 460, 30, 10);

        String numbertablePlaceHolder = "Select Number table";

        numberTableField.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if (index == -1 && value == null) {
                    setText(numbertablePlaceHolder);
                    setForeground(color.DARKGREY);
                } else if (value instanceof dataTable dataTable) {
                    setText(dataTable.getNumber());
                    setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
                    setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                } else {
                    setText(value != null ? value.toString() : "");
                }
                return this;
            }
        });

        nameField = new textField(70, 225, 460, 10);
        descriptionField = new textArea(70, 310, 460, 80, 10);

        String[] paymentItems = { null, "Cash", "QRIS", "Mandiri", "BCA", "BSI" };
        paymentField = new comboBox<>(paymentItems, 70, 440, 460, 30, 10);
        paymentField.setPlaceholder("Select Payment");

        buttonCancel = new buttonCustom("Cancel", 70, 530, 180, 40, 10);
        buttonConfrim = new buttonCustom("Save", 350, 530, 180, 40, 10);

        scrollDescription = new scrollPane(descriptionField, 70, 310, 460, 80);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        numberTableLabel.setForeground(color.BLACK);
        nameLabel.setForeground(color.BLACK);
        descriptionLabel.setForeground(color.BLACK);
        paymentLabel.setForeground(color.BLACK);

        numberTableEmptyLabel.setForeground(color.RED);
        nameEmptyLabel.setForeground(color.RED);
        descriptionEmptyLabel.setForeground(color.RED);
        paymentEmptyLabel.setForeground(color.RED);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        numberTableLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
        nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
        descriptionLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
        paymentLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));

        numberTableEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        nameEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        descriptionEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        paymentEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
    }

    private void handleButton() {
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentApp.hideGlassPanel();
            }
        });

        buttonConfrim.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String customerName = nameField.getText().trim();
                String description = descriptionField.getText().trim();
                String paymentMethod = (String) paymentField.getSelectedItem();
                dataTable selectedTable = (dataTable) numberTableField.getSelectedItem();

                remove(numberTableEmptyLabel);
                remove(nameEmptyLabel);
                remove(descriptionEmptyLabel);
                remove(paymentEmptyLabel);

                String validation = new authDataTransaction().validateDataTransactionInput(
                        selectedTable != null ? selectedTable.getNumber() : null,
                        customerName,
                        description,
                        paymentMethod);

                switch (validation) {
                    case "ALL_FIELDS_EMPTY":
                        add(numberTableEmptyLabel);
                        add(nameEmptyLabel);
                        add(descriptionEmptyLabel);
                        add(paymentEmptyLabel);
                        break;
                    case "NUMBER_EMPTY":
                        add(numberTableEmptyLabel);
                        break;
                    case "NAME_EMPTY":
                        add(nameEmptyLabel);
                        break;
                    case "DESCRIPTION_EMPTY":
                        add(descriptionEmptyLabel);
                        break;
                    case "PAYMENT_EMPTY":
                        add(paymentEmptyLabel);
                        break;
                    case "VALID":
                        try {
                            int idStaff = sessionLogin.get().getIdStaff();
                            String staffName = sessionManager.getStaffData().getName();

                            System.out.println("idStaff : " + idStaff);
                            System.out.println("Name Staff : " + staffName);
                            String numberTable = selectedTable.getNumber();
                            int idTable = selectedTable.getIdtable();

                            int idTransaction = authDataTransaction.insertDataTransaction(
                                    idStaff,
                                    idTable,
                                    staffName,
                                    numberTable,
                                    customerName,
                                    subQuantity,
                                    subPrice,
                                    description,
                                    paymentMethod,
                                    listProduct);

                            if (idTransaction > 0) {
                                for (listTransactionProduct product : listProduct) {
                                    int idProduct = product.getIdProduct();
                                    authDataProcessStokManager.processManagerStok(idProduct, idTransaction);
                                }
                                parentView.showDashboardTransaction();
                                parentView.showSuccessPopUp("Transaction successful");
                                parentApp.hideGlassPanel();
                            } else {
                                parentView.showFailedPopUp("Transaction failed");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            parentView.showFailedPopUp("Transaction failed");
                        }
                        break;
                }

                revalidate();
                repaint();
            }
        });
    }
}
