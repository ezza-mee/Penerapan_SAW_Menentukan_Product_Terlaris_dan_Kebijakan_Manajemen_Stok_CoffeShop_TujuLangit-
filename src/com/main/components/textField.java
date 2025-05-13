package com.main.components;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class textField extends JTextField {
    private int radius;
    private String placeholder;

    public textField(int x, int y, int width, int radius) {
        super();
        this.radius = radius;
        setBounds(x, y, width, 30);
        setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 12f));
        setForeground(color.BLACK);
        setOpaque(false);
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
            g2.drawString(placeholder, insets.left, getHeight() / 2 + getFont().getSize() / 2 - 2);
        }

        g2.dispose();
    }
}
