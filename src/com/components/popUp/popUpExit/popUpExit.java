package com.components.popUp.popUpExit;

import javax.swing.JLabel;

import com.main.resources.templates.panelContentApp.popUpPanel;
import com.partials.*;

public class popUpExit extends popUpPanel {

    private textLabel confirmLabel;
    private textLabel exitAppLabel;

    private button buttonCancel;
    private button buttonExit;

    private URLImage imageIcon = new URLImage();

    public popUpExit() {
        super();
        initsComponentPopUpExit();
    }

    private void initsComponentPopUpExit() {
        setPositionComponent();
        setFontComponent();

        popUpPanel.add(exitAppLabel);
        popUpPanel.add(confirmLabel);

        popUpPanel.add(buttonCancel);
        popUpPanel.add(buttonExit);

        popUpPanel.add(imageIcon.getIconExit());

        setVisible(true);
    }

    private void setPositionComponent() {
        exitAppLabel = new textLabel("Exit Apps", 0, 35, 300, 100);
        confirmLabel = new textLabel(
                "<html><body style='text-align: center;'>Are your sure you want to exit the application?</body></html>",
                0, 70, 300, 100);
        buttonCancel = new button("Cancel", 40, 150, 100, 30, 10);
        buttonExit = new button("Exit", 160, 150, 100, 30, 10);

        imageIcon.getIconExit().setBounds(130, 30, 40, 40);
    }

    private void setColorComponent() {

    }

    private void setFontComponent() {
        exitAppLabel.setFont(fontSize.FONT_SIZE_16);
        confirmLabel.setFont(fontSize.FONT_SIZE_13);

        exitAppLabel.setHorizontalAlignment(JLabel.CENTER);

    }

}
