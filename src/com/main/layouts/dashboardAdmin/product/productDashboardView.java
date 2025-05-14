package com.main.layouts.dashboardAdmin.product;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;

import java.awt.Component;
import java.awt.Dimension;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;

public class productDashboardView extends contentPanel {

    private textLabel headerLabel;

    private panelRounded contentProduct;
    private panelRounded headerContent;
    private scrollPane scrollPane;

    private button buttonAdd;

    private linkLabel allLabel;
    private linkLabel foodLabel;
    private linkLabel coffeLabel;
    private linkLabel drinkLabel;

    public productDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handleAddCard();

        headerContent.add(allLabel);
        headerContent.add(foodLabel);
        headerContent.add(coffeLabel);
        headerContent.add(drinkLabel);
        headerContent.add(buttonAdd);

        add(headerLabel);
        add(headerContent);
        add(scrollPane);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Product", 40, 0, 200, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentProduct = new panelRounded(40, 140, 1050, 410, 0, 0);
        contentProduct.setLayout(new BoxLayout(contentProduct, BoxLayout.Y_AXIS));

        scrollPane = new scrollPane(contentProduct, 0, 0, getWidth(), getHeight());
        scrollPane.setBounds(40, 220, 1050, 410);

        buttonAdd = new button("Add", 900, 35, 100, 40, 10);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        foodLabel = new linkLabel("Food", 150, 40, 80, 30);
        coffeLabel = new linkLabel("Coffe", 260, 40, 80, 30);
        drinkLabel = new linkLabel("Drink", 370, 40, 80, 30);

    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);
        headerContent.setBackground(color.WHITE);
        contentProduct.setBackground(color.DARKGREY);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));
    }

    private void handleAddCard() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                panelRounded cardPanel = new panelRounded();
                Dimension cardSize = new Dimension(1000, 100);
                cardPanel.setPreferredSize(cardSize);
                cardPanel.setMaximumSize(cardSize);
                cardPanel.setMinimumSize(cardSize);
                cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

                cardPanel.setBackground(color.WHITE);
                cardPanel.setLayout(null);

                button buttonDelete = new button("Delete", 880, 40, 100, 30, 10);
                cardPanel.add(buttonDelete);

                Component padding = Box.createRigidArea(new Dimension(0, 20));

                buttonDelete.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        contentProduct.remove(cardPanel);
                        contentProduct.remove(padding);
                        contentProduct.revalidate();
                        contentProduct.repaint();
                    }
                });

                contentProduct.add(padding);
                contentProduct.add(cardPanel, contentProduct.getComponentCount());
                cardPanel.add(Box.createVerticalGlue());

                contentProduct.revalidate();
                contentProduct.repaint();

                javax.swing.SwingUtilities.invokeLater(() -> {
                    JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
                    verticalBar.setValue(verticalBar.getMaximum());
                });
            }
        });
    }
}
