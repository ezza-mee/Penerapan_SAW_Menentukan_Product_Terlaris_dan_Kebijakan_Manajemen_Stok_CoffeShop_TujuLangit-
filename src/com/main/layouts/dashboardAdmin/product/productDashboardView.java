package com.main.layouts.dashboardAdmin.product;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.dataProduct.getterDataProduct;
import com.main.models.dataProduct.loadDataProduct;
import com.main.services.authDataProduct;
import com.main.views.dashboardAdminView;

public class productDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded contentProduct;
    private panelRounded headerContent;
    private scrollPane scrollPane;

    private buttonCustom buttonAdd;

    private linkLabel allLabel;
    private linkLabel foodLabel;
    private linkLabel coffeLabel;
    private linkLabel drinkLabel;

    private appIcons appIcon = new appIcons();
    private imageIcon iconDelete = appIcon.getDeleteIconWhite(20, 20);
    private imageIcon iconEdit = appIcon.getEditIconWhite(20, 20);
    private imageIcon iconDetail = appIcon.getDetailIconWhite(20, 20);

    public productDashboardView(dashboardAdminView parentView) {
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
        headerLabel = new textLabel("Data Product", 40, 0, 400, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentProduct = new panelRounded(40, 140, 1050, 410, 0, 0);
        contentProduct.setLayout(new BoxLayout(contentProduct, BoxLayout.Y_AXIS));

        scrollPane = new scrollPane(contentProduct, 0, 0, getWidth(), getHeight());
        scrollPane.setBounds(40, 220, 1050, 410);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

        allLabel = new linkLabel("ALL", 40, 40, 80, 30);
        foodLabel = new linkLabel("Food", 150, 40, 80, 30);
        coffeLabel = new linkLabel("Coffe", 260, 40, 80, 30);
        drinkLabel = new linkLabel("Drink", 370, 40, 80, 30);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerContent.setBackground(color.WHITE);
        contentProduct.setBackground(color.DARKGREY);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
    }

    private void handleAddCard() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormProduct();
            }
        });
    }

    public void loadAllProductCards() {
        contentProduct.removeAll();

        ArrayList<getterDataProduct> list = loadDataProduct.getAllProducts();
        for (getterDataProduct product : list) {
            loadDataProductInCard(product);
        }

        contentProduct.revalidate();
        contentProduct.repaint();
    }

    private void loadDataProductInCard(getterDataProduct product) {
        panelRounded cardPanel = new panelRounded();
        Dimension cardSize = new Dimension(1000, 100);
        cardPanel.setPreferredSize(cardSize);
        cardPanel.setMaximumSize(cardSize);
        cardPanel.setMinimumSize(cardSize);
        cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardPanel.setLayout(null);
        cardPanel.setBackground(color.WHITE);

        // Tampilkan gambar produk
        byte[] imageData = product.getImageData();
        ImageIcon icon = new ImageIcon(imageData);
        Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(20, 10, 80, 80);
        cardPanel.add(imageLabel);

        // Nama produk
        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setBounds(130, 10, 400, 25);
        nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 18f));
        cardPanel.add(nameLabel);

        // Harga produk
        JLabel priceLabel = new JLabel("Rp " + product.getPrice());
        priceLabel.setBounds(130, 40, 200, 20);
        cardPanel.add(priceLabel);

        // Deskripsi produk
        JLabel descLabel = new JLabel(product.getDescription());
        descLabel.setBounds(130, 65, 600, 20);
        cardPanel.add(descLabel);

        // Tombol Hapus
        buttonCustom buttonEdit = new buttonCustom("", 810, 35, 40, 40, 10);
        buttonCustom buttonDelete = new buttonCustom("", 870, 35, 40, 40, 10);
        buttonCustom buttonDetail = new buttonCustom("", 930, 35, 40, 40, 10);

        buttonDelete.setIcon(iconDelete);
        buttonEdit.setIcon(iconEdit);
        buttonDetail.setIcon(iconDetail);

        cardPanel.add(buttonEdit);
        cardPanel.add(buttonDelete);
        cardPanel.add(buttonDetail);

        // Padding antar card
        Component padding = Box.createRigidArea(new Dimension(0, 20));

        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int idProduct = product.getIdProduct();
                boolean success = authDataProduct.deleteDataProduct(idProduct);

                if (success) {
                    parentView.showSuccessPopUp("Success Delete Data Product");
                    contentProduct.remove(cardPanel);
                    contentProduct.remove(padding);
                    contentProduct.revalidate();
                    contentProduct.repaint();
                } else {
                    parentView.showFailedPopUp("Product Delete Data Product");
                }
            }
        });

        contentProduct.add(padding);
        contentProduct.add(cardPanel, contentProduct.getComponentCount());

        contentProduct.revalidate();
        contentProduct.repaint();

        javax.swing.SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }

}
