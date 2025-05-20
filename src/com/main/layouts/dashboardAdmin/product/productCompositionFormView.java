package com.main.layouts.dashboardAdmin.product;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;

import java.awt.Component;
import java.awt.Dimension;

import com.main.components.panelApps.contentPanel;
import com.main.views.dashboardAdminView;

import com.main.components.*;

public class productCompositionFormView extends contentPanel {

    private dashboardAdminView parentView;

    private panelRounded contentPanel, listIngredientPanel, parentListIngredientPanel;

    private textLabel headerLabel, nameIngredientLabel, amountIngredientLabel, unitIngredientLabel, listIngredientLabel;

    private textField nameIngredientField, amountIngredientField;

    private comboBox<String> unitIngredientField;

    private buttonCustom buttonBack, buttonReset, buttonAdd, buttonSave;

    private scrollPane scrollPane;

    public productCompositionFormView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handleAddCard();
        handleButton();

        contentPanel.add(nameIngredientLabel);
        contentPanel.add(amountIngredientLabel);
        contentPanel.add(unitIngredientLabel);

        contentPanel.add(nameIngredientField);
        contentPanel.add(amountIngredientField);
        contentPanel.add(unitIngredientField);

        contentPanel.add(buttonBack);
        contentPanel.add(buttonReset);
        contentPanel.add(buttonAdd);

        listIngredientPanel.add(listIngredientLabel);
        listIngredientPanel.add(scrollPane);
        listIngredientPanel.add(buttonSave);

        add(headerLabel);
        add(contentPanel);
        add(listIngredientPanel);

        setVisible(true);
    }

    private void setPosition() {
        contentPanel = new panelRounded(40, 80, 600, 550, 10, 10);
        listIngredientPanel = new panelRounded(685, 80, 400, 550, 10, 10);
        parentListIngredientPanel = new panelRounded(0, 80, 400, 360, 0, 0);
        parentListIngredientPanel.setLayout(new BoxLayout(parentListIngredientPanel, BoxLayout.Y_AXIS));

        scrollPane = new scrollPane(parentListIngredientPanel, 0, 0, getWidth(), getHeight());
        scrollPane.setBounds(0, 80, 410, 360);

        headerLabel = new textLabel("Input Product Ingredient Composition", 40, 0, 600, 80);
        listIngredientLabel = new textLabel("List Ingredient", 40, 30, 300, 80);
        nameIngredientLabel = new textLabel("Name Ingredient", 100, 30, 300, 80);
        amountIngredientLabel = new textLabel("Amount Ingredient", 100, 130, 300, 80);
        unitIngredientLabel = new textLabel("unit Ingredient", 100, 230, 300, 80);

        nameIngredientField = new textField(100, 85, 400, 10);
        amountIngredientField = new textField(100, 185, 400, 10);

        String[] unitItems = { null, "Gram", "Kilogram", "Ons", "Mililiter", "Liter",
                "Sendok Makan", "Sendok Teh", "Gelas", "Botol",
                "Kaleng", "Buah", "Kemasan", "Sachet", "Lembaran",
                "Batangan", "Biji-bijian", "Cangkir", "Irisan", "Kotak", "Kemasan", "Tetesan" };
        unitIngredientField = new comboBox<>(unitItems, 100, 290, 400, 30, 10);
        unitIngredientField.setPlaceholder("Select Unit Ingredient");

        buttonSave = new buttonCustom("Save", 25, 470, 350, 40, 10);
        buttonBack = new buttonCustom("Back", 50, 470, 100, 40, 10);
        buttonReset = new buttonCustom("Reset", 310, 470, 100, 40, 10);
        buttonAdd = new buttonCustom("Add", 440, 470, 100, 40, 10);

    }

    private void setColor() {
        listIngredientPanel.setBackground(color.WHITE);
        parentListIngredientPanel.setBackground(color.WHITE);
        scrollPane.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));

        listIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        nameIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        amountIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        unitIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
    }

    private void handleAddCard() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                panelRounded cardPanel = new panelRounded();
                Dimension cardSize = new Dimension(350, 100);
                cardPanel.setPreferredSize(cardSize);
                cardPanel.setMaximumSize(cardSize);
                cardPanel.setMinimumSize(cardSize);
                cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

                cardPanel.setBackground(color.WHITE);
                cardPanel.setLayout(null);

                buttonCustom buttonDelete = new buttonCustom("Delete", 220, 40, 100, 30, 10);
                cardPanel.add(buttonDelete);

                Component padding = Box.createRigidArea(new Dimension(0, 20));

                buttonDelete.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        parentListIngredientPanel.remove(cardPanel);
                        parentListIngredientPanel.remove(padding);
                        parentListIngredientPanel.revalidate();
                        parentListIngredientPanel.repaint();
                    }
                });

                parentListIngredientPanel.add(padding);
                parentListIngredientPanel.add(cardPanel, parentListIngredientPanel.getComponentCount());
                cardPanel.add(Box.createVerticalGlue());

                parentListIngredientPanel.revalidate();
                parentListIngredientPanel.repaint();

                javax.swing.SwingUtilities.invokeLater(() -> {
                    JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
                    verticalBar.setValue(verticalBar.getMaximum());
                });
            }
        });
    }

    private void handleButton() {
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormProduct();
            }
        });
    }

}
