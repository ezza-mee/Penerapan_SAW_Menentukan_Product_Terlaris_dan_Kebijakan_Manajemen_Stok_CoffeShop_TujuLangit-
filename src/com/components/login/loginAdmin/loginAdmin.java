package com.components.login.loginAdmin;

import java.awt.Color;

import javax.swing.JLabel;

import com.main.resources.templates.panelContentApp.containerPanel;
import com.partials.*;

public class loginAdmin extends containerPanel {

    private panelRounded wrapperPanel;
    private panelRounded cardPanel;
    private panelRounded shapeOne;
    private panelRounded shapeTwo;
    private panelRounded shapeThree;
    private panelRounded lineShape;

    private textLabel headerLabel;
    private textLabel usernameLabel;
    private textLabel passwordLabel;
    private textLabel incorrectUsernameLabel;
    private textLabel incorrectPasswordLabel;
    private textLabel emptyUsernameLabel;
    private textLabel emptyPasswordLabel;

    private textField usernameField;
    private passwordField passwordField;

    private button buttonLogin;

    public loginAdmin() {
        super();
        initsComponentLoginAdminView();
    }

    public void initsComponentLoginAdminView() {
        wrapperPanel = new panelRounded(0, 0, 1080, 720, 0, 0);
        cardPanel = new panelRounded(100, 120, 450, 500, 0, 0);
        shapeOne = new panelRounded(700, -40, 380, 800, 400, 0);
        shapeTwo = new panelRounded(630, -40, 450, 800, 400, 0);
        shapeThree = new panelRounded(550, -40, 600, 800, 400, 0);
        lineShape = new panelRounded(165, 65, 120, 5, 3, 3);

        headerLabel = new textLabel("Sign In", 0, 10, 450, 60);
        usernameLabel = new textLabel("Username", 120, 130, 200, 40);
        passwordLabel = new textLabel("Password", 120, 230, 200, 40);

        usernameField = new textField(80, 170, 300, 10);
        passwordField = new passwordField(80, 270, 300, 10);

        buttonLogin = new button("Login", 85, 360, 300, 40, 15);

        wrapperPanel.add(cardPanel);
        wrapperPanel.add(shapeOne);
        wrapperPanel.add(shapeTwo);
        wrapperPanel.add(shapeThree);

        cardPanel.add(headerLabel);
        cardPanel.add(lineShape);
        cardPanel.add(usernameLabel);
        cardPanel.add(passwordLabel);
        cardPanel.add(usernameField);
        cardPanel.add(passwordField);
        cardPanel.add(buttonLogin);

        containerPanel.add(wrapperPanel);

        setColorComponenet();
        setFontComponent();

        setVisible(true);
    }

    private void setColorComponenet() {
        cardPanel.setBackground(color.DARKGREEN);
        shapeOne.setBackground(color.DARKGREEN);
        shapeTwo.setBackground(color.GREEN);
        shapeThree.setBackground(color.GREENLIGHT);
        containerPanel.setBackground(Color.GREEN);

        headerLabel.setForeground(color.BLACK);
        usernameLabel.setForeground(color.BLACK);
        passwordLabel.setForeground(color.BLACK);
    }

    private void setFontComponent() {
        headerLabel.setFont(fontSize.FONT_SIZE_30);
        usernameLabel.setFont(fontSize.FONT_SIZE_16);
        passwordLabel.setFont(fontSize.FONT_SIZE_16);

        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

}
