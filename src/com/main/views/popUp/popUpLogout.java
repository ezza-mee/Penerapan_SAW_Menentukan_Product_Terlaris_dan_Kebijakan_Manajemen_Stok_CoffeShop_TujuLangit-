package com.main.views.popUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.main.auth.utils.Role;
import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;

public class popUpLogout extends popUpPanel {
    private mainFrame parentFrame;
    private dashboardAdminView dashboardAdminView;

    private textLabel confrimLabel;
    private textLabel logoutLabel;

    private buttonCustom buttonCancel;
    private buttonCustom buttonLogout;

    private appIcons appIcons = new appIcons();
    private imageIcon logoutIcon = appIcons.getLogoutIconRed(40, 40);

    public popUpLogout(mainFrame parentFrame, Role role) {
        super();
        this.parentFrame = parentFrame;
        dashboardAdminView = new dashboardAdminView(parentFrame, role);
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();
        handleLogoutApps();

        add(logoutIcon);
        add(logoutLabel);
        add(confrimLabel);

        add(buttonCancel);
        add(buttonLogout);

        setVisible(true);
    }

    private void setPosition() {
        logoutLabel = new textLabel("<html><body><h2><b>Logout Apps</b></h2></body></html>", 0, 35, 300, 100);
        confrimLabel = new textLabel(
                "<html><body style='text-align: center;'>Are your sure you want to Logout the application?</body></html>",
                0, 70, 300, 100);
        buttonCancel = new buttonCustom("Cancel", 40, 150, 100, 30, 10);
        buttonLogout = new buttonCustom("Logout", 160, 150, 100, 30, 10);

        logoutIcon.setBounds(130, 30, 40, 40);
    }

    private void setColor() {
        buttonCancel.setOriginalBackground(color.LIGHTGREY);
        buttonCancel.setHoverBackground(color.DARKGREY);
        buttonCancel.setPressedBackground(color.LIGHTGREY);
        buttonCancel.setBackground(color.LIGHTGREY);

        buttonLogout.setOriginalBackground(color.RED);
        buttonLogout.setHoverBackground(color.DARKRED);
        buttonLogout.setPressedBackground(color.RED);
        buttonLogout.setBackground(color.RED);

        buttonCancel.setForeground(color.BLACK);
    }

    private void setFont() {
        logoutLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 16f));
        confrimLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

        logoutLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void handleLogoutApps() {
        buttonLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showLoginApp();
                parentFrame.hideGlassPanel();
                dashboardAdminView.resetLastContent();
            }
        });

        buttonCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.hideGlassPanel();
            }
        });
    }
}
