package com.main.components.panelApps;

import javax.swing.JPanel;

import com.main.components.color;

public abstract class wrapperPanel extends JPanel {

    public wrapperPanel() {
        super();
        setSize(1080, 720);
        setLayout(null);
        setBackground(color.RED);
    }

}
