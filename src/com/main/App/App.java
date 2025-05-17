package com.main.App;

import com.main.controller.appsController;
import com.main.layouts.popUp.popUpFailed;
import com.main.layouts.popUp.popUpFormInputAccountStaff;
import com.main.layouts.popUp.popUpSuccess;

import javax.swing.JPanel;

import com.main.components.*;

public class App {
    public static void main(String[] args) {
        // frameDashboard testFrame = new frameDashboard();
        // testFrame.setVisible(true);

        // appsController.showDashboardAdmin();

        testComponent();
    }

    public static void testComponent() {
        javax.swing.JFrame frame = new javax.swing.JFrame("Test Komposisi Bahan Form View");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color.RED);
        frame.add(panel);

        popUpFailed testPopUp = new popUpFailed();
        testPopUp.setBounds(100, 30, 550,250);
        panel.add(testPopUp);
        
    }
}
