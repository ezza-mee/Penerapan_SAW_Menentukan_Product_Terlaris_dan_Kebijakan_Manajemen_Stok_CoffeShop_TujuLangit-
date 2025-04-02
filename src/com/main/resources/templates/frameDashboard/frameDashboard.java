package com.main.resources.templates.frameDashboard;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public abstract class frameDashboard extends JFrame {

    private int mouseX, mouseY;

    public JPanel panelFrame = new JPanel();

    public frameDashboard() {
        super();
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelFrame.setBackground(color.LIGHTGRAY);
        panelFrame.setBounds(0, 0, 1366, 768);
        panelFrame.setLayout(null);

        add(panelFrame);

        panelFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                mouseX = event.getX();
                mouseY = event.getY();
            }
        });

        panelFrame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                int newX = event.getXOnScreen() - mouseX;
                int newY = event.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });
    }

}
