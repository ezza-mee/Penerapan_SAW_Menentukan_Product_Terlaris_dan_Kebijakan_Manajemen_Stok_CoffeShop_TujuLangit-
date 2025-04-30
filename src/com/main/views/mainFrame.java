package com.main.views;

import com.main.components.frameApps.frameApps;
import com.main.components.panelApps.wrapperPanel;
import java.awt.geom.RoundRectangle2D;

public class mainFrame extends frameApps {

    private mainContent mainContent;

    public mainFrame() {
        super();
        mainContent = new mainContent(this);
    }

    public void setContent(wrapperPanel view) {
        getContentPane().removeAll();
        add(view);
        revalidate();
        repaint();
    }

    public void showLoginApp() {
        setContent(mainContent);
        mainContent.showLoginView();
        setSize(1080, 720);
        setBounds(0, 0, 1080, 720);
        setShape(new RoundRectangle2D.Double(0, 0, 1080, 720, 10, 10));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showDashboardAdmin() {
        setContent(mainContent);
        mainContent.showDashboardAdmin();
        setSize(1366, 768);
        setBounds(0, 0, 1366, 768);
        setShape(new RoundRectangle2D.Double(0, 0, 1366, 768, 10, 10));
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
