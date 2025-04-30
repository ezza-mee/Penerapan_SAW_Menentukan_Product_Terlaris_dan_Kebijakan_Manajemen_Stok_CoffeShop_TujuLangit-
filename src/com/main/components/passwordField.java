package com.main.components;

import javax.swing.JPasswordField;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class passwordField extends JPasswordField {
    private int radius;

    public passwordField(int x, int y, int width, int radius) {
        super();
        this.radius = radius;
        setBounds(x, y, width, 30);
        setFont(fontSize.FONT_SIZE_14);
        setEchoChar('•');
        setForeground(color.BLACK);
        setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(color.WHITE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke((new BasicStroke(1)));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}
