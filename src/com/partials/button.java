package com.partials;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class button extends JButton {
    private int radius;
    private Color originalBackground;
    private Color hoverBackground;
    private Color pressedBackground;
    private imageIcon icon;

    public button(String text, int x, int y, int width, int height, int radius) {
        super(text);
        this.radius = radius;

        setFont(fontSize.FONT_SIZE_16);
        setBounds(x, y, width, height);
        setBackground(color.DARKGREEN);
        setForeground(color.WHITE);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setFocusPainted(false);
        setContentAreaFilled(false);

        originalBackground = getBackground();
        hoverBackground = color.GREEN;
        pressedBackground = color.GREENLIGHT;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (contains(e.getPoint())) {
                    setBackground(hoverBackground);
                } else {
                    setBackground(originalBackground);
                }
            }
        });
    }

    public void setIcon(imageIcon icon) {
        this.icon = icon;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        if (icon != null) {
            int iconX = 10;
            int iconY = (getHeight() - icon.getHeight()) / 2;
            g2.drawImage(((ImageIcon) icon.getIcon()).getImage(), iconX, iconY, this);
            setIconTextGap(icon.getWidth() + 10);
            setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        super.paintComponent(g);
        g2.dispose();
    }

    public void setHoverBackground(Color hoverBackground){
        this.hoverBackground = hoverBackground;
    }

    public void setPressedBackground(Color pressedBackground){
        this.pressedBackground = pressedBackground;
    }

    public void setOriginalBackground(Color originalBackground) {
        this.originalBackground = originalBackground;
    }
}
