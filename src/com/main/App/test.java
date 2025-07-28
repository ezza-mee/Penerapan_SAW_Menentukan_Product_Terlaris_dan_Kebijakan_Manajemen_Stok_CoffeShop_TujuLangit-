package com.main.App;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.main.auth.utils.Role;
import com.main.components.color;
import com.main.models.entity.accountDataStaff;
import com.main.models.entity.dataStaff;
import com.main.views.popUp.popUpEditStatusTable.popUpEditStatusTable;

public class test {

    public static void main(String[] args) {

        new testFrame().setVisible(true);
    }

    public static class testFrame extends JFrame {
        public testFrame() {
            setTitle("Test Transaction Popup Component");
            setSize(400, 300);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 400, 300);
            panel.setBackground(color.DARKGREEN);
            panel.setLayout(null);

            // popUpEditStatusTable test = new popUpEditStatusTable();
            // test.setBounds(0, 0, 400, 300);
            // panel.add(test);

            add(panel);
        }
    }

}
