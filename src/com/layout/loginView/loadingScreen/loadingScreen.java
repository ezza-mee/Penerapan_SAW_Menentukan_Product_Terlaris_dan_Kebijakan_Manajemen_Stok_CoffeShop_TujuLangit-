package com.layout.loginView.loadingScreen;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.partials.textLabel;
import com.views.viewLoginApp;
import com.layout.loginView.loadingScreen.componentLoadingScreen.shapeLoadingScreen;
import com.layout.loginView.loadingScreen.componentLoadingScreen.textLoadingScreen;
import com.layout.loginView.loginAdminView.loginAdminView;
import com.main.resources.templates.panelContentApp.screenPanel;
import com.main.resources.templates.panelContentApp.wrapperPanel;

public class loadingScreen extends screenPanel {
    private shapeLoadingScreen shapeLoading;
    private textLoadingScreen textLoading;
    private loginAdminView componentLoginAdminView = new loginAdminView();
    private wrapperPanel wrapperPanel;

    private final Point tujuLangitTarget = new Point(0, 300);
    private final Point forestparkTarget = new Point(0, 370);

    public loadingScreen() {
        setLayout(null);
        initsComponentLoadingScreen();
    }

    public void initsComponentLoadingScreen() {

        configComponentText();
        configComponentShape();
        startLoadingScreen();

        setVisible(true);
    }

    public void configComponentText() {
        textLoading = new textLoadingScreen();

        screenPanel.add(textLoading.getLettersTujulangit());
        screenPanel.add(textLoading.getLettersForestpark());
    }

    public void configComponentShape() {

        shapeLoading = new shapeLoadingScreen();

        shapeLoading.getShapeOne().setBounds(0, 0, 1080, 720);
        shapeLoading.getShapeTwo().setBounds(0, 0, 1080, 720);
        shapeLoading.getShapeThree().setBounds(0, 0, 1080, 720);

        screenPanel.add(shapeLoading.getShapeOne());
        screenPanel.add(shapeLoading.getShapeTwo());
        screenPanel.add(shapeLoading.getShapeThree());
    }

    public void startLoadingScreen() {
        slideInText();
    }

    private void slideInText() {
        final Timer timer = new Timer(10, null);
        final textLabel tujuLangit = textLoading.getLettersTujulangit();
        final textLabel forestpark = textLoading.getLettersForestpark();

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean done = true;

                if (tujuLangit.getY() > tujuLangitTarget.y) {
                    tujuLangit.setLocation(tujuLangit.getX(), tujuLangit.getY() - 5);
                    done = false;
                }

                if (forestpark.getY() > forestparkTarget.y) {
                    forestpark.setLocation(forestpark.getX(), forestpark.getY() - 5);
                    done = false;
                }

                if (done) {
                    timer.stop();

                    Timer delayTimer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                            ((Timer) ev.getSource()).stop();
                            slideOutText();
                            slideOutShapes();
                        }
                    });
                    delayTimer.setRepeats(false);
                    delayTimer.start();
                }
            }
        });

        timer.start();
    }

    private void slideOutText() {
        final Timer timer = new Timer(1, null);
        final textLabel tujuLangit = textLoading.getLettersTujulangit();
        final textLabel forestpark = textLoading.getLettersForestpark();

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean done = true;

                if (tujuLangit.getY() > -100) {
                    tujuLangit.setLocation(tujuLangit.getX(), tujuLangit.getY() - 10);
                    done = false;
                }

                if (forestpark.getY() > -100) {
                    forestpark.setLocation(forestpark.getX(), forestpark.getY() - 10);
                    done = false;

                }

                if (done) {
                    timer.stop();
                }

            }
        });

        timer.start();
    }

    private void slideOutShapes() {
        shapeLoading.getShapeOne().setLocation(0, 0);
        shapeLoading.getShapeTwo().setLocation(0, 100);
        shapeLoading.getShapeThree().setLocation(0, 300);

        final javax.swing.Timer timer = new javax.swing.Timer(15, null);
        final int targetY = -720;

        timer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                boolean done = true;

                if (shapeLoading.getShapeOne().getY() > targetY) {
                    shapeLoading.getShapeOne().setLocation(0, shapeLoading.getShapeOne().getY() - 10);
                    shapeLoading.getShapeOne().repaint();
                    done = false;
                }

                if (shapeLoading.getShapeTwo().getY() > targetY) {
                    shapeLoading.getShapeTwo().setLocation(0, shapeLoading.getShapeTwo().getY() - 10);
                    shapeLoading.getShapeTwo().repaint();
                    done = false;
                }

                if (shapeLoading.getShapeThree().getY() > targetY) {
                    shapeLoading.getShapeThree().setLocation(0, shapeLoading.getShapeThree().getY() - 10);
                    shapeLoading.getShapeThree().repaint();
                    done = false;
                }

                if (done) {
                    timer.stop();
                }
            }
        });

        timer.start();
    }

    public void slideInPanel() {

        componentLoginAdminView.setLocation(0, 720);

        final javax.swing.Timer timer = new javax.swing.Timer(20, null);
        final int targetY = 0;

        timer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                boolean done = true;

                if (componentLoginAdminView.getY() > targetY) {
                    componentLoginAdminView.setLocation(0, componentLoginAdminView.getY() - 10);
                    componentLoginAdminView.repaint();
                    done = false;
                }

                if (done) {
                    timer.stop();
                }
            }
        });

        timer.start();
    }
}
