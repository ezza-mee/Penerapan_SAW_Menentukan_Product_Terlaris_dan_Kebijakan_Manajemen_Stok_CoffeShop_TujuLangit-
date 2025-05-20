package com.main.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class scrollPane extends JScrollPane {

    public scrollPane(Component view, int x, int y, int width, int height) {
        super(view);
        setViewportView(view);
        setBounds(x, y, width, height);
        setOpaque(false);
        getViewport().setBackground(color.DARKGREY);
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setDoubleBuffered(true);
        getVerticalScrollBar().setUnitIncrement(10);

        setViewportBorder(BorderFactory.createLineBorder(color.DARKGREY, 0, true));

        JScrollBar vertical = getVerticalScrollBar();
        vertical.setPreferredSize(new Dimension(10, 0));
        vertical.setBackground(color.DARKGREY);
        vertical.setUI(new RoundedScrollBarUI());

        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    static class RoundedScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
        private final int THUMB_SIZE = 200;

        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = color.DARKGREEN;
            this.trackColor = color.DARKGREY;
        }

        @Override
        protected Dimension getMaximumThumbSize() {
            return new Dimension(10, THUMB_SIZE);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
            g2.dispose();
        }

    }
}
