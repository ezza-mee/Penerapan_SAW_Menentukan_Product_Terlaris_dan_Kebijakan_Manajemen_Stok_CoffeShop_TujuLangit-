package com.main.layouts.dashboardAdmin.product;

import com.main.components.panelApps.contentPanel;
import com.main.views.dashboardAdminView;
import com.main.components.*;

public class productFormView extends contentPanel {

    private dashboardAdminView parentView;

    private panelRounded contentPanel;

    private textLabel headerLabel, nameProductLabel, priceProductLabel, categoryProductLabel, imageProductLabel,
            descriptionProductLabel;

    private textLabel nameEmptyLabel, priceEmptyLabel, categoryEmptyLabel, descriptionEmptyLabel;

    private textField nameProductField, priceProductField;
    private textField imagePathField;
    private textArea descriptionProductField;

    private buttonInputImage buttonInputImage;
    private textLabel pathImageLabel;

    private comboBox<String> categoryProductField;

    private button buttonBack, buttonReset, buttonSave;

    private scrollPane scrollDescription;

    public productFormView(dashboardAdminView parentView) {
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

        contentPanel.add(nameProductLabel);
        contentPanel.add(priceProductLabel);
        contentPanel.add(categoryProductLabel);
        contentPanel.add(descriptionProductLabel);
        contentPanel.add(imageProductLabel);

        contentPanel.add(nameEmptyLabel);
        contentPanel.add(priceEmptyLabel);
        contentPanel.add(categoryEmptyLabel);
        contentPanel.add(descriptionEmptyLabel);

        contentPanel.add(nameProductField);
        contentPanel.add(priceProductField);
        contentPanel.add(categoryProductField);
        contentPanel.add(scrollDescription);

        contentPanel.add(buttonInputImage);
        contentPanel.add(imagePathField);
        contentPanel.add(pathImageLabel);

        contentPanel.add(buttonBack);
        contentPanel.add(buttonReset);
        contentPanel.add(buttonSave);

        add(headerLabel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        contentPanel = new panelRounded(40, 80, 1050, 550, 10, 10);

        headerLabel = new textLabel("Input Data Product", 40, 0, 300, 80);
        nameProductLabel = new textLabel("Name Product", 180, 30, 300, 80);
        priceProductLabel = new textLabel("Price Product", 180, 130, 300, 80);
        categoryProductLabel = new textLabel("Category Product", 180, 230, 300, 80);
        imageProductLabel = new textLabel("Image Product", 580, 30, 300, 80);
        descriptionProductLabel = new textLabel("Description Product", 580, 130, 300, 80);
        pathImageLabel = new textLabel("path : ", 580, 90, 300, 80);

        nameEmptyLabel = new textLabel("Name Product is Empty", 180, 90, 200, 80);
        priceEmptyLabel = new textLabel("Price Product is Empty", 180, 190, 200, 80);
        categoryEmptyLabel = new textLabel("Category Product is Empty", 180, 290, 200, 80);
        descriptionEmptyLabel = new textLabel("Description Product is Empty", 580, 370, 200, 80);

        nameProductField = new textField(180, 85, 300, 10);
        priceProductField = new textField(180, 185, 300, 10);
        descriptionProductField = new textArea(580, 185, 300, 200, 10);
        imagePathField = new textField(580, 85, 300, 10);

        nameProductField.setPlaceholder("Input Name Product");
        priceProductField.setPlaceholder("Input Price Product");
        descriptionProductField.setPlaceholder("Input Description Product");

        buttonInputImage = new buttonInputImage("Selected Image", 580, 85, 300, 30, 10, imagePathField, pathImageLabel);

        String[] catergoryItems = { null, "Food", "Coffe", "Drink", "Snack" };
        categoryProductField = new comboBox<>(catergoryItems, 180, 285, 300, 30, 10);
        categoryProductField.setPlaceholder("Select Category Product");

        buttonBack = new button("Back", 180, 470, 100, 40, 10);
        buttonReset = new button("Reset", 640, 470, 100, 40, 10);
        buttonSave = new button("Save", 780, 470, 100, 40, 10);

        scrollDescription = new scrollPane(descriptionProductField, 570, 180, 320, 220);
    }

    private void setColor() {
        contentPanel.setBackground(color.WHITE);

        scrollDescription.setBackground(color.WHITE);
        scrollDescription.getViewport().setOpaque(false);

        nameEmptyLabel.setForeground(color.RED);
        priceEmptyLabel.setForeground(color.RED);
        categoryEmptyLabel.setForeground(color.RED);
        descriptionEmptyLabel.setForeground(color.RED);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));

        nameProductLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        priceProductLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        categoryProductLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        imageProductLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        descriptionProductLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));

        nameEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        priceEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        categoryEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        descriptionEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        pathImageLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
    }

    private void handleButton() {
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showDashboardProduct();
            }
        });
    }

}
