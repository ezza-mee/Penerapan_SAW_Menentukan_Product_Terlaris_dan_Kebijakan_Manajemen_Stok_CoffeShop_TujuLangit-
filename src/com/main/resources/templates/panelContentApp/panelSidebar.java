package com.main.resources.templates.panelContentApp;

import javax.swing.*;

import com.partials.*;

public class panelSidebar extends JPanel {

    public JPanel panelSidebar = new JPanel();

    public panelSidebar() {
        super();
        setSize(240, 768);
        setLayout(null);

        panelSidebar.setBackground(color.GREEN);
        panelSidebar.setBounds(0, 0, 240, 768);
        panelSidebar.setLayout(null);

        add(panelSidebar);
    }

}
