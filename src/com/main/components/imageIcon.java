package com.main.components;

import javax.swing.*;
import java.awt.*;

public class imageIcon extends JLabel {
    public imageIcon(String imagePath, int x, int y, int width, int height) {
        super();
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setBounds(x, y, width, height);
    }

    public imageIcon(Icon icon, int x, int y, int width, int height) {
        super();
        Image scaledImage = ((ImageIcon) icon).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setBounds(x, y, width, height);
    }
}
