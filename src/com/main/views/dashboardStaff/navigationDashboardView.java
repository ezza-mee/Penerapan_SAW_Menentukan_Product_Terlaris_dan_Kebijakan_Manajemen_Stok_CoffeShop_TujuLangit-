package com.main.views.dashboardStaff;

import javax.swing.JLabel;

import com.main.auth.utils.Role;
import com.main.auth.sessionLogin;
import com.main.auth.sessionManager;
import com.main.components.*;
import com.main.components.panelApps.navigationPanel;
import com.main.routes.dashboardStaffView;

public class navigationDashboardView extends navigationPanel {

    private dashboardStaffView contentView;

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

    private navigation navTable = new navigation(
            appIcons.getTableIconDefault(30, 30),
            appIcons.getTableIconHover(30, 30),
            "Table",
            150 + 50 + 50

    );

    private navigation navTransaction = new navigation(
            appIcons.getTransactionIconDefault(30, 30),
            appIcons.getTransactionIconHover(30, 30),
            "Transaction",
            150 + 50 + 50 + 50

    );

    private navigation navHistoryTransaction = new navigation(
            appIcons.getHistoryTransactionIconDefault(30, 30),
            appIcons.getHistoryTransactionIconHover(30, 30),
            "History",
            150 + 50 + 50 + 50 + 50

    );

    private navigation navLogout = new navigation(
            appIcons.getLogoutIconDefault(30, 30),
            appIcons.getLogoutIconHover(30, 30),
            "Logout",
            150 + 50 + 50 + 50 + 50 + 50

    );

    private void resetNavigation() {
        navHome.setForeground(color.WHITE);
        navHome.setBackground(color.DARKGREEN);
        navHome.setNavigationInAktif();

        navProduct.setForeground(color.WHITE);
        navProduct.setBackground(color.DARKGREEN);
        navProduct.setNavigationInAktif();

        navTable.setForeground(color.WHITE);
        navTable.setBackground(color.DARKGREEN);
        navTable.setNavigationInAktif();

        navTransaction.setForeground(color.WHITE);
        navTransaction.setBackground(color.DARKGREEN);
        navTransaction.setNavigationInAktif();

        navHistoryTransaction.setForeground(color.WHITE);
        navHistoryTransaction.setBackground(color.DARKGREEN);
        navHistoryTransaction.setNavigationInAktif();

        navLogout.setForeground(color.WHITE);
        navLogout.setBackground(color.DARKGREEN);
        navLogout.setNavigationInAktif();

    }

    public navigationDashboardView(dashboardStaffView contentView, Role role) {
        super();
        this.contentView = contentView;
        handelNavigation();
        setFont();
        setColor();

        add(brandLabel);

        System.out.println("Role NAV : " + role);
        if (role == Role.CASHIER) {
            add(navHome);
            add(navProduct);
            add(navTable);
            add(navTransaction);
            add(navHistoryTransaction);
            add(navLogout);
        } else if (role == Role.SUPPLIER) {
            add(navHome);
            navLogout.setBounds(0, 150 + 50 + 50, 240, 50);
            add(navLogout);
        }

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

        navTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showTableView();
            }
        });

        navTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showTransactionView();
            }
        });

        navHistoryTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showHistoryTransactionView();
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

        contentView.showDashboardProduct();

        setVisible(true);
    }

    public void showTableView() {
        resetNavigation();

        navTable.setForeground(color.DARKGREEN);
        navTable.setBackground(color.WHITE);
        navTable.setNavigationAktif();

        contentView.showDashboardTable();

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

    public void showHistoryTransactionView() {
        resetNavigation();

        navHistoryTransaction.setForeground(color.DARKGREEN);
        navHistoryTransaction.setBackground(color.WHITE);
        navHistoryTransaction.setNavigationAktif();

        contentView.showDashboardHistoryTransaction();

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
