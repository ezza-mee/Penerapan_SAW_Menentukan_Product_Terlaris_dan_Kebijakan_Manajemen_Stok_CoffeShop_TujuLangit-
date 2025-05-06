package com.main.components.panelApps;

import javax.swing.*;
import java.awt.*;

import com.main.components.color;

public abstract class popUpPanel extends JPanel {

    public popUpPanel() {
        super();
        setSize(300, 200);
        setBackground(color.WHITE);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); 
        g2.dispose();
    }

}
