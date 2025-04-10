package com.model;

import com.main.resources.templates.panelContentApp.panelLogin;
import com.views.loginView.loadingScreen.loadingScreen;
import com.views.loginView.loginAdminView.loginAdminView;
import com.views.loginView.loginStaffView.loginStaffView;

import javax.swing.*;
import java.awt.*;

public class viewLoginApp extends panelLogin {

    private loadingScreen componentLoadingScreenView;
    private loginAdminView componentLoginAdminView;
    private loginStaffView componentLoginStaffView;

    public viewLoginApp() {
        super();
        setLayout(new BorderLayout());

        // Inisialisasi panel dengan parameter this
        componentLoadingScreenView = new loadingScreen(this);
        componentLoginAdminView = new loginAdminView(this);
        componentLoginStaffView = new loginStaffView(this);

        // Mulai dari loading screen
        showLoadingScreenView();
    }

    public void setContent(JPanel newContent) {
        removeAll(); // Bersihkan konten lama
        add(newContent, BorderLayout.CENTER); // Tambahkan yang baru
        revalidate(); // Perbarui layout
        repaint(); // Gambar ulang
    }

    public void showLoadingScreenView() {
        setContent(componentLoadingScreenView);
    }

    public void showLoginAdminView() {
        setContent(componentLoginAdminView);
    }

    public void showLoginStaffView() {
        setContent(componentLoginStaffView);
    }
}
