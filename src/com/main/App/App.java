package com.main.App;

import com.main.controller.appsController;
import com.main.models.entity.accountDataStaff;
import com.main.auth.sessionLogin;
import com.main.auth.utils.Role;

public class App {
    public static void main(String[] args) {
        accountDataStaff test = new accountDataStaff(17, 73, "anas@email.com", "www",
        "Cashier");
        sessionLogin.set(test);

        appsController.showDashboardByRole(Role.CASHIER);
        // appsController.showDashboardAdmin();
        // appsController.showLogin();
    }

}
