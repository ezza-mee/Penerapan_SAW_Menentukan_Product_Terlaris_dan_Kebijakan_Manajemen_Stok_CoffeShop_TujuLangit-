package com.main.App;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.main.auth.utils.Role;
import com.main.components.color;
import com.main.models.entity.accountDataStaff;
import com.main.models.entity.dataStaff;

public class test {

    public static void main(String[] args) {

        new testFrame().setVisible(true);
    }

    public static class testFrame extends JFrame {
        public testFrame() {
            setTitle("Test Transaction Popup Component");
            setSize(1200, 600);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 1200, 600);
            panel.setBackground(color.DARKGREEN);
            panel.setLayout(null);

            // popUpSelectDataAlternatif test = new popUpSelectDataAlternatif();
            // test.setBounds(0, 0, 1200, 600);
            // panel.add(test);

            add(panel);
        }
    }

}
