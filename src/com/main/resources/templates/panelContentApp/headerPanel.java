package com.main.resources.templates.panelContentApp;

import javax.swing.*;

import com.partials.*;

public class headerPanel extends JPanel {

    public JPanel panelHeader = new JPanel();

    public headerPanel() {
        super();
        setSize(1126, 70);
        setLayout(null);

        panelHeader.setBackground(color.WHITE);
        panelHeader.setBounds(0, 0, 1126, 70);
        panelHeader.setLayout(null);

        add(panelHeader);
    }

}
