package com.main.components.frameApps;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public abstract class frameApps extends JFrame {

    public frameApps() {
        super();
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setShape(new RoundRectangle2D.Double(0, 0, 1080, 720, 10, 10));
    }
}
