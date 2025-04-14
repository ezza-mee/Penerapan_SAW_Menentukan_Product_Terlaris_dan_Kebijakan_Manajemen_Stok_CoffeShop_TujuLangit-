package com.main.resources.templates.panelContentApp;

import javax.swing.*;

import com.partials.*;

public class contentPanel extends JPanel {

    public JPanel panelContent = new JPanel();

    public contentPanel() {
        super();
        setSize(1126, 698);
        setLayout(null);

        panelContent.setBackground(color.LIGHTGRAY);
        panelContent.setBounds(0, 0, 1126, 698);
        panelContent.setLayout(null);

        add(panelContent);
    }

}
