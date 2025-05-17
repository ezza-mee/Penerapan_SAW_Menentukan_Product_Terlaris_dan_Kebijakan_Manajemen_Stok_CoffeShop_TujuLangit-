package com.main.layouts.popUp;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;

public class popUpFormInputAccountStaff extends popUpPanel {

    private textLabel headerLabel, emailLabel, passwordLabel, confirmPasswordLabel;

    private textLabel emailEmptyLabel, passwordEmptyLabel, confirmPasswordEmptyLabel;

    private textField emailField;

    private passwordField passwordField, confirmPasswordField;

    private button buttonSave, buttonCancel;

    public popUpFormInputAccountStaff() {
        super();
        setSize(500, 500);
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(emailLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);

        add(emailEmptyLabel);
        add(passwordEmptyLabel);
        add(confirmPasswordEmptyLabel);

        add(emailField);
        add(passwordField);
        add(confirmPasswordField);

        add(buttonSave);
        add(buttonCancel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Input Account Staff", 0, 30, 500, 50);

        emailLabel = new textLabel("Email", 70, 100, 300, 40);
        passwordLabel = new textLabel("Password", 70, 190, 300, 40);
        confirmPasswordLabel = new textLabel("Confirm Password", 70, 280, 300, 40);

        emailEmptyLabel = new textLabel("Email is Empty", 70, 155, 300, 40);
        passwordEmptyLabel = new textLabel("Password is Empty", 70, 245, 300, 40);
        confirmPasswordEmptyLabel = new textLabel("Confirm Password is Empty", 70, 335, 300, 40);

        emailField = new textField(70, 135, 350, 10);
        passwordField = new passwordField(70, 225, 350, 10);
        confirmPasswordField = new passwordField(70, 315, 350, 10);

        buttonCancel = new button("Cancel", 70, 410, 150, 40, 10);
        buttonSave = new button("Save", 270, 410, 150, 40, 10);

    }

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        emailLabel.setForeground(color.BLACK);
        passwordLabel.setForeground(color.BLACK);
        confirmPasswordLabel.setForeground(color.BLACK);

        emailEmptyLabel.setForeground(color.RED);
        passwordEmptyLabel.setForeground(color.RED);
        confirmPasswordEmptyLabel.setForeground(color.RED);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        emailLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
        passwordLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
        confirmPasswordLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));

        emailEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));  
        passwordEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));   
        confirmPasswordEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));

    }

}
