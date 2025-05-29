package com.main.layouts.dashboardAdmin;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.navigationPanel;
import com.main.views.dashboardAdminView;

public class navigationDashboardView extends navigationPanel {

    private dashboardAdminView contentView;

    private appIcons appIcons = new appIcons();

    private textLabel brandLabel = new textLabel(
            "<html><body><div><b>TujuLangit</b></div> Forestpark</body></html>", 0, 0, 240, 100

    );

    private navigation navHome = new navigation(
            appIcons.getHomeIconDefault(30, 30),
            appIcons.getHomeIconHover(30, 30),
            "Home",
            150

    );

    private navigation navProduct = new navigation(
            appIcons.getProductIconDefault(30, 30),
            appIcons.getProductIconHover(30, 30),
            "Product",
            150 + 50

    );

    private navigation navSupplier = new navigation(
            appIcons.getSupplierIconDefault(30, 30),
            appIcons.getSupplierIconHover(30, 30),
            "Supplier",
            150 + 50 + 50

    );

    private navigation navTransaction = new navigation(
            appIcons.getTransactionIconDefault(30, 30),
            appIcons.getTransactionIconHover(30, 30),
            "Transaction",
            150 + 50 + 50 + 50

    );

    private navigation navStaff = new navigation(
            appIcons.getStaffIconDefault(30, 30),
            appIcons.getStaffIconHover(30, 30),
            "Staff",
            150 + 50 + 50 + 50 + 50

    );

    private navigation navReport = new navigation(
            appIcons.getReportIconDefault(30, 30),
            appIcons.getReportIconHover(30, 30),
            "Report",
            150 + 50 + 50 + 50 + 50 + 50

    );

    private navigation navLogout = new navigation(
            appIcons.getLogoutIconDefault(30, 30),
            appIcons.getLogoutIconHover(30, 30),
            "Logout",
            150 + 50 + 50 + 50 + 50 + 50 + 50

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

        navReport.setForeground(color.WHITE);
        navReport.setBackground(color.DARKGREEN);
        navReport.setNavigationInAktif();

        navLogout.setForeground(color.WHITE);
        navLogout.setBackground(color.DARKGREEN);
        navLogout.setNavigationInAktif();

    }

    public navigationDashboardView(dashboardAdminView contentView) {
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
        add(navReport);
        add(navLogout);
    }

    private void setColor() {
        brandLabel.setForeground(color.WHITE);
    }

    private void setFont() {
        brandLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BLACK, 20f));
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

        navReport.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showReportView();
            }
        });

        navLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showLogoutView();
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

        contentView.showFormCompositionProduct();

        setVisible(true);
    }

    public void showSupplierView() {
        resetNavigation();

        navSupplier.setForeground(color.DARKGREEN);
        navSupplier.setBackground(color.WHITE);
        navSupplier.setNavigationAktif();

        contentView.showFormSupplier();

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

    public void showReportView() {
        resetNavigation();

        navReport.setForeground(color.DARKGREEN);
        navReport.setBackground(color.WHITE);
        navReport.setNavigationAktif();

        contentView.showDashboardReport();

        setVisible(true);
    }

    public void showLogoutView() {
        resetNavigation();

        navLogout.setForeground(color.DARKGREEN);
        navLogout.setBackground(color.WHITE);
        navLogout.setNavigationAktif();

        contentView.showLogoutApp();

        setVisible(true);
    }
}
