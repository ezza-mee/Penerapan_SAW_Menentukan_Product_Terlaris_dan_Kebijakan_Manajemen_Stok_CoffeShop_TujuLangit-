package com.main.routes;

import java.util.List;

import com.main.auth.utils.Role;
import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.components.panelApps.contentPanel;
import com.main.models.entity.listTransactionProduct;
import com.main.views.dashboardStaff.homeDashboardView;
import com.main.views.dashboardStaff.parentDashboardStaff;
import com.main.views.dashboardStaff.historyTransaction.historyTransactionDashboardView;
import com.main.views.dashboardStaff.product.productDashboardView;
import com.main.views.dashboardStaff.table.tableDashboardView;
import com.main.views.dashboardStaff.transaction.transactionDashboardView;
import com.main.views.dashboardStaff.transaction.transactionFormView;
import com.main.views.popUp.popUpConfrim;
import com.main.views.popUp.popUpFailed;
import com.main.views.popUp.popUpLogout;
import com.main.views.popUp.popUpSuccess;
import com.main.views.popUp.popUpEditStatusTable.popUpEditStatusTable;
import com.main.views.popUp.popUpTransaction.popUpTransaction;

public class dashboardStaffView extends containerPanel {
    private Role role;

    private parentDashboardStaff parentDashboard;
    private mainFrame parentApp;
    private contentPanel lastContent;

    public dashboardStaffView(mainFrame parentApp, Role role) {
        super();
        this.parentApp = parentApp;
        this.role = role;
        setSize(1366, 768);
        setBackground(color.GREEN);
        parentDashboard = new parentDashboardStaff(this, role);
        add(parentDashboard);

        parentDashboard.getNavbar().showHomeView();
    }

    public void showDashboardHome() {
        homeDashboardView dashboardHome = new homeDashboardView(this, role);
        lastContent = dashboardHome;
        parentDashboard.setContent(dashboardHome);
    }

    public void showDashboardProduct() {
        productDashboardView dashboardProduct = new productDashboardView(this);
        dashboardProduct.loadAllProductCards();
        lastContent = dashboardProduct;
        parentDashboard.setContent(dashboardProduct);
    }

    public void showDashboardTable() {
        tableDashboardView dashboardTable = new tableDashboardView(parentApp, this);
        lastContent = dashboardTable;
        parentDashboard.setContent(dashboardTable);
    }

    public void showDashboardTransaction() {
        transactionDashboardView dashboardTransaction = new transactionDashboardView(parentApp, this);
        lastContent = dashboardTransaction;
        parentDashboard.setContent(dashboardTransaction);
    }

    public void showFormTransaction() {
        transactionFormView formTransaction = new transactionFormView(this);
        formTransaction.loadAllProductCards();
        lastContent = formTransaction;
        parentDashboard.setContent(formTransaction);
    }

    public void showDashboardHistoryTransaction() {
        historyTransactionDashboardView historyTransaction = new historyTransactionDashboardView();
        lastContent = historyTransaction;
        parentDashboard.setContent(historyTransaction);
    }

    public void showSuccessPopUp(String message) {
        popUpSuccess popUp = new popUpSuccess(parentApp);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentApp.showNotificationPopUp(popUp);
    }

    public void showFailedPopUp(String message) {
        popUpFailed popUp = new popUpFailed(parentApp);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentApp.showNotificationPopUp(popUp);
    }

    public popUpConfrim showConfrimPopUp(String message) {
        popUpConfrim popUp = new popUpConfrim(parentApp);
        popUp.setNotificationMessage(message);
        parentApp.showNotificationPopUp(popUp);
        parentDashboard.setContent(restoreLastContent());
        return popUp;
    }

    public void showPopUpTransaction(List<listTransactionProduct> listProduct, int subQuantity, int priceProduct,
            int subPrice) {
        popUpTransaction popUp = new popUpTransaction(parentApp, this, listProduct, subQuantity, priceProduct,
                subPrice);
        parentApp.showFormPopUp(popUp);
        parentDashboard.setContent(restoreLastContent());
    }

    public void showPopUpEditStatusTable(int idTable) {
        popUpEditStatusTable popUp = new popUpEditStatusTable(parentApp, this, idTable);
        parentApp.showFormPopUp(popUp);
        parentDashboard.setContent(restoreLastContent());
    }

    public void showLogoutApp() {
        parentDashboard.setContent(restoreLastContent());
        parentApp.showNotificationPopUp(new popUpLogout(parentApp, role));
    }

    public contentPanel restoreLastContent() {
        return lastContent != null ? lastContent : new homeDashboardView(this, role);
    }

    public void resetLastContent() {
        parentDashboard.getNavbar().showHomeView();
        lastContent = null;
    }
}
