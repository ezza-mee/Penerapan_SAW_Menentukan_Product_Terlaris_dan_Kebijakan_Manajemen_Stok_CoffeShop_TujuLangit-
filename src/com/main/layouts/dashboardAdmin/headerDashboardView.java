package com.main.layouts.dashboardAdmin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.main.components.panelApps.contentPanel;
import com.main.components.panelApps.headerPanel;
import com.main.controller.searchableView;
import com.main.components.*;

public class headerDashboardView extends headerPanel {

    private parentDashboardView parentDashboard;

    private textLabel welcomeLabel;

    private textField searchField;

    public headerDashboardView(parentDashboardView parentDashboard) {
        super();
        this.parentDashboard = parentDashboard;
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
        welcomeLabel = new textLabel("Welcome", 40, 0, 100, 80);

        searchField = new textField(400, 25, 400, 10);
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
