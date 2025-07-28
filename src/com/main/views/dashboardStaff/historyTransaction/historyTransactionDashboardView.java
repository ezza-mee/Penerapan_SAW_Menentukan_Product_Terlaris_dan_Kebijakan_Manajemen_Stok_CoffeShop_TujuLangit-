package com.main.views.dashboardStaff.historyTransaction;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.models.transaction.loadDataTransaction;

public class historyTransactionDashboardView extends contentPanel {

    private textLabel headerLabel;
    private panelRounded headerPanel, contentPanel;

    private tableNoActionButton dataTransaction;
    private scrollTable scrollDataTransaction;

    public historyTransactionDashboardView() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setLayout();
        setColor();
        setFont();

        contentPanel.add(scrollDataTransaction);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setLayout() {
        headerLabel = new textLabel("History Data Transaction", 40, 0, 600, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        dataTransaction = new tableNoActionButton(loadDataTransaction.getAllDataTransactionDoneByStaff());
        scrollDataTransaction = new scrollTable(dataTransaction, 0, 0, 1050, 410);

        dataTransaction.getColumnModel().getColumn(1).setMinWidth(0);
        dataTransaction.getColumnModel().getColumn(1).setMaxWidth(0);
        dataTransaction.getColumnModel().getColumn(1).setWidth(0);
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
