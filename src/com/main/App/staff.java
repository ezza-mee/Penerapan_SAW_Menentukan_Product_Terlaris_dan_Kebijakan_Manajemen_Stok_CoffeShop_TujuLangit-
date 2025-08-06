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

        accountDataStaff test = new accountDataStaff(19, 75, "huda@email.com", "www",
                "Cashier");
        sessionLogin.set(test);

        // dataStaff dummyStaff = new dataStaff(
        // 75,
        // "2025-06-04 01:16:56",
        // "hudaa",
        // "huda@email.com",
        // "32423523222",
        // "Male",
        // "Supplier",
        // "malaysia",
        // "Active");

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

}
