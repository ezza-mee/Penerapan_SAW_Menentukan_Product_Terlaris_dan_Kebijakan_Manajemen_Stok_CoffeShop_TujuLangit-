package com.main.layouts.popUp;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;

public class popUpFailed extends popUpPanel {

    private appIcons appIcons = new appIcons();
    private imageIcon failedIcon = appIcons.getFailedIconRed(60, 60);
    private textLabel headerLabel, messageLabel;

    private button buttonConfirm;

    public popUpFailed() {
        super();
        setSize(550, 240);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();

        add(failedIcon);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(headerLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(messageLabel);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(buttonConfirm);

        setVisible(true);
    }

    private void setPosition() {
        failedIcon.setBounds(0, 30, 600, 60);
        headerLabel = new textLabel("Failed", 0, 110, 600, 80);
        messageLabel = new textLabel("Data Failed to Save", 0, 135, 600, 80);

        buttonConfirm = new button("OK", 0, 200, 200, 40, 10);

    }

    private void setColor() {

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        messageLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.REGULAR, 15f));

        failedIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}
