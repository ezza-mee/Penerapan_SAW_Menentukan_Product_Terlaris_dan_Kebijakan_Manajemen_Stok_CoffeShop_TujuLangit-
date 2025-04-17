package com.partials;

import javax.swing.JTextField;

public class textField extends JTextField {
    public textField(int x, int y, int width) {
        super();
        setBounds(x, y, width, 30);
        setFont(fontSize.FONT_SIZE_12);
        setForeground(color.BLACK);
        setBorder(new javax.swing.border.LineBorder(color.DARKGREEN, 1));
    }

}
