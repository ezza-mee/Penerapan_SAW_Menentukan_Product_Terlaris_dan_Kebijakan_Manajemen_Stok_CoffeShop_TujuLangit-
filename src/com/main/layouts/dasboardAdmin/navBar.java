package com.main.layouts.dasboardAdmin;

import javax.swing.JLabel;
import java.awt.Font;

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
            "Product",
            150 + 50

    );

    private navigation navSupplier = new navigation(
            iconNavigation.getIconSupplierWhite(),
            iconNavigation.getIconSupplierGreen(),
            "Supplier",
            150 + 50 + 50

    );

    private navigation navTransaction = new navigation(
            iconNavigation.getIconTransactionWhite(),
            iconNavigation.getIconTransactionGreen(),
            "Transaction",
            150 + 50 + 50 + 50

    );

    private navigation navStaff = new navigation(
            iconNavigation.getIconStaffWhite(),
            iconNavigation.getIconStaffGreen(),
            "Staff",
            150 + 50 + 50 + 50 + 50

    );

    private void resetNavigation() {
        navHome.setForeground(color.WHITE);
        navHome.setBackground(color.DARKGREEN);
        navHome.setNavigationInAktif();

        navProduct.setForeground(color.WHITE);
        navProduct.setBackground(color.DARKGREEN);
        navProduct.setNavigationInAktif();

        navSupplier.setForeground(color.WHITE);
        navSupplier.setBackground(color.DARKGREEN);
        navSupplier.setNavigationInAktif();

        navTransaction.setForeground(color.WHITE);
        navTransaction.setBackground(color.DARKGREEN);
        navTransaction.setNavigationInAktif();

        navStaff.setForeground(color.WHITE);
        navStaff.setBackground(color.DARKGREEN);
        navStaff.setNavigationInAktif();

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
        add(navSupplier);
        add(navTransaction);
        add(navStaff);
    }

    private void setColor() {
        brandLabel.setForeground(color.WHITE);
    }

    private void setFont() {
        Font boldFont = fontSize.FONT_SIZE_16.deriveFont(Font.BOLD, 18f);
        brandLabel.setFont(boldFont);
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

        navSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showSupplierView();
            }
        });

        navTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showTransactionView();
            }
        });

        navStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showStaffView();
            }
        });

    }

    public void showHomeView() {
        resetNavigation();

        navHome.setForeground(color.DARKGREEN);
        navHome.setBackground(color.WHITE);
        navHome.setNavigationAktif();

        contentView.showDashboardHome();

        setVisible(true);
    }

    public void showProductView() {
        resetNavigation();

        navProduct.setForeground(color.DARKGREEN);
        navProduct.setBackground(color.WHITE);
        navProduct.setNavigationAktif();

        contentView.showDashboardProduct();

        setVisible(true);
    }

    public void showSupplierView() {
        resetNavigation();

        navSupplier.setForeground(color.DARKGREEN);
        navSupplier.setBackground(color.WHITE);
        navSupplier.setNavigationAktif();

        contentView.showDashboardSupplier();

        setVisible(true);
    }

    public void showTransactionView() {
        resetNavigation();

        navTransaction.setForeground(color.DARKGREEN);
        navTransaction.setBackground(color.WHITE);
        navTransaction.setNavigationAktif();

        contentView.showDashboardTransaction();

        setVisible(true);
    }

    public void showStaffView() {
        resetNavigation();

        navStaff.setForeground(color.DARKGREEN);
        navStaff.setBackground(color.WHITE);
        navStaff.setNavigationAktif();

        contentView.showDashboardStaff();

        setVisible(true);
    }
}
