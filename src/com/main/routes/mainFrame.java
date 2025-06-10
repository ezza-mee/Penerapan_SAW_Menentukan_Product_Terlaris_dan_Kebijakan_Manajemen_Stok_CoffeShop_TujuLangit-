package com.main.routes;

import com.main.auth.utils.Role;
import com.main.components.frameApps.frameApps;
import com.main.components.panelApps.glassPanelDashboard;
import com.main.components.panelApps.glassPanelForm;
import com.main.components.panelApps.glassPanelNotification;
import com.main.components.panelApps.wrapperPanel;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class mainFrame extends frameApps {

    private mainContent mainContent;
    private glassPanelNotification glassNotification;
    private glassPanelDashboard glassDashboard;
    private glassPanelForm glassForm;

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

    public void showDashboardPopUp(JPanel panel) {
        if (glassDashboard == null) {
            glassDashboard = new glassPanelDashboard();
            getLayeredPane().add(glassDashboard, JLayeredPane.MODAL_LAYER);
            // getLayeredPane().setComponentZOrder(glassDashboard, 2);
        }

        SwingUtilities.invokeLater(() -> {
            glassDashboard.setBounds(0, 0, getWidth(), getHeight());
            glassDashboard.showPopUp(panel);
        });
    }

    public void hideGlassDashboardPanel() {
        if (glassDashboard != null) {
            glassDashboard.fadeOut(() -> glassDashboard.setVisible(false));
        }
    }

    public void closeGlassDashboardPanel() {
        if (glassDashboard != null) {
            glassDashboard.setVisible(false);
            remove(glassDashboard);
            revalidate();
            repaint();
        }
    }

    public void showFormPopUp(JPanel panel) {
        if (glassForm == null) {
            glassForm = new glassPanelForm();
            getLayeredPane().add(glassForm, JLayeredPane.POPUP_LAYER);
            // getLayeredPane().setComponentZOrder(glassForm, 1);
        }

        SwingUtilities.invokeLater(() -> {
            glassForm.setBounds(0, 0, getWidth(), getHeight());
            glassForm.showPopUp(panel);
        });
    }

    public void hideGlassFormPanel() {
        if (glassForm != null) {
            glassForm.fadeOut(() -> glassForm.setVisible(false));
        }
    }

    public void closeGlassFormPanel() {
        if (glassForm != null) {
            glassForm.setVisible(false);
            remove(glassForm);
            revalidate();
            repaint();
        }
    }

    public void showNotificationPopUp(JPanel panel) {
        if (glassNotification == null) {
            glassNotification = new glassPanelNotification();
            getLayeredPane().add(glassNotification, JLayeredPane.DRAG_LAYER);
            // getLayeredPane().setComponentZOrder(glassNotification, 0);
        }

        SwingUtilities.invokeLater(() -> {
            glassNotification.setBounds(0, 0, getWidth(), getHeight());
            glassNotification.showPopUp(panel);
        });
    }

    public void hideGlassNotificationPanel() {
        if (glassNotification != null) {
            glassNotification.fadeOut(() -> glassNotification.setVisible(false));
        }
    }

    public void closeGlassNotificationPanel() {
        if (glassNotification != null) {
            glassNotification.setVisible(false);
            remove(glassNotification);
            revalidate();
            repaint();
        }
    }

}