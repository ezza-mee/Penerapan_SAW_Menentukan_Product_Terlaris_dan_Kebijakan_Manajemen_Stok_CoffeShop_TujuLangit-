package com.partials;

import javax.swing.JLabel;

public class textLabel extends JLabel {
    public textLabel(String text, int x, int y, int width, int height) {
        super();
        setText(text);
        setBounds(x, y, width, height);
        setFont(fontSize.FONT_SIZE_13);
    }

}
