package com.main.components;

import javax.swing.*;

public class linkLabel extends JPanel {

    private JLabel label;
    private JLabel quantityLabel; // label jumlah

    public java.awt.event.MouseAdapter labelAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));
            label.setForeground(color.DARKGREEN);
            quantityLabel.setBackground(color.RED);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREY));
            label.setForeground(color.DARKGREY);
            quantityLabel.setBackground(color.DARKGREY);
        }
    };

    public java.awt.event.MouseAdapter labelInAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));
            label.setForeground(color.DARKGREEN);
            quantityLabel.setBackground(color.RED);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREY));
            label.setForeground(color.DARKGREY);
            quantityLabel.setBackground(color.DARKGREY);
        }
    };

    public linkLabel(String text, int x, int y, int width, int height) {
        setLayout(null);
        setOpaque(false);
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color.DARKGREEN));

        label = new JLabel(text);
        label.setForeground(color.DARKGREEN);
        label.setBounds(0, 0, width, height);

        quantityLabel = new RoundedLabel("0");
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quantityLabel.setBackground(color.DARKGREY);
        quantityLabel.setForeground(color.WHITE);
        quantityLabel.setBounds(width - 25, 5, 20, 20);
        quantityLabel.setBorder(BorderFactory.createEmptyBorder());

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
        add(quantityLabel);
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
        updateQuantityStyle(true);
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
        updateQuantityStyle(false);
    }

    public void setLinkLabelFont(java.awt.Font font) {
        label.setFont(font);
        quantityLabel.setFont(font);
    }

    public void setQuantity(int qty) {
        quantityLabel.setText(String.valueOf(qty));
    }

    private void updateQuantityStyle(boolean isActive) {
        if (isActive) {
            quantityLabel.setBackground(color.RED);
        } else {
            quantityLabel.setBackground(color.DARKGREY);
        }
    }

    class RoundedLabel extends JLabel {
        public RoundedLabel(String text) {
            super(text);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
            g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

            // Warna background
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            super.paintComponent(g);
            g2.dispose();
        }
    }

}
