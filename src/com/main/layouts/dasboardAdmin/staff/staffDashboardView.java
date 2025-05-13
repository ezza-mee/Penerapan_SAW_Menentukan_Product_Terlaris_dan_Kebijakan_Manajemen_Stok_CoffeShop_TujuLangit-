package com.main.layouts.dasboardAdmin.staff;

import com.main.components.button;
import com.main.components.color;
import com.main.components.fontStyle;
import com.main.components.panelRounded;
import com.main.components.textLabel;
import com.main.components.panelApps.contentPanel;

import com.main.views.dashboardAdminView;

public class staffDashboardView extends contentPanel {

    private dashboardAdminView parentView;

    private textLabel headerLabel;

    private panelRounded headerContent;
    private panelRounded contentStaff;

    private button buttonAdd;

    public staffDashboardView(dashboardAdminView parentView) {
        super();
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handelButton();

        headerContent.add(buttonAdd);

        add(headerLabel);
        add(headerContent);
        add(contentStaff);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Staff", 40, 0, 200, 80);
        headerContent = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentStaff = new panelRounded(40, 220, 1050, 410, 10, 10);

        buttonAdd = new button("Add", 900, 35, 100, 40, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);
        headerContent.setBackground(color.WHITE);
        contentStaff.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));
    }

    private void handelButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormStaff();
            }
        });
    }

}
