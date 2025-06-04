package com.main.views.dashboardStaff.transaction;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import java.awt.Image;
import java.awt.Component;
import java.awt.Dimension;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.entity.dataProduct;
import com.main.models.product.loadDataProduct;
import com.main.routes.dashboardStaffView;
import com.main.routes.mainFrame;
import com.main.controller.searchableView;
import com.main.services.authDataProduct;
import com.main.views.popUp.popUpConfrim;

public class transactionDashboardView extends contentPanel {

    private dashboardStaffView parentView;

    private textLabel headerLabel;

    private panelRounded headerPanel, contentPanel;

    private buttonCustom buttonAdd;

    public transactionDashboardView(dashboardStaffView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPostion();
        setColor();
        setFont();

        headerPanel.add(buttonAdd);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPostion() {
        headerLabel = new textLabel("Data Transaction", 40, 0, 400, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);
       

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));
    }

   

}
