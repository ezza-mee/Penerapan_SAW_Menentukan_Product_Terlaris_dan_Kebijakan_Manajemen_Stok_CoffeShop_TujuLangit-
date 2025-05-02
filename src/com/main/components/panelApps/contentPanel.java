package com.main.components.panelApps;

import javax.swing.*;

public abstract class contentPanel extends JPanel {

    public contentPanel() {
        super();
        setOpaque(false);
        setSize(1126, 698);
        setLayout(null);
    }

    public abstract void initContent();

}
