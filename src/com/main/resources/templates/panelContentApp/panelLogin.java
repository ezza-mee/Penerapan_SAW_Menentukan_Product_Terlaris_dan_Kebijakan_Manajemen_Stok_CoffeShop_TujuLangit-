package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public abstract class panelLogin extends JPanel {

    public JPanel panelLogin = new JPanel();

    public panelLogin() {
        super();
        setSize(1100, 700);
        setLayout(null);

        panelLogin.setBackground(color.GREEN);
        panelLogin.setBounds(0, 0, 1126, 700);
        panelLogin.setLayout(null);

        add(panelLogin);
    }

}
