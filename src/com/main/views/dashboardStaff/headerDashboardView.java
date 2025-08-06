package com.main.views.dashboardStaff;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.main.components.panelApps.contentPanel;
import com.main.components.panelApps.headerPanel;
import com.main.controller.searchableView;
import com.main.auth.sessionLogin;
import com.main.auth.sessionManager;
import com.main.components.*;

public class headerDashboardView extends headerPanel {

    private parentDashboardStaff parentDashboard;

    private textLabel welcomeLabel;

    private textField searchField;

    private String nameStaff;

    public headerDashboardView(parentDashboardStaff parentDashboard) {
        super();
        this.parentDashboard = parentDashboard;

        // ✅ Hindari error jika session belum di-set
        if (sessionManager.getStaffData() != null) {
            nameStaff = sessionManager.getStaffData().getName();
        } else {
            nameStaff = "User";
            System.err.println("⚠️ sessionManager.getStaffData() null saat inisialisasi headerDashboardView");
        }
        initContent();
    }

    private void initContent() {
        setPosition();
        setColor();
        setFont();

        add(searchField);
        add(welcomeLabel);

        setVisible(true);
    }

    private void setPosition() {
        welcomeLabel = new textLabel("Welcome" + "  , " + nameStaff, 40, 0, 400, 80);

        searchField = new textField(600, 25, 400, 10);
        searchField.setPlaceholder("Search");

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = searchField.getText();

                contentPanel current = parentDashboard.getCurrentContent();
                if (current instanceof searchableView) {
                    ((searchableView) current).filterDataByKeyword(keyword);
                }
            }
        });

    }

    private void setColor() {
        setBackground(color.WHITE);
        welcomeLabel.setForeground(color.DARKGREEN);
    }

    private void setFont() {
        welcomeLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
    }

    public textField getSearchField() {
        return searchField;
    }

}