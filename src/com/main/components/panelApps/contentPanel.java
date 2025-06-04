package com.main.components.panelApps;

import javax.swing.*;
import com.main.components.*;

public abstract class contentPanel extends JPanel {

    public contentPanel() {
        super();
        setOpaque(false);
        setSize(1126, 698);
        setLayout(null);
    }

    public abstract void initContent();

}
