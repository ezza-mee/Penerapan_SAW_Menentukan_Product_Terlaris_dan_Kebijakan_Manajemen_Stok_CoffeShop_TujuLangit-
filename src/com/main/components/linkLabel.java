package com.main.components;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JLabel;

public class linkLabel extends JLabel {

    public linkLabel(String text, int x, int y, int width) {
        super();
        setText(text);
        setBounds(x, y, width, 30);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(fontSize.FONT_SIZE_14);
        setForeground(color.DARKGREEN);

        addMouseListener(new java.awt.event.MouseAdapter() {

            Border underLine = BorderFactory.createMatteBorder(0, 0, 2, 0, color.DARKGREEN);

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setForeground(color.GREEN);
                setBorder(underLine);
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setForeground(color.DARKGREEN);
                setBorder(null);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    }

}
