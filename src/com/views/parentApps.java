package com.views;

import com.main.resources.templates.frameApps.frameApps;
import java.awt.geom.RoundRectangle2D;

public class parentApps extends frameApps {

    private viewLoginApp componentLoginApp;

    public parentApps() {
        super();
        componentLoginApp = new viewLoginApp(this);
        initsFrameLogin();
    }

    public void initsFrameLogin() {

        panelFrame.add(componentLoginApp);

        setVisible(true);
    }

    public void showDashboardAdmin() {
        setSize(1366, 768);
        setLocationRelativeTo(null);
        panelFrame.setBounds(0, 0, 1366, 768);
        setShape(new RoundRectangle2D.Double(0, 0, 1366, 768, 10, 10));
        repaint();
        revalidate();
    }

}
