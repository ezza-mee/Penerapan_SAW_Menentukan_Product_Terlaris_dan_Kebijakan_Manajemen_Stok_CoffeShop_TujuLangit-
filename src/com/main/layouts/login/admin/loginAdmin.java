package com.main.layouts.login.admin;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.containerPanel;
import com.main.layouts.popUp.popUpExit;
import com.main.services.authLogin;
import com.main.views.loginView;
import com.main.views.mainFrame;

public class loginAdmin extends containerPanel {

    private loginView parentView;
    private mainFrame parentFrame;

    private panelRounded wrapperPanel;
    private panelRounded cardPanel;
    private panelRounded shapeOne;
    private panelRounded shapeTwo;
    private panelRounded shapeThree;
    private panelRounded lineShape;

    private textLabel headerLabel;
    private textLabel usernameLabel;
    private textLabel passwordLabel;
    private textLabel warningUsernameLabel;
    private textLabel warningPasswordLabel;

    private textField usernameField;
    private passwordField passwordField;

    private button buttonLogin;

    // private linkLabel labelLink;

    private appIcons appIcons = new appIcons();

    private imageIcon exitIcon = appIcons.getExitIconWhite(30, 30);
    private imageIcon imageCoffeOne = appIcons.getCoffeOneIcon(80, 80);
    private imageIcon imageCoffeTwo = appIcons.getCoffeTwoIcon(80, 80);
    private imageIcon imageCoffeApp = appIcons.getCoffeAppIcon(300, 300);

    private imageIcon usernameIcon = appIcons.getUsernameIcon(25, 25);
    private imageIcon passwordIcon = appIcons.getPasswordIcon(25, 25);
    private imageIcon showPasswordIcon = appIcons.getShowPasswordIcon(25, 25);
    private imageIcon hidePasswordIcon = appIcons.getHidePasswordIcon(25, 25);

    public loginAdmin(loginView parentView, mainFrame parentFrame) {
        super();
        this.parentView = parentView;
        this.parentFrame = parentFrame;

        initsComponent();
    }

    private void refreshContent() {
        try {
            cardPanel.revalidate();
            cardPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsComponent() {
        setPostion();
        setColor();
        setFont();
        handelShowIconPassword();
        handleExitApps();
        handelLoginAdmin();
        // handelShowLoginStaff();

        add(exitIcon);
        add(imageCoffeOne);
        add(imageCoffeTwo);
        add(imageCoffeApp);
        add(wrapperPanel);

        cardPanel.add(usernameIcon);
        cardPanel.add(passwordIcon);
        cardPanel.add(showPasswordIcon);
        cardPanel.add(hidePasswordIcon);

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
        // cardPanel.add(labelLink);

    }

    private void setPostion() {
        wrapperPanel = new panelRounded(0, 0, 1080, 720, 0, 0);
        cardPanel = new panelRounded(90, 120, 450, 500, 0, 0);
        shapeOne = new panelRounded(700, -40, 380, 800, 400, 0);
        shapeTwo = new panelRounded(630, -40, 450, 800, 400, 0);
        shapeThree = new panelRounded(550, -40, 600, 800, 400, 0);
        lineShape = new panelRounded(165, 65, 120, 5, 3, 3);

        headerLabel = new textLabel("Sign In", 0, 10, 450, 60);
        usernameLabel = new textLabel("Username", 120, 130, 200, 40);
        passwordLabel = new textLabel("Password", 120, 230, 200, 40);
        warningUsernameLabel = new textLabel("Username is Empty!", 80, 210, 300, 10);
        warningPasswordLabel = new textLabel("Password is Empty!", 80, 310, 300, 10);
        // labelLink = new linkLabel("Login Staff", 198, 440, 80);

        usernameField = new textField(80, 170, 300, 10);
        usernameField.setPlaceholder("Enter your Username");
        passwordField = new passwordField(80, 270, 300, 10);
        passwordField.setPlaceholder("Enter your Password");

        buttonLogin = new button("Login", 85, 360, 300, 40, 15);

        exitIcon.setBounds(1005, 30, 30, 30);
        usernameIcon.setBounds(85, 135, 25, 25);
        passwordIcon.setBounds(85, 235, 25, 25);
        showPasswordIcon.setBounds(350, 273, 60, 60);
        hidePasswordIcon.setBounds(350, 273, 60, 60);
        imageCoffeApp.setBounds(700, 190, 300, 300);
        imageCoffeOne.setBounds(730, 380, 80, 80);
        imageCoffeTwo.setBounds(900, 350, 80, 80);
    }

    private void setColor() {
        cardPanel.setOpaque(false);
        shapeOne.setBackground(color.DARKGREEN);
        shapeTwo.setBackground(color.GREEN);
        shapeThree.setBackground(color.GREENLIGHT);
        setBackground(color.GREEN);
        lineShape.setBackground(color.DARKGREEN);

        headerLabel.setForeground(color.BLACK);
        usernameLabel.setForeground(color.BLACK);
        passwordLabel.setForeground(color.BLACK);
        warningUsernameLabel.setForeground(color.RED);
        warningPasswordLabel.setForeground(color.RED);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
        usernameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 16f));
        passwordLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 16f));
        warningUsernameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        warningPasswordLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 20f));

        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void handelShowIconPassword() {
        final boolean[] isPasswordVisible = { false };

        cardPanel.add(hidePasswordIcon);
        cardPanel.add(showPasswordIcon);

        hidePasswordIcon.setBounds(345, 273, 25, 25);
        showPasswordIcon.setBounds(345, 273, 25, 25);
        showPasswordIcon.setVisible(false);

        hidePasswordIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible[0] = true;
                passwordField.setEchoChar((char) 0);
                passwordField.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

                hidePasswordIcon.setVisible(false);
                showPasswordIcon.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hidePasswordIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        showPasswordIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible[0] = false;
                passwordField.setEchoChar('•');
                passwordField.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

                showPasswordIcon.setVisible(false);
                hidePasswordIcon.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                showPasswordIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    private void handleExitApps() {
        exitIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showGlassPanel(new popUpExit(parentFrame));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    // private void handelShowLoginStaff() {
    // labelLink.addMouseListener(new MouseAdapter() {
    // @Override
    // public void mouseClicked(MouseEvent e) {

    // }
    // });
    // }

    private void handelLoginAdmin() {
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String userName = usernameField.getText().trim();
                String password = String.valueOf(passwordField.getPassword()).trim();

                authLogin authService = new authLogin();
                String result = authService.validateLogin(userName, password);

                cardPanel.remove(warningUsernameLabel);
                cardPanel.remove(warningPasswordLabel);

                switch (result) {
                    case "USERNAME_PASSWORD_EMPTY":
                        cardPanel.add(warningUsernameLabel);
                        warningUsernameLabel.setText("Username required");
                        cardPanel.add(warningPasswordLabel);
                        warningPasswordLabel.setText("Password required");
                        break;
                    case "USERNAME_EMPTY":
                        cardPanel.add(warningUsernameLabel);
                        warningUsernameLabel.setText("Username required");
                        break;
                    case "PASSWORD_EMPTY":
                        cardPanel.add(warningPasswordLabel);
                        warningPasswordLabel.setText("Password required");
                        break;
                    case "USERNAME_PASSWORD_WRONG":
                        cardPanel.add(warningUsernameLabel);
                        warningUsernameLabel.setText("Username is incorrect");
                        cardPanel.add(warningPasswordLabel);
                        warningPasswordLabel.setText("Password is incorrect");
                        break;
                    case "USERNAME_WRONG":
                        cardPanel.add(warningUsernameLabel);
                        warningUsernameLabel.setText("Username is incorrect");
                        break;
                    case "PASSWORD_WRONG":
                        cardPanel.add(warningPasswordLabel);
                        warningPasswordLabel.setText("Password is incorrect");
                        break;
                    case "SUCCESS":
                        usernameField.setText(null);
                        passwordField.setText(null);
                        parentView.loginSuccess();
                        break;
                }

                refreshContent();
            }
        });
    }

}
