package com.main.views;

import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.layouts.dasboardAdmin.dashboardHome;
import com.main.layouts.dasboardAdmin.parentDashboard;
import com.main.layouts.dasboardAdmin.dashboardReport.dashboardReport;
import com.main.layouts.dasboardAdmin.product.dashboardProduct;
import com.main.layouts.dasboardAdmin.staff.dashboardStaff;
import com.main.layouts.dasboardAdmin.supplier.dashboardSupplier;
import com.main.layouts.dasboardAdmin.transaction.dashboardTransaction;

public class dashboardAdminView extends containerPanel {

    private parentDashboard parentDashboard;

    public dashboardAdminView() {
        super();
        setSize(1366, 768);
        setBackground(color.GREEN);
        parentDashboard = new parentDashboard(this);
        add(parentDashboard);

        parentDashboard.getNavbar().showHomeView();
    }

    public void showDashboardHome() {
        dashboardHome home = new dashboardHome();
        parentDashboard.setContent(home);
    }

    public void showDashboardProduct() {
        dashboardProduct dashboardProduct = new dashboardProduct();
        parentDashboard.setContent(dashboardProduct);
    }

    public void showDashboardSupplier() {
        dashboardSupplier dashboardSupplier = new dashboardSupplier();
        parentDashboard.setContent(dashboardSupplier);
    }

    public void showDashboardTransaction() {
        dashboardTransaction dashboardTransaction = new dashboardTransaction();
        parentDashboard.setContent(dashboardTransaction);
    }

    public void showDashboardStaff() {
        dashboardStaff dashboardStaff = new dashboardStaff();
        parentDashboard.setContent(dashboardStaff);
    }

    public void showDashboardReport() {
        dashboardReport dashboardReport = new dashboardReport();
        parentDashboard.setContent(dashboardReport);
    }

}
