package com.main.layouts.dasboardAdmin.staff;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.views.dashboardAdminView;

public class staffFormView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded contentPanel;

    private textLabel nameLabel, emailLabel, phoneLabel, jobdeskLabel, genderLabel, addresLabel;

    private textField nameField, emailField, phoneField;

    private textArea addresField;

    private scrollPane scrollAddres;

    private button buttonBack, buttonReset, buttonSave;

    public staffFormView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handelButton();

        contentPanel.add(nameLabel);
        contentPanel.add(emailLabel);
        contentPanel.add(phoneLabel);
        contentPanel.add(addresLabel);
        contentPanel.add(jobdeskLabel);
        contentPanel.add(genderLabel);

        contentPanel.add(nameField);
        contentPanel.add(emailField);
        contentPanel.add(phoneField);
        contentPanel.add(scrollAddres);

        contentPanel.add(buttonBack);
        contentPanel.add(buttonSave);
        contentPanel.add(buttonReset);

        add(contentPanel);
        add(headerLabel);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Input Data Staff", 40, 0, 400, 80);
        contentPanel = new panelRounded(40, 80, 1050, 550, 10, 10);

        nameLabel = new textLabel("Name", 180, 30, 200, 80);
        emailLabel = new textLabel("Email", 180, 130, 200, 80);
        phoneLabel = new textLabel("Phone Number", 180, 230, 200, 80);
        genderLabel = new textLabel("Gender", 180, 330, 200, 80);
        jobdeskLabel = new textLabel("Jobdesk", 580, 30, 200, 80);
        addresLabel = new textLabel("Address", 580, 130, 200, 80);

        nameField = new textField(180, 85, 300, 10);
        emailField = new textField(180, 185, 300, 10);
        phoneField = new textField(180, 285, 300, 10);
        addresField = new textArea(580, 185, 300, 220, 10);

        nameField.setPlaceholder("Enter your name");
        emailField.setPlaceholder("Enter your email");
        phoneField.setPlaceholder("Enter your phone number");
        addresField.setPlaceholder("Enter your address");

        scrollAddres = new scrollPane(addresField, 570, 180, 300, 220);

        buttonBack = new button("Back", 160, 470, 100, 40, 10);
        buttonReset = new button("Reset", 640, 470, 100, 40, 10);
        buttonSave = new button("Save", 770, 470, 100, 40, 10);

    }

    private void setColor() {
        contentPanel.setBackground(color.WHITE);

        nameLabel.setForeground(color.DARKGREEN);
        emailLabel.setForeground(color.DARKGREEN);
        phoneLabel.setForeground(color.DARKGREEN);
        genderLabel.setForeground(color.DARKGREEN);
        jobdeskLabel.setForeground(color.DARKGREEN);
        addresLabel.setForeground(color.DARKGREEN);

        scrollAddres.setBackground(color.WHITE);
        scrollAddres.getViewport().setOpaque(false);
        ;
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BLACK, 30f));

        nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        emailLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        phoneLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        genderLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        jobdeskLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        addresLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
    }

    private void handelButton() {
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showDashboardStaff();
            }
        });
    }
}
