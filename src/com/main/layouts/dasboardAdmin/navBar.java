package com.main.layouts.dasboardAdmin;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.navigationPanel;
import com.main.views.dashboardAdminView;

public class navBar extends navigationPanel {

    private dashboardAdminView contentView;

    private URLImage iconNavigation = new URLImage();

    private textLabel brandLabel = new textLabel(
            "<html><body><div><b>TujuLangit</b></div> Forestpark</body></html>", 0, 0, 240, 100

    );

    private navigation navHome = new navigation(
            iconNavigation.getIconHomeWhite(),
            iconNavigation.getIconHomeGreen(),
            "Home",
            150

    );

    private navigation navProduct = new navigation(
            iconNavigation.getIconProductWhite(),
            iconNavigation.getIconProductGreen(),
            "Data Product",
            150 + 50

    );

    private void resetNavigation() {
        navHome.setForeground(color.WHITE);
        navHome.setBackground(color.DARKGREEN);
        navHome.setNavigationInAktif();

        navProduct.setForeground(color.WHITE);
        navProduct.setBackground(color.DARKGREEN);
        navProduct.setNavigationInAktif();

    }

    public navBar(dashboardAdminView contentView) {
        super();
        this.contentView = contentView;
        handelNavigation();
        setFont();
        setColor();

        add(brandLabel);
        add(navHome);
        add(navProduct);
    }

    private void setColor() {
        brandLabel.setForeground(color.WHITE);
    }

    private void setFont() {
        brandLabel.setFont(fontSize.FONT_SIZE_16);
        brandLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void handelNavigation() {

        navHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showHomeView();
            }
        });

        navProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showProductView();
            }
        });

    }

    public void showHomeView() {
        resetNavigation();

        navHome.setForeground(color.DARKGREEN);
        navHome.setBackground(color.WHITE);
        navHome.setNavigationAktif();

        contentView.showHomeDashboard();

        setVisible(true);
    }

    public void showProductView() {
        resetNavigation();

        navProduct.setForeground(color.DARKGREEN);
        navProduct.setBackground(color.WHITE);
        navProduct.setNavigationAktif();

        contentView.showHomeProduct();

        setVisible(true);
    }
}
