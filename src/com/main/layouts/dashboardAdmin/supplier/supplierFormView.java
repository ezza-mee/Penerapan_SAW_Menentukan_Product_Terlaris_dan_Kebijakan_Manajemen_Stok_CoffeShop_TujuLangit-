package com.main.layouts.dashboardAdmin.supplier;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.views.dashboardAdminView;

public class supplierFormView extends contentPanel {

    private dashboardAdminView parentView;

    private panelRounded contentPanel;

    private textLabel headerLabel;

    private textLabel nameLabel, amountLabel, unitLabel, descriptionLabel;

    private textField nameField, amountField;

    private comboBox<String> unitField;

    private textArea descriptionField;

    private buttonCustom buttonBack, buttonReset, buttonSave;

    public supplierFormView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handleButton();

        contentPanel.add(nameLabel);
        contentPanel.add(amountLabel);
        contentPanel.add(unitLabel);
        contentPanel.add(descriptionLabel);

        contentPanel.add(nameField);
        contentPanel.add(amountField);
        contentPanel.add(unitField);
        contentPanel.add(descriptionField);

        contentPanel.add(buttonBack);
        contentPanel.add(buttonReset);
        contentPanel.add(buttonSave);

        add(headerLabel);
        add(contentPanel);

        setVisible(true);

    }

    private void setPosition() {
        headerLabel = new textLabel("Input Data Supplier", 40, 0, 400, 80);
        contentPanel = new panelRounded(40, 80, 1050, 550, 10, 10);

        nameLabel = new textLabel("Supplier", 180, 30, 300, 80);
        amountLabel = new textLabel("Amount", 180, 130, 300, 80);
        unitLabel = new textLabel("Unit", 580, 130, 300, 80);
        descriptionLabel = new textLabel("Description", 180, 230, 300, 80);

        nameField = new textField(180, 85, 700, 10);
        amountField = new textField(180, 185, 300, 10);

        String[] unitItems = { null, "Pcs", "Box", "Kg", "Liter", "Pack", "Dus", "Botol" };
        unitField = new comboBox<>(unitItems, 580, 185, 300, 30, 10);
        unitField.setPlaceholder("Select your Unit");

        descriptionField = new textArea(180, 285, 700, 140, 10);

        nameField.setPlaceholder("Enter Supplier Name");
        amountField.setPlaceholder("Enter Amount Supplier");
        descriptionField.setPlaceholder("Enter Description Supplier");

        buttonBack = new buttonCustom("Back", 180, 470, 100, 40, 10);
        buttonReset = new buttonCustom("Reset", 640, 470, 100, 40, 10);
        buttonSave = new buttonCustom("Save", 780, 470, 100, 40, 10);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        contentPanel.setBackground(color.WHITE);

        nameLabel.setForeground(color.BLACK);
        amountLabel.setForeground(color.BLACK);
        unitLabel.setForeground(color.BLACK);
        descriptionLabel.setForeground(color.BLACK);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));

        nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        amountLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        unitLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        descriptionLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
    }

    private void handleButton() {
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                parentView.showDashboardSupplier();
            }
        });
    }

}
