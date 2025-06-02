package com.main.layouts.dashboardAdmin;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.*;
import com.main.views.dashboardAdminView;

public class parentDashboardView extends containerPanel {

    private dashboardAdminView parentView;

    private contentPanel currentContent;

    private headerPanel headerPanel = new headerPanel();
    private headerDashboardView contentHeader;
    private navigationPanel navigationPanel = new navigationPanel();
    private contentContainer contentContainer = new contentContainer();

    private navigationDashboardView navBar;

    private textLabel copyRight;

    public void setContent(contentPanel content) {
        contentContainer.removeAll();
        contentContainer.add(content);
        content.add(copyRight);

        this.currentContent = content;

        contentContainer.revalidate();
        contentContainer.repaint();
    }

    public parentDashboardView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        this.navBar = new navigationDashboardView(this.parentView);
        this.contentHeader = new headerDashboardView(this);
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
        copyRight.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        copyRight.setHorizontalAlignment(JLabel.CENTER);
    }

    public navigationDashboardView getNavbar() {
        return navBar;
    }

    public contentPanel getCurrentContent() {
        return currentContent;
    }

}
