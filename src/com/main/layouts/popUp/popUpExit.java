package com.main.layouts.popUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.views.mainFrame;

public class popUpExit extends popUpPanel {

    private mainFrame parentFrame;

    private textLabel exitLabel;
    private textLabel confrimLabel;

    private buttonCustom buttonCancel;
    private buttonCustom buttonExit;

    private appIcons appIcons = new appIcons();
    private imageIcon exitIcon = appIcons.getLogoutIconRed(40, 40);

    public popUpExit(mainFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setFont();
        setColor();
        handleExitApps();

        add(exitIcon);
        add(exitLabel);
        add(confrimLabel);

        add(buttonCancel);
        add(buttonExit);

        setVisible(true);
    }

    private void setPosition() {
        exitLabel = new textLabel("<html><body><h2><b>Exit Apps</b></h2></body></html>", 0, 35, 300, 100);
        confrimLabel = new textLabel(
                "<html><body style='text-align: center;'>Are your sure you want to exit the application?</body></html>",
                0, 70, 300, 100);
        buttonCancel = new buttonCustom("Cancel", 40, 150, 100, 30, 10);
        buttonExit = new buttonCustom("Exit", 160, 150, 100, 30, 10);

        exitIcon.setBounds(130, 30, 40, 40);
    }

    private void setColor() {
        buttonCancel.setOriginalBackground(color.LIGHTGREY);
        buttonCancel.setHoverBackground(color.DARKGREY);
        buttonCancel.setPressedBackground(color.LIGHTGREY);
        buttonCancel.setBackground(color.LIGHTGREY);

        buttonExit.setOriginalBackground(color.RED);
        buttonExit.setHoverBackground(color.DARKRED);
        buttonExit.setPressedBackground(color.RED);
        buttonExit.setBackground(color.RED);

        buttonCancel.setForeground(color.BLACK);
    }

    private void setFont() {
        exitLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 16f));
        confrimLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

        exitLabel.setHorizontalAlignment(JLabel.CENTER);

    }

    private void handleExitApps() {
        buttonExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
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
