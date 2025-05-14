package com.main.components;

import javax.swing.JLabel;

public class textLabel extends JLabel {

    public textLabel(String text, int x, int y, int width, int height) {
        super(text);
        setBounds(x, y, width, height);
    }

}
