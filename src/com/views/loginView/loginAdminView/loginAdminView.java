package com.views.loginView.loginAdminView;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.model.viewLoginApp;

public class loginAdminView extends panelLogin {

    private viewLoginApp contentPanel;

    public loginAdminView(viewLoginApp contentPanel) {
        super();
        this.contentPanel = contentPanel;
        initsComponentLoginAdminView();
    }

    public void initsComponentLoginAdminView() {
        // Tambahkan komponen login admin di sini
        setVisible(true);
    }
}
