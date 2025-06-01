package com.main.components.panelApps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class glassPanel extends JPanel {
    private float alpha = 0f;
    private Timer fadeTimer;

    private JPanel currentPopUp;

    public glassPanel() {
        setOpaque(false);
        setLayout(null);
        setSize(1080, 720);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentPopUp != null && !currentPopUp.getBounds().contains(e.getPoint())) {
                    hidePopUp();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
        });
        addKeyListener(new KeyAdapter() {
        });
        setFocusable(true);
    }

    public void showPopUp(JPanel popUp) {
        if (getParent() != null) {
            setBounds(0, 0, getParent().getWidth(), getParent().getHeight());
        }

        this.removeAll();
        this.currentPopUp = popUp;

        int x = (getWidth() - popUp.getWidth()) / 2;
        int y = (getHeight() - popUp.getHeight()) / 2;
        popUp.setLocation(x, y);

        add(popUp);
        fadeIn();

        revalidate();
        repaint();
        requestFocusInWindow();
    }

    public void hidePopUp() {
        fadeOut(() -> {
            remove(currentPopUp);
            currentPopUp = null;
            revalidate();
            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(new Color(0, 0, 0, 200));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }

    public void fadeIn() {
        if (fadeTimer != null && fadeTimer.isRunning()) {
            fadeTimer.stop();
        }
        setVisible(true);
        alpha = 0f;
        fadeTimer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 0.7f) {
                    alpha = 0.7f;
                    fadeTimer.stop();
                }
                repaint();
            }
        });
        fadeTimer.start();
    }

    public void fadeOut(Runnable onComplete) {
        if (fadeTimer != null && fadeTimer.isRunning()) {
            fadeTimer.stop();
        }
        fadeTimer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0f) {
                    alpha = 0f;
                    setVisible(false);
                    fadeTimer.stop();
                    if (onComplete != null)
                        onComplete.run();
                }
                repaint();
            }
        });
        fadeTimer.start();
    }

}
