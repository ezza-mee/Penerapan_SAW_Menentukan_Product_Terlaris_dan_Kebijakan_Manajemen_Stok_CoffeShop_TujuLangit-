package com.main.App;

import com.main.controller.appsController;
import com.main.layouts.popUp.popUpConfrim;
import com.main.layouts.popUp.popUpFailed;
import com.main.layouts.popUp.popUpSuccess;
import com.main.layouts.popUp.popUpStaff.popUpDetailDataStaff;
import com.main.layouts.popUp.popUpStaff.popUpFormInputAccountStaff;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.main.components.*;

public class App {
    public static void main(String[] args) {
        // frameDashboard testFrame = new frameDashboard();
        // testFrame.setVisible(true);

        appsController.showDashboardAdmin();

        // testComponent();
    }

    // public static void testComponent() {
    // javax.swing.JFrame frame = new javax.swing.JFrame("Test Komposisi Bahan Form
    // View");
    // frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    // frame.setSize(1080, 720);
    // frame.setLocationRelativeTo(null);

    // JPanel panel = new JPanel();
    // panel.setLayout(null);
    // panel.setBackground(color.RED);

    // popUpConfrim testPopUp = new popUpConfrim();
    // testPopUp.setBounds(100, 80, 400, 220);
    // panel.add(testPopUp);

    // frame.add(panel);
    // frame.setVisible(true);
    // }

}
