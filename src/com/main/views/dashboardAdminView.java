package com.main.views;

import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.components.panelApps.contentPanel;
import com.main.layouts.dasboardAdmin.homeDashboardView;
import com.main.layouts.dasboardAdmin.parentDashboardView;
import com.main.layouts.dasboardAdmin.Report.reportDashboardView;
import com.main.layouts.dasboardAdmin.product.productDashboardView;
import com.main.layouts.dasboardAdmin.staff.staffDashboardView;
import com.main.layouts.dasboardAdmin.staff.staffFormView;
import com.main.layouts.dasboardAdmin.supplier.supplierDashboardView;
import com.main.layouts.dasboardAdmin.transaction.transactionDashboardView;
import com.main.layouts.popUp.popUpLogout;

public class dashboardAdminView extends containerPanel {

    private parentDashboardView parentDashboard;
    private mainFrame parentFrame;
    private contentPanel lastContent;

    public dashboardAdminView(mainFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        setSize(1366, 768);
        setBackground(color.GREEN);
        parentDashboard = new parentDashboardView(this);
        add(parentDashboard);

        parentDashboard.getNavbar().showHomeView();
        // parentDashboard.getNavbar().showStaffView();
    }

    public void showDashboardHome() {
        homeDashboardView dashboardHome = new homeDashboardView();
        lastContent = dashboardHome;
        parentDashboard.setContent(dashboardHome);
    }

    public void showDashboardProduct() {
        productDashboardView dashboardProduct = new productDashboardView();
        lastContent = dashboardProduct;
        parentDashboard.setContent(dashboardProduct);
    }

    public void showDashboardSupplier() {
        supplierDashboardView dashboardSupplier = new supplierDashboardView();
        lastContent = dashboardSupplier;
        parentDashboard.setContent(dashboardSupplier);
    }

    public void showDashboardTransaction() {
        transactionDashboardView dashboardTransaction = new transactionDashboardView();
        lastContent = dashboardTransaction;
        parentDashboard.setContent(dashboardTransaction);
    }

    public void showDashboardStaff() {
        staffDashboardView dashboardStaff = new staffDashboardView(this);
        lastContent = dashboardStaff;
        parentDashboard.setContent(dashboardStaff);
    }

    public void showDashboardReport() {
        reportDashboardView dashboardReport = new reportDashboardView();
        lastContent = dashboardReport;
        parentDashboard.setContent(dashboardReport);
    }

    public void showFormStaff() {
        staffFormView formStaff = new staffFormView(this);
        lastContent = formStaff;
        parentDashboard.setContent(formStaff);
    }

    public void showLogoutApp() {
        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(new popUpLogout(parentFrame));
    }

    public contentPanel restoreLastContent() {
        return lastContent != null ? lastContent : new homeDashboardView();
    }

    public void resetLastContent() {
        parentDashboard.getNavbar().showHomeView();
        lastContent = null;
    }

}
