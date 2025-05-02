package com.main.layouts.login.admin;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.main.components.*;
import com.main.components.panelApps.containerPanel;
import com.main.layouts.popUp.popUpExit.popUpExit;
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

    private linkLabel labelLink;

    private URLImage imageIcon = new URLImage();

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
        setLocationComponent();
        setColorComponenet();
        setFontComponent();
        handelShowIconPassword();
        handleExitApps();
        handelLoginAdmin();
        handelShowLoginStaff();

        add(imageIcon.getExitIcon());
        add(imageIcon.getImageCoffeOne());
        add(imageIcon.getImageCoffeTwo());
        add(imageIcon.getImageCoffeApp());
        add(wrapperPanel);

        cardPanel.add(imageIcon.getUsernameIcon());
        cardPanel.add(imageIcon.getPasswordIcon());
        cardPanel.add(imageIcon.getShowPasswordIcon());
        cardPanel.add(imageIcon.getHidePasswordIcon());

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
        cardPanel.add(labelLink);

    }

    private void setLocationComponent() {
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
        labelLink = new linkLabel("Login Staff", 198, 440, 80);

        usernameField = new textField(80, 170, 300, 10);
        usernameField.setPlaceholder("Enter your Username");
        passwordField = new passwordField(80, 270, 300, 10);
        passwordField.setPlaceholder("Enter your Password");

        buttonLogin = new button("Login", 85, 360, 300, 40, 15);

        imageIcon.getUsernameIcon().setBounds(85, 135, 25, 25);
        imageIcon.getPasswordIcon().setBounds(85, 235, 25, 25);
        imageIcon.getShowPasswordIcon().setBounds(345, 273, 25, 25);
        imageIcon.getHidePasswordIcon().setBounds(345, 273, 25, 25);
        imageIcon.getExitIcon().setBounds(1005, 30, 40, 40);
        imageIcon.getImageCoffeApp().setBounds(700, 190, 300, 300);
        imageIcon.getImageCoffeOne().setBounds(730, 380, 80, 80);
        imageIcon.getImageCoffeTwo().setBounds(900, 350, 80, 80);
    }

    private void setColorComponenet() {
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

    private void setFontComponent() {
        headerLabel.setFont(fontSize.FONT_SIZE_30);
        usernameLabel.setFont(fontSize.FONT_SIZE_16);
        passwordLabel.setFont(fontSize.FONT_SIZE_16);
        warningUsernameLabel.setFont(fontSize.FONT_SIZE_10);
        warningPasswordLabel.setFont(fontSize.FONT_SIZE_10);

        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void handelShowIconPassword() {
        final boolean[] isPasswordVisible = { false };

        cardPanel.add(imageIcon.getHidePasswordIcon());
        cardPanel.add(imageIcon.getShowPasswordIcon());

        imageIcon.getHidePasswordIcon().setBounds(345, 273, 25, 25);
        imageIcon.getShowPasswordIcon().setBounds(345, 273, 25, 25);
        imageIcon.getShowPasswordIcon().setVisible(false);

        imageIcon.getHidePasswordIcon().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible[0] = true;
                passwordField.setEchoChar((char) 0);
                passwordField.setFont(fontSize.FONT_SIZE_12);

                imageIcon.getHidePasswordIcon().setVisible(false);
                imageIcon.getShowPasswordIcon().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageIcon.getHidePasswordIcon().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        imageIcon.getShowPasswordIcon().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible[0] = false;
                passwordField.setEchoChar('•');
                passwordField.setFont(fontSize.FONT_SIZE_13);

                imageIcon.getShowPasswordIcon().setVisible(false);
                imageIcon.getHidePasswordIcon().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageIcon.getShowPasswordIcon().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    private void handleExitApps() {
        imageIcon.getExitIcon().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showGlassPanel(new popUpExit(parentFrame));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageIcon.getExitIcon().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    private void handelShowLoginStaff() {
        labelLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    private void handelLoginAdmin() {
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String userName = usernameField.getText().trim();
                String password = String.valueOf(passwordField.getPassword()).trim();

                try {
                    cardPanel.remove(warningUsernameLabel);
                    cardPanel.remove(warningPasswordLabel);

                    boolean isEmpty = false;

                    if (userName.isEmpty()) {
                        cardPanel.add(warningUsernameLabel);
                        isEmpty = true;
                    }
                    if (password.isEmpty()) {
                        cardPanel.add(warningPasswordLabel);
                        isEmpty = true;
                    }

                    if (!isEmpty) {
                        cardPanel.remove(warningUsernameLabel);
                        cardPanel.remove(warningPasswordLabel);
                        if (userName.equals("admin") && password.equals("admin")) {
                            cardPanel.remove(warningUsernameLabel);
                            cardPanel.remove(warningPasswordLabel);
                            usernameField.setText(null);
                            passwordField.setText(null);
                            parentView.loginSuccess();
                        } else {
                            if (!userName.equals("admin")) {
                                warningUsernameLabel.setText("Username is Incorect");
                                cardPanel.add(warningUsernameLabel);
                            }
                            if (!password.equals("admin")) {
                                warningPasswordLabel.setText("Password is Incorect");
                                cardPanel.add(warningPasswordLabel);
                            }
                        }
                    }

                    refreshContent();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
