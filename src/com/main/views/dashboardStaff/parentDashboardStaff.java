package com.main.views.dashboardStaff;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.main.components.*;
import com.main.components.panelApps.*;
import com.main.routes.dashboardStaffView;
import com.main.auth.utils.Role;

public class parentDashboardStaff extends containerPanel {

    private int mouseX, mouseY;

    private dashboardStaffView parentView;
    private Role role;

    private headerPanel headerPanel = new headerPanel();
    private navigationPanel navigationPanel = new navigationPanel();
    private contentContainer contentContainer = new contentContainer();
    private textLabel copyRight = new textLabel("CopyRight. 2025 TujuLangit Forestpark", 0, 728, 1366, 40);

    private navigationDashboardView navBar;
    private headerDashboardView contentHeader;

    private contentPanel currentContent;

    public void setContent(contentPanel content) {
        contentContainer.removeAll();
        contentContainer.add(content);
        content.add(copyRight);

        this.currentContent = content;

        contentContainer.revalidate();
        contentContainer.repaint();
    }

    public parentDashboardStaff(dashboardStaffView parentView, Role role) {
        super();
        this.parentView = parentView;
        this.role = role;
        this.navBar = new navigationDashboardView(this.parentView, this.role);
        this.contentHeader = new headerDashboardView(this);

        setLayout(null);
        setSize(1366, 768);
        initLayout();
    }

    private void initLayout() {
        setLayout();
        setColor();
        setFont();
        setAction();

        headerPanel.add(contentHeader);
        navigationPanel.add(navBar);

        add(headerPanel);
        add(navigationPanel);
        add(contentContainer);
    }

    private void setLayout() {
        navigationPanel.setBounds(0, 80, 240, 688);
        contentContainer.setBounds(240, 80, 1126, 698);
    }

    private void setColor() {
        navigationPanel.setBackground(color.GREEN);
        copyRight.setForeground(color.DARKGREEN);

    }

    private void setFont() {
        copyRight.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        copyRight.setHorizontalAlignment(JLabel.CENTER);
    }

    private void setAction() {
        headerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getXOnScreen();
                mouseY = e.getYOnScreen();
            }
        });

        headerPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(parentDashboardStaff.this);
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                int dx = x - mouseX;
                int dy = y - mouseY;
                window.setLocation(window.getX() + dx, window.getY() + dy);
                mouseX = x;
                mouseY = y;
            }
        });

    }

    public navigationDashboardView getNavbar() {
        return navBar;
    }

    public contentPanel getCurrentContent() {
        return currentContent;
    }
}
