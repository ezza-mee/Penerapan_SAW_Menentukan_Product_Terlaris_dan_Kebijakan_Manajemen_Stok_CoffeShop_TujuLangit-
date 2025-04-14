package com.main.resources.templates.panelContentApp;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;

import com.partials.color;

public class wrapperPanel extends JPanel {

    public JPanel wrapperPanel;

    public wrapperPanel() {
        setBackground(color.RED);
        setSize(1080, 720);
        setLayout(null);

        setLayout(new BorderLayout());
        wrapperPanel = new JPanel(new CardLayout());
        add(wrapperPanel, BorderLayout.CENTER);

        wrapperPanel.setBackground(color.RED);
    }

    public JPanel getWrapperPanel() {
        return wrapperPanel;
    }

}
