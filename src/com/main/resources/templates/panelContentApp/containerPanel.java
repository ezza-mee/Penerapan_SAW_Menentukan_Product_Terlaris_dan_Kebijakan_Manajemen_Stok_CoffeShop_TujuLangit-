package com.main.resources.templates.panelContentApp;

import javax.swing.JPanel;

import com.partials.color;

public abstract class containerPanel extends JPanel {

    public JPanel containerPanel = new JPanel();

    public containerPanel() {
        super();
        setSize(1366, 768);
        setOpaque(false);
        setLayout(null);

        containerPanel.setBackground(color.GREEN);
        containerPanel.setBounds(0, 0, 1366, 768);
        containerPanel.setLayout(null);

        add(containerPanel);
    }

}
