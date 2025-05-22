package com.main.layouts.popUp.popUpStaff;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.main.components.*;
import com.main.components.panelApps.popUpPanel;
import com.main.services.authDataStaff;
import com.main.views.mainFrame;
import com.main.views.dashboardAdminView;

public class popUpFormInputAccountStaff extends popUpPanel {

    private mainFrame parentFrame;

    private dashboardAdminView parentView;

    private textLabel headerLabel, emailLabel, passwordLabel, confirmPasswordLabel;

    private textLabel emailEmptyLabel, passwordEmptyLabel, confirmPasswordEmptyLabel;

    private textField emailField;

    private passwordField passwordField, confirmPasswordField;

    private buttonCustom buttonSave, buttonCancel;

    private authDataStaff insertStaff = new authDataStaff();

    private boolean isEditMode;
    private int idStaff;
    private String name, email, phone, gender, jobdesk, address;

    public popUpFormInputAccountStaff(mainFrame parentFrame, dashboardAdminView parentView,
            String name,
            String email,
            String phone,
            String gender,
            String jobdesk,
            String address) {
        super();
        this.parentFrame = parentFrame;
        this.parentView = parentView;
        // this.isEditMode = isEdit;
        // this.idStaff = idStaff;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.jobdesk = jobdesk;
        this.address = address;
        setSize(500, 500);
        initComponent();
    }

    private void initComponent() {
        setPosition();
        setColor();
        setFont();
        handleButtonApps();

        add(headerLabel);
        add(emailLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);

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

        buttonCancel = new buttonCustom("Cancel", 70, 410, 150, 40, 10);
        buttonSave = new buttonCustom("Save", 270, 410, 150, 40, 10);

        this.emailField.setText(email);
        emailField.setEditable(false);

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

    private void handleButtonApps() {

        buttonCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.hideGlassPanel();
            }
        });

        buttonSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String emailAccount = emailField.getText().trim();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                String validationResult = insertStaff.validateAccountInput(emailAccount, password, confirmPassword);

                remove(emailEmptyLabel);
                remove(passwordEmptyLabel);
                remove(confirmPasswordEmptyLabel);

                switch (validationResult) {
                    case "ACCOUNT_EMAIL_PASSWORD_EMPTY":
                        add(emailEmptyLabel);
                        add(passwordEmptyLabel);
                        break;
                    case "ACCOUNT_EMAIL_EMPTY":
                        add(emailEmptyLabel);
                        break;
                    case "ACCOUNT_PASSWORD_EMPTY":
                        add(passwordEmptyLabel);
                        break;
                    case "CONFIRM_PASSWORD_EMPTY":
                        add(confirmPasswordEmptyLabel);
                        break;
                    case "PASSWORD_MISMATCH":
                        add(confirmPasswordEmptyLabel);
                        confirmPasswordEmptyLabel.setText("Password and Confirm Password do not match");
                        break;
                }

                if (confirmPassword.isEmpty()) {
                    add(confirmPasswordEmptyLabel);
                }

                if (!validationResult.equals("VALID") || confirmPassword.isEmpty()) {
                    revalidate();
                    repaint();
                    return;
                }

                boolean insertSuccess = authDataStaff.insertStaffWithAccount(
                        name, email, phone, gender, jobdesk, address,
                        emailAccount, password);

                if (insertSuccess) {
                    parentFrame.hideGlassPanel();
                    parentView.showDashboardStaff();
                    parentView.showSuccessPopUp("Data and Account Staff Successfully Saved");
                } else {
                    parentFrame.hideGlassPanel();
                    parentView.showFailedPopUp("Failed to Save Data and Account Staff");
                }

                revalidate();
                repaint();
            }
        });

    }

}
