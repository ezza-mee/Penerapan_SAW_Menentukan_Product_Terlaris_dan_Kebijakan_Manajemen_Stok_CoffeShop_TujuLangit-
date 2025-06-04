package com.main.views.dashboardStaff.historyTransaction;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.routes.dashboardStaffView;

public class historyTransactionDashboarView extends contentPanel {

    private dashboardStaffView parentView;

    private textLabel headerLabel;
    private panelRounded contentTransaction;

    public historyTransactionDashboarView(dashboardStaffView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentTransaction);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Transaction", 40, 0, 300, 80);
        contentTransaction = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);

        contentTransaction.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));
    }

}
