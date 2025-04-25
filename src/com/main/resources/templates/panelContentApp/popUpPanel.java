package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public class popUpPanel extends JPanel {
    public JPanel popUpPanel = new JPanel();

    public popUpPanel() {
        super();
        setSize(300, 200);
        setLayout(null);

        popUpPanel.setBackground(color.WHITE);
        popUpPanel.setBounds(0, 0, 300, 200);
        popUpPanel.setLayout(null);

        add(popUpPanel);
    }
}
