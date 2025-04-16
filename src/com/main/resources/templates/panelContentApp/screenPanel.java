package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public class screenPanel extends JPanel {

    public JPanel screenPanel = new JPanel();

    public screenPanel() {
        super();
        setBackground(color.RED);
        setSize(1080, 720);
        setOpaque(false);
        setLayout(null);

        screenPanel.setBackground(color.WHITE);
        screenPanel.setBounds(0, 0, 1080, 720);
        screenPanel.setOpaque(false);
        screenPanel.setLayout(null);

        add(screenPanel);
    }

}
