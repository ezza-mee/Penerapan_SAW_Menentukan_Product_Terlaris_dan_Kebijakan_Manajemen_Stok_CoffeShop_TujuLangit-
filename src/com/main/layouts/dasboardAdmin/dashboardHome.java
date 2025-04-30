package com.main.layouts.dasboardAdmin;

import com.main.components.panelRounded;
import com.main.components.panelApps.*;

public class dashboardHome extends contentPanel {

    private panelRounded panelProduct;
    private panelRounded panelStaff;
    private panelRounded panelSupplier;
    private panelRounded panelTransaction;
    private panelRounded panelDiagramTransaction;

    public dashboardHome() {
        super();
        initsComponentHome();
    }

    private void initsComponentHome() {
        setPosition();

        add(panelProduct);
        add(panelStaff);
        add(panelSupplier);
        add(panelTransaction);
        add(panelDiagramTransaction);

        setVisible(true);
    }

    public void setPosition() {
        panelProduct = new panelRounded(40, 40, 230, 150, 10, 10);
        panelStaff = new panelRounded(310, 40, 230, 150, 10, 10);
        panelSupplier = new panelRounded(580, 40, 230, 150, 10, 10);
        panelTransaction = new panelRounded(850, 40, 230, 150, 10, 10);
        panelDiagramTransaction = new panelRounded(40, 230, 1040, 400, 10, 10);
    }

}
