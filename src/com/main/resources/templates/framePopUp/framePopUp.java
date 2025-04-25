package com.main.resources.templates.framePopUp;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import com.partials.*;

public abstract class framePopUp extends JFrame {

    public int mouseX, mouseY;

    public JPanel popUpPanel = new JPanel();

    public framePopUp() {
        super();
        setSize(300, 200);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setShape(new RoundRectangle2D.Double(0,0,300, 200, 20, 20));

        popUpPanel.setBackground(color.LIGHTGREY);
        popUpPanel.setBounds(0, 0, 300, 200);
        popUpPanel.setLayout(null);

        add(popUpPanel);

        popUpPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                mouseX = event.getX();
                mouseY = event.getY();
            }
        });

        popUpPanel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                int newX = event.getXOnScreen() - mouseX;
                int newY = event.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });
    }

}