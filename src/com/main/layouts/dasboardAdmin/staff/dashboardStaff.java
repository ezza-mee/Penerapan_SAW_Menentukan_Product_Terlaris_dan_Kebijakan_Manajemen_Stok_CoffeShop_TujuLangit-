package com.main.layouts.dasboardAdmin.staff;

import com.main.components.color;
import com.main.components.fontSize;
import com.main.components.panelRounded;
import com.main.components.textLabel;
import com.main.components.panelApps.contentPanel;

public class dashboardStaff extends contentPanel {

    private textLabel headerLabel;

    private panelRounded contentStaff;

    public dashboardStaff() {
        super();
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();

        add(headerLabel);
        add(contentStaff);

        setVisible(true);
    }

    private void setPosition() {
        headerLabel = new textLabel("Data Staff", 40, 0, 200, 80);
        contentStaff = new panelRounded(40, 80, 1050, 550, 10, 10);
    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);

        contentStaff.setBackground(color.WHITE);
    }

    private void setFont() {
        headerLabel.setFont(fontSize.FONT_SIZE_25);

    }

}
