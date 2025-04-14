package com.main.resources.templates.panelContentApp;

import javax.swing.*;

import com.partials.*;

public class navbarPanel extends JPanel {

    public JPanel panelSidebar = new JPanel();

    public navbarPanel() {
        super();
        setSize(240, 768);
        setLayout(null);

        panelSidebar.setBackground(color.DARKGREEN);
        panelSidebar.setBounds(0, 0, 240, 768);
        panelSidebar.setLayout(null);

        add(panelSidebar);
    }

}
