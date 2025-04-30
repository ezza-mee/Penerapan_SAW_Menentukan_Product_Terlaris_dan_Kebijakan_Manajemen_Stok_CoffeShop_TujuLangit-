package com.main.views;

import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.layouts.dasboardAdmin.dashboardHome;
import com.main.layouts.dasboardAdmin.parentDashboard;
import com.main.layouts.dasboardAdmin.product.dashboardProduct;

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

    public void showHomeDashboard() {
        dashboardHome home = new dashboardHome();
        parentDashboard.setContent(home);
    }

    public void showHomeProduct() {
        dashboardProduct dashboardProduct = new dashboardProduct();
        parentDashboard.setContent(dashboardProduct);
    }

}
