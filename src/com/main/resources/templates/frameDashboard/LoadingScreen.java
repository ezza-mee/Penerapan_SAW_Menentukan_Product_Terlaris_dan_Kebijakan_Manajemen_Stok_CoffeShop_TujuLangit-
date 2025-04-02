package com.main.resources.templates.frameDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingScreen extends JFrame {
    private JProgressBar progressBar;
    private JLabel loadingLabel;
    private int progress = 0;
    private Timer timer;

    public LoadingScreen() {
        setTitle("Loading...");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Label "Loading..."
        loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(loadingLabel, BorderLayout.CENTER);

        // Progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(50, 150, 255));
        add(progressBar, BorderLayout.SOUTH);

        // Timer untuk animasi progress
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 2;
                progressBar.setValue(progress);

                // Animasi perubahan teks loading
                if (progress % 10 == 0) {
                    String dots = ".".repeat((progress / 10) % 4);
                    loadingLabel.setText("Loading" + dots);
                }

                // Jika loading selesai, buka aplikasi utama
                if (progress >= 100) {
                    timer.stop();
                    openMainApp();
                }
            }
        });

        timer.start();
        setVisible(true);
    }

    private void openMainApp() {
        dispose(); // Tutup loading screen
        JFrame mainFrame = new JFrame("Aplikasi Utama");
        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(new JLabel("Selamat Datang!", SwingConstants.CENTER), BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoadingScreen();
    }
}
