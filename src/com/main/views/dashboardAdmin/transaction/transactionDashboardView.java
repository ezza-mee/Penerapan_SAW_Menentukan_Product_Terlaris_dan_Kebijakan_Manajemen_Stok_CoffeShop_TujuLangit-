package com.main.views.dashboardAdmin.transaction;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.transaction.loadDataTransaction;

public class transactionDashboardView extends contentPanel {

    private textLabel headerLabel;
    private panelRounded headerPanel, contentPanel;

    private tableNoActionButton dataTransaction;
    private scrollTable scrollDataTransaction;

    public transactionDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        contentPanel.add(scrollDataTransaction);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Transaction", 40, 0, 300, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        dataTransaction = new tableNoActionButton(loadDataTransaction.getAllDataTransactionDone());
        scrollDataTransaction = new scrollTable(dataTransaction, 0, 0, 1050, 410);
    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);

        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
    }

}
