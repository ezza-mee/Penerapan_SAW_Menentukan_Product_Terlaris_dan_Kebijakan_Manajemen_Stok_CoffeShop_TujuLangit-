package com.main.components.panelApps;

import javax.swing.JPanel;

import com.main.components.color;

public abstract class containerPanel extends JPanel {

    public containerPanel() {
        super();
        setSize(1080, 720);
        setLayout(null);
        setBackground(color.DARKGREY);
    }

}
