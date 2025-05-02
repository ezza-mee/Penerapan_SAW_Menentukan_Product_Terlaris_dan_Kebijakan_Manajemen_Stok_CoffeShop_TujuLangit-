package com.main.layouts.dasboardAdmin;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.*;
import com.main.views.dashboardAdminView;

public class parentDashboard extends containerPanel {

    private dashboardAdminView parentView;

    private headerPanel headerPanel = new headerPanel();
    private headerDashboard contentHeader = new headerDashboard();
    private navigationPanel navigationPanel = new navigationPanel();
    private contentContainer contentContainer = new contentContainer();

    private navBar navBar;

    private textLabel copyRight;

    public void setContent(contentPanel content) {
        contentContainer.removeAll();
        contentContainer.add(content);
        content.add(copyRight);
        contentContainer.revalidate();
        contentContainer.repaint();
    }

    public parentDashboard(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        this.navBar = new navBar(this.parentView);
        setSize(1366, 768);
        initsLayoutParent();

    }

    private void initsLayoutParent() {
        setPosition();
        setColor();
        setFont();

        headerPanel.add(contentHeader);

        navigationPanel.add(navBar);

        add(headerPanel);
        add(navigationPanel);
        add(contentContainer);

    }

    private void setPosition() {
        contentContainer.setBounds(240, 80, 1126, 698);
        headerPanel.setBounds(240, 0, 1126, 80);

        copyRight = new textLabel("CopyRight. 2025 TujuLangit Forestpark", 0, 640, 1126, 40);
    }

    private void setColor() {
        navigationPanel.setBackground(color.GREEN);

        copyRight.setForeground(color.DARKGREEN);
    }

    private void setFont() {
        copyRight.setFont(fontSize.FONT_SIZE_12);
        copyRight.setHorizontalAlignment(JLabel.CENTER);
    }

    public navBar getNavbar() {
        return navBar;
    }

}
