package com.main.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class scrollTable extends JScrollPane {

    public scrollTable(JTable table, int x, int y, int width, int height) {
        super(table);
        setViewportView(table); 
        setBounds(x, y, width, height);

        setOpaque(true);
        getViewport().setBackground(Color.WHITE); 
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setDoubleBuffered(true);

        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar vertical = getVerticalScrollBar();
        vertical.setPreferredSize(new Dimension(10, 0));
        vertical.setBackground(Color.LIGHT_GRAY);
        vertical.setUI(new scrollPane.RoundedScrollBarUI()); 

        JScrollBar horizontal = getHorizontalScrollBar();
        horizontal.setPreferredSize(new Dimension(0, 10));
        horizontal.setBackground(Color.LIGHT_GRAY);
        horizontal.setUI(new scrollPane.RoundedScrollBarUI()); 
    }
}
