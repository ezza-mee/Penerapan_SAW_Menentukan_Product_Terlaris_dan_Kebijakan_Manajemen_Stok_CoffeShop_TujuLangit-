package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public abstract class loginPanel extends JPanel {

    public JPanel loginPanel = new JPanel();

    public loginPanel() {
        super();
        setSize(1080, 720);
        setOpaque(false);
        setLayout(null);

        loginPanel.setBackground(color.GREEN);
        loginPanel.setBounds(0, 0, 1080, 720);
        loginPanel.setLayout(null);

        add(loginPanel);
    }

}
