package com.main.resources.templates.framePopUp;

import javax.swing.*;

import com.partials.*;

public class framePopUp extends JFrame {

    public int mouseX, mouseY;

    public JPanel popUpPanel = new JPanel();

    public framePopUp() {
        super();
        setSize(300, 300);
        setLayout(null);
        setUndecorated(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(popUpPanel);

        popUpPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event){
                mouseX = event.getX();
                mouseY = event.getY();
            }
        });

        popUpPanel.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent event){
                int newX = event.getXOnScreen() - mouseX;
                int newY = event.getYOnScreen() - mouseY;
                setLocatiuon(newX, newY);
            }
        });
    }

}