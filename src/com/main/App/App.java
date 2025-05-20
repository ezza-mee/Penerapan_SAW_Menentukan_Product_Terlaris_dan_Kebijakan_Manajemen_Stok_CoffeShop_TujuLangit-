package com.main.App;

import com.main.controller.appsController;
import com.main.layouts.popUp.popUpFailed;
import com.main.layouts.popUp.popUpFormInputAccountStaff;
import com.main.layouts.popUp.popUpSuccess;

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

    // String[] columnNames = { "Bahan", "Jumlah", "Satuan", "Harga", "Kategori" };
    // Object[][] data = {
    // { "Tepung", 10, "kg", 15000, "Kering" },
    // { "Gula", 5, "kg", 12000, "Kering" },
    // { "Telur", 30, "butir", 30000, "Basah" },
    // { "Mentega", 2, "kg", 45000, "Kering" },
    // { "Susu", 3, "liter", 27000, "Cair" }
    // };

    // javax.swing.table.DefaultTableModel model = new
    // javax.swing.table.DefaultTableModel(data, columnNames);
    // table customTable = new table(model);

    // scrollPane scrollPane = new scrollPane(customTable, 0, 0, 800, 800);

    // panel.add(scrollPane);

    // frame.add(panel);
    // frame.setVisible(true);
    // }

}
