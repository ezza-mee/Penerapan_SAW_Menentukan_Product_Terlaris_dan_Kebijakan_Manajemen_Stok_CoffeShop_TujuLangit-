package com.main.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.geom.Path2D;

public class customComboBoxUI extends BasicComboBoxUI {

    private final comboBox<?> parentCombo;

    public customComboBoxUI(comboBox<?> combo) {
        this.parentCombo = combo;
        parentCombo.setBackground(color.LIGHTGREY);
    }

    @Override
    protected JButton createArrowButton() {
        return new CustomArrowButton();
    }

    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup popup = new BasicComboPopup(comboBox) {
            @Override
            protected JScrollPane createScroller() {
                JList<Object> list = getList();
                return new scrollPane(list, 0, 0, 0, 0);
            }
        };

        popup.getList().setSelectionBackground(color.DARKGREEN);
        popup.getList().setSelectionForeground(Color.WHITE);
        popup.getList().setBackground(color.LIGHTGREY);
        popup.setBorder(BorderFactory.createEmptyBorder());

        return popup;
    }

    private class CustomArrowButton extends JButton {
        public CustomArrowButton() {
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            g2.setColor(parentCombo.isPopupVisible()
                    ? color.DARKGREEN.darker()
                    : parentCombo.getArrowColor());

            int arrowSize = 8;
            int x = (width - arrowSize) / 2;
            int y = (height - arrowSize / 2) / 2;

            Path2D arrow = new Path2D.Double();
            arrow.moveTo(x, y);
            arrow.lineTo(x + arrowSize, y);
            arrow.lineTo(x + arrowSize / 2, y + arrowSize / 2);
            arrow.closePath();

            g2.fill(arrow);
            g2.dispose();
        }
    }
}
