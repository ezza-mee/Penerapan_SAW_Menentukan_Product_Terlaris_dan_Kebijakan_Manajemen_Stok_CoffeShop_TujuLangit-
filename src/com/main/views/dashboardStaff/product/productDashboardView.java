package com.main.views.dashboardStaff.product;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.searchableView;
import com.main.models.entity.dataProduct;
import com.main.models.product.loadDataProduct;
import com.main.routes.dashboardStaffView;
import com.main.routes.mainFrame;
import com.main.services.authDataProduct;

public class productDashboardView extends contentPanel implements searchableView {

    private mainFrame parentApp;

    private dashboardStaffView parentView;

    private textLabel headerLabel;

    private panelRounded contentPanel;
    private panelRounded headerPanel;
    private scrollPane scrollPane;

    private linkLabel allLabel;
    private linkLabel foodLabel;
    private linkLabel coffeLabel;
    private linkLabel drinkLabel;

    private appIcons appIcon = new appIcons();
    private imageIcon iconDetail = appIcon.getDetailIconWhite(20, 20);

    public productDashboardView(mainFrame parentApp, dashboardStaffView parentView) {
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

        headerPanel.add(allLabel);
        headerPanel.add(foodLabel);
        headerPanel.add(coffeLabel);
        headerPanel.add(drinkLabel);

        add(headerLabel);
        add(headerPanel);
        add(scrollPane);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Product", 40, 0, 400, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 140, 1050, 410, 0, 0);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        scrollPane = new scrollPane(contentPanel, 0, 0, getWidth(), getHeight());
        scrollPane.setBounds(40, 220, 1050, 410);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        foodLabel = new linkLabel("Food", 150, 40, 80, 30);
        coffeLabel = new linkLabel("Coffe", 260, 40, 80, 30);
        drinkLabel = new linkLabel("Drink", 370, 40, 80, 30);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.DARKGREY);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
    }

    public void filterDataByKeyword(String keyword) {
        contentPanel.removeAll();

        ArrayList<dataProduct> list;

        if (keyword == null || keyword.trim().isEmpty()) {
            list = loadDataProduct.getAllProducts(); 
        } else {
            list = authDataProduct.searchProductByKeyword(keyword);
        }

        for (dataProduct product : list) {
            loadDataProductInCard(product);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void loadAllProductCards() {
        contentPanel.removeAll();

        ArrayList<dataProduct> list = loadDataProduct.getAllProducts();
        for (dataProduct product : list) {
            loadDataProductInCard(product);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void loadDataProductInCard(dataProduct product) {
        panelRounded cardPanel = new panelRounded();
        Dimension cardSize = new Dimension(1000, 100);
        cardPanel.setPreferredSize(cardSize);
        cardPanel.setMaximumSize(cardSize);
        cardPanel.setMinimumSize(cardSize);
        cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardPanel.setLayout(null);
        cardPanel.setBackground(color.WHITE);

        byte[] imageData = product.getImageData();
        ImageIcon icon = new ImageIcon(imageData);
        Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(20, 10, 80, 80);
        cardPanel.add(imageLabel);

        JLabel nameLabel = new JLabel(product.getNameProduct());
        nameLabel.setBounds(130, 10, 400, 25);
        nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 18f));
        cardPanel.add(nameLabel);

        JLabel priceLabel = new JLabel("Rp " + product.getPrice());
        priceLabel.setBounds(130, 40, 200, 20);
        cardPanel.add(priceLabel);

        JLabel descLabel = new JLabel(product.getDescription());
        descLabel.setBounds(130, 65, 600, 20);
        cardPanel.add(descLabel);

        buttonCustom buttonDetail = new buttonCustom("", 930, 35, 40, 40, 10);
        buttonDetail.setIcon(iconDetail);
        cardPanel.add(buttonDetail);

        // Padding antar card
        Component padding = Box.createRigidArea(new Dimension(0, 20));

        buttonDetail.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int idProduct = product.getIdProduct();
                System.out.println("idProduct : " + idProduct);
            }
        });

        contentPanel.add(padding);
        contentPanel.add(cardPanel, contentPanel.getComponentCount());

        contentPanel.revalidate();
        contentPanel.repaint();
    }

}
