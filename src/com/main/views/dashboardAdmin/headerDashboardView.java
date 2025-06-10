package com.main.views.dashboardAdmin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.main.components.panelApps.contentPanel;
import com.main.components.panelApps.headerPanel;
import com.main.controller.searchableView;
import com.main.components.*;

public class headerDashboardView extends headerPanel {

    private parentDashboardAdmin parentDashboard;

    private panelRounded brandPanel;

    private textLabel welcomeLabel;

    private textField searchField;

    public headerDashboardView(parentDashboardAdmin parentDashboard) {
        super();
        this.parentDashboard = parentDashboard;
        initContent();
    }

    private void initContent() {
        setPosition();
        setColor();
        setFont();

        add(brandPanel);
        add(searchField);
        add(welcomeLabel);

        setVisible(true);
    }

    private void setPosition() {
        brandPanel = new panelRounded(0, 0, 240, 80, 0, 0);
        welcomeLabel = new textLabel("Welcome", 300, 0, 100, 80);

        searchField = new textField(500, 25, 400, 10);
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
        brandPanel.setBackground(color.DARKGREEN);
        welcomeLabel.setForeground(color.DARKGREEN);
    }

    private void setFont() {
        welcomeLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
    }

    public textField getSearchField() {
        return searchField;
    }

}
