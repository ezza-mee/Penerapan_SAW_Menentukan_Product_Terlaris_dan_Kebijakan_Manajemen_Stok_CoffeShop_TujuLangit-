package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public class panelLogin extends JPanel {

    public JPanel loginPanel = new JPanel();

    public panelLogin() {
        super();
        setSize(1100, 700);
        setLayout(null);

        loginPanel.setBackground(color.GREEN);
        loginPanel.setBounds(0, 0, 1126, 700);
        loginPanel.setLayout(null);

        add(loginPanel);
    }
    
}
