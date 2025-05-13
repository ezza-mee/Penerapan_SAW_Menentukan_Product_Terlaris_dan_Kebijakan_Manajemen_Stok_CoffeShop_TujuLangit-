package com.main.components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class textArea extends JTextArea {

    private int radius;
    private String placeholder;

    public textArea(int x, int y, int width, int height, int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
        setBounds(x, y, width, height);
        setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 12f));
        setForeground(color.BLACK);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setFocusable(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setFocusable(true);
                requestFocusInWindow();
            }
        });

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(color.LIGHTGREY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner() && placeholder != null) {
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.setColor(color.DARKGREY);
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left, insets.top + g2.getFontMetrics().getAscent());

        }

        g2.dispose();
    }
}
