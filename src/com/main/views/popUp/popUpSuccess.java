package com.main.views.popUp;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.routes.mainFrame;

public class popUpSuccess extends popUpPanel {

    private mainFrame parentApp;

    private appIcons appIcons = new appIcons();
    private imageIcon successIcon = appIcons.getSuccessIconGreen(60, 60);
    private textLabel headerLabel, messageLabel;

    private buttonCustom buttonConfirm;

    public popUpSuccess(mainFrame parentApp) {
        super();
        this.parentApp = parentApp;
        setSize(550, 240);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();
        handleButton();

        add(successIcon);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(headerLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(messageLabel);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(buttonConfirm);

        setVisible(true);
    }

    private void setPosition() {
        successIcon.setBounds(0, 30, 600, 60);
        headerLabel = new textLabel("Success", 0, 110, 600, 80);
        messageLabel = new textLabel("Data Successfully Saved", 0, 135, 600, 80);

        buttonConfirm = new buttonCustom("OK", 0, 200, 200, 40, 10);
    }

    private void setColor() {

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        messageLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.REGULAR, 15f));

        successIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void handleButton() {
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentApp.hideGlassPanel();
            }
        });
    }

    public void setNotificationMessage(String message) {
        messageLabel.setText(message);
        messageLabel.revalidate();
        messageLabel.repaint();
    }
}
