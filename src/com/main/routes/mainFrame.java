package com.main.routes;

import com.main.auth.utils.Role;
import com.main.components.frameApps.frameApps;
import com.main.components.panelApps.glassPanel;
import com.main.components.panelApps.wrapperPanel;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class mainFrame extends frameApps {

    private mainContent mainContent;
    private glassPanel glass;

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
        setWindowSize(1080, 720);
    }

    public void showDashboard(Role role) {
        setContent(mainContent);
        mainContent.showDashboardByRole(role);
        setWindowSize(1366, 768);
        setVisible(true);
    }

    private void setWindowSize(int width, int height) {
        setSize(width, height);
        setBounds(0, 0, width, height);
        setShape(new RoundRectangle2D.Double(0, 0, width, height, 10, 10));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showGlassPanel(JPanel panel) {
        if (glass == null) {
            glass = new glassPanel();
            getLayeredPane().add(glass, JLayeredPane.POPUP_LAYER);
        }

        SwingUtilities.invokeLater(() -> {
            glass.setBounds(0, 0, getWidth(), getHeight());
            glass.showPopUp(panel);
        });
    }

    public void hideGlassPanel() {
        if (glass != null) {
            glass.fadeOut(() -> glass.setVisible(false));
        }
    }

    public void closeGlassPanel() {
        if (glass != null) {
            glass.setVisible(false);
            remove(glass);
            revalidate();
            repaint();
        }
    }

}