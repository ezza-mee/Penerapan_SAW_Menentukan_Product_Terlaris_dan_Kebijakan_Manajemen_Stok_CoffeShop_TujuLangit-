package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public class screenPanel extends JPanel {

    public JPanel screenPanel = new JPanel();

    public screenPanel() {
        super();
        setSize(1080, 720);
        setLayout(null);

        screenPanel.setBackground(color.WHITE);
        screenPanel.setBounds(0, 0, 1080, 720);
        screenPanel.setLayout(null);

        add(screenPanel);
    }

}
