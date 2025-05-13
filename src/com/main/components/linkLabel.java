package com.main.components;

import javax.swing.*;

public class linkLabel extends JPanel {

    private JLabel label;

    public java.awt.event.MouseAdapter labelAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));
            label.setForeground(color.DARKGREEN);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREY));
            label.setForeground(color.DARKGREY);
        }
    };

    public java.awt.event.MouseAdapter labelInAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));
            label.setForeground(color.DARKGREEN);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREY));
            label.setForeground(color.DARKGREY);
        }
    };

    public linkLabel(String text, int x, int y, int width, int height) {
        setLayout(null);
        setOpaque(false);
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));

        label = new JLabel(text);
        setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 14f));
        label.setForeground(color.DARKGREEN);
        label.setBounds(0, 0, width, height);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        add(label);
        setLabelAktif();
        revalidate();
        repaint();
    }

    public void setLabelAktif() {
        try {
            removeMouseListener(labelInAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(labelAktif);
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));
        label.setForeground(color.DARKGREEN);
    }

    public void setLabelInAktif() {
        try {
            removeMouseListener(labelAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(labelInAktif);
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREY));
        label.setForeground(color.DARKGREY);
    }

}
