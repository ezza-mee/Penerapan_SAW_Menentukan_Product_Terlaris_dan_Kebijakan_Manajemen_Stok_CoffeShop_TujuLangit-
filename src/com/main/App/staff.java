package com.main.App;

import com.main.controller.appsController;
import com.main.models.entity.accountDataStaff;
import com.main.models.entity.dataStaff;
import com.main.models.transaction.insertTransaction;
import com.main.views.popUp.popUpTransaction.popUpTransaction;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.main.components.*;

import com.main.auth.sessionLogin;
import com.main.auth.sessionManager;
import com.main.auth.utils.Role;

public class staff {
    public static void main(String[] args) {
        // debug tanpa login ambil data account dan data staff dari database sesuaikan
        // datanya

        accountDataStaff test = new accountDataStaff(17, 73, "anas@email.com", "www",
                "Cashier");
        sessionLogin.set(test);

        dataStaff dummyStaff = new dataStaff(
                73,
                "2025-06-03 21:34:38",
                "anas malik",
                "anas@email.com",
                "32423523",
                "Male",
                "Cashier",
                "malaysia",
                "Active");
        sessionManager.setRole(Role.CASHIER);
        sessionManager.setStaffData(dummyStaff);

        appsController.showDashboardByRole(Role.CASHIER);


        // appsController.showLogin();

        // new testFrame().setVisible(true);
    }
    
    public static class testFrame extends JFrame {
        public testFrame() {
            setTitle("Test Transaction Popup Component");
            setSize(1000, 800);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 1000, 800);
            panel.setBackground(color.DARKGREEN);
            panel.setLayout(null);

            // popUpTransaction test = new popUpTransaction();
            // test.setBounds(200, 100, 600, 600);
            // panel.add(test);

            add(panel);
        }
    }

}
