package com.main.components;

import javax.swing.*;

public class navigation extends JPanel {

    private JLabel label;
    private imageIcon iconLabel;
    private imageIcon defaultIcon;
    private imageIcon hoverIcon;

    public java.awt.event.MouseAdapter navigationAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(color.WHITE);
            label.setForeground(color.DARKGREEN);
            iconLabel.setIcon(hoverIcon.getIcon());
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(color.WHITE);
            label.setForeground(color.DARKGREEN);
            iconLabel.setIcon(hoverIcon.getIcon());
        }
    };

    public java.awt.event.MouseAdapter navigationInAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(color.WHITE);
            label.setForeground(color.DARKGREEN);
            iconLabel.setIcon(hoverIcon.getIcon());
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(color.DARKGREEN);
            label.setForeground(color.WHITE);
            iconLabel.setIcon(defaultIcon.getIcon());
        }
    };

    public navigation(imageIcon defaultIcon, imageIcon hoverIcon, String text, int y) {
        super();
        this.defaultIcon = defaultIcon;
        this.hoverIcon = hoverIcon;

        setLayout(null);
        setBounds(0, y, 240, 50);
        setBackground(color.DARKGREEN);

        iconLabel = new imageIcon(defaultIcon.getIcon(), 40, 40);
        iconLabel.setBounds(50, 5, 40, 40);

        label = new JLabel(text);
        label.setFont(fontSize.FONT_SIZE_14);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(110, 0, 240, 50);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        add(iconLabel);
        add(label);
        setNavigationAktif();
        revalidate();
        repaint();
    }

    public void setNavigationAktif() {
        try {
            removeMouseListener(navigationInAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(navigationAktif);
        setBackground(color.WHITE);
        label.setForeground(color.DARKGREEN);
        iconLabel.setIcon(hoverIcon.getIcon());
    }

    public void setNavigationInAktif() {
        try {
            removeMouseListener(navigationAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(navigationInAktif);
        setBackground(color.DARKGREEN);
        label.setForeground(color.WHITE);
        iconLabel.setIcon(defaultIcon.getIcon());
    }

}
