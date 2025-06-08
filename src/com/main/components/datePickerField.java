package com.main.components;

import org.jdatepicker.impl.*;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import javax.swing.border.EmptyBorder;

public class datePickerField extends JPanel {
    private UtilDateModel model;
    private JDatePickerImpl datePicker;

    public datePickerField(int x, int y, int width, int height, String placeholder) {
        setLayout(null); // null layout agar tidak trigger resize frame
        setOpaque(false);
        setBounds(x, y, width, height);

        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hari Ini");
        p.put("text.month", "Bulan");
        p.put("text.year", "Tahun");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        datePicker.setBounds(0, 0, width, 30);
        add(datePicker);

        // Custom editor
        JTextField editor = (JTextField) datePicker.getJFormattedTextField();
        editor.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 12f));
        editor.setForeground(color.BLACK);
        editor.setBorder(new EmptyBorder(5, 10, 5, 10));
        editor.setOpaque(false);
        editor.setBackground(null);
        editor.setText("");

        // Placeholder
        if (placeholder != null) {
            editor.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
                @Override
                protected void paintSafely(Graphics g) {
                    super.paintSafely(g);
                    if (editor.getText().isEmpty() && !editor.hasFocus()) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setFont(editor.getFont().deriveFont(Font.ITALIC));
                        g2.setColor(color.DARKGREY);
                        Insets insets = editor.getInsets();
                        g2.drawString(placeholder, insets.left,
                                editor.getHeight() / 2 + editor.getFont().getSize() / 2 - 2);
                        g2.dispose();
                    }
                }
            });
        }

        // Tombol 📅
        JButton customButton = (JButton) datePicker.getComponent(1);
        customButton.setText("📅");
        customButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        customButton.setForeground(color.WHITE);
        customButton.setBackground(color.PRIMARY);
        customButton.setBorderPainted(false);
        customButton.setFocusPainted(false);
        customButton.setOpaque(true);
        customButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public String getSelectedDate() {
        Object value = datePicker.getModel().getValue();
        if (value != null) {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").format((java.util.Date) value);
        }
        return null;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }
}
