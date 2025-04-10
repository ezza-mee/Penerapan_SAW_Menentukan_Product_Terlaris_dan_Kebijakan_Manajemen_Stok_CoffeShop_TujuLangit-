package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public abstract class panelLogin extends JPanel {

    public JPanel panelLogin = new JPanel();

    public panelLogin() {
        super();
        setSize(1080, 720);
        setLayout(null);

        panelLogin.setBackground(color.WHITE);
        panelLogin.setBounds(0, 0, 1080, 720);
        panelLogin.setLayout(null);

        add(panelLogin);
    }

}
