package com.main.components;

import javax.swing.*;
import java.awt.*;

public class panelRounded extends JPanel {

        private int leftRadius;
        private int rightRadius;

        public panelRounded(int x, int y, int width, int height, int leftRadius, int rightRadius) {
                super();
                this.leftRadius = leftRadius;
                this.rightRadius = rightRadius;
                setBounds(x, y, width, height);
                setOpaque(false);
                setLayout(null);
        }

        public panelRounded() {
                this(0, 0, 200, 200, 10, 10);
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());

                g2.fillRect(leftRadius, 0, getWidth() - leftRadius - rightRadius, getHeight());

                g2.fillRoundRect(0, 0, leftRadius * 2, getHeight(), leftRadius * 2, leftRadius * 2);

                g2.fillRoundRect(getWidth() - rightRadius * 2, 0, rightRadius * 2, getHeight(), rightRadius * 2,
                                rightRadius * 2);
        }

        @Override
        public Dimension getPreferredSize() {
                int maxHeight = 0;
                int maxWidth = 0;

                for (Component comp : getComponents()) {
                        Rectangle bounds = comp.getBounds();
                        maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
                        maxWidth = Math.max(maxWidth, bounds.x + bounds.width);
                }

                // Tambahkan padding jika perlu
                return new Dimension(Math.max(maxWidth, getWidth()), maxHeight);
        }

}
