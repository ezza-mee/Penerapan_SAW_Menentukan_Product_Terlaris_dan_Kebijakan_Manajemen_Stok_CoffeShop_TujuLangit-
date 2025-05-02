package com.main.layouts.popUp.popUpExit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.views.mainFrame;

public class popUpExit extends popUpPanel {

    private textLabel confirmLabel;
    private textLabel exitAppLabel;

    private button buttonCancel;
    private button buttonExit;

    private URLImage imageIcon = new URLImage();

    private mainFrame parentFrame;

    public popUpExit(mainFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        initComponent();
    }

    private void initComponent() {
        setPositionComponent();
        setFontComponent();
        setColorComponent();
        handleExitApps();

        add(exitAppLabel);
        add(confirmLabel);

        add(buttonCancel);
        add(buttonExit);

        add(imageIcon.getIconExit());

        setVisible(true);
    }

    private void setPositionComponent() {
        exitAppLabel = new textLabel("<html><body><h2><b>Exit Apps</b></h2></body></html>", 0, 35, 300, 100);
        confirmLabel = new textLabel(
                "<html><body style='text-align: center;'>Are your sure you want to exit the application?</body></html>",
                0, 70, 300, 100);
        buttonCancel = new button("Cancel", 40, 150, 100, 30, 10);
        buttonExit = new button("Exit", 160, 150, 100, 30, 10);

        imageIcon.getIconExit().setBounds(130, 30, 40, 40);
    }

    private void setColorComponent() {
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

    private void setFontComponent() {
        exitAppLabel.setFont(fontSize.FONT_SIZE_16);
        confirmLabel.setFont(fontSize.FONT_SIZE_13);

        exitAppLabel.setHorizontalAlignment(JLabel.CENTER);

    }

    public void handleExitApps() {
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
