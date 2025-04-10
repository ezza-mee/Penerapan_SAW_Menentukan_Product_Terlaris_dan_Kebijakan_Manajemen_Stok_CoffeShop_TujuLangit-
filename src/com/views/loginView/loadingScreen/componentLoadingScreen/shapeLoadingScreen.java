package com.views.loginView.loadingScreen.componentLoadingScreen;

import com.partials.*;

public class shapeLoadingScreen {

    private panelRounded shapeOne;
    private panelRounded shapeTwo;
    private panelRounded shapeThree;

    public shapeLoadingScreen() {
        shapeOne = new panelRounded(0, 0, 1080, 720, 0, 0);
        shapeTwo = new panelRounded(0, 230, 1080, 720, 100, 0);
        shapeThree = new panelRounded(0, 240, 1080, 720, 0, 100);

        configColorPanel();
    }

    private void configColorPanel() {
        shapeOne.setBackground(color.DARKGREEN);
        shapeTwo.setBackground(color.GREEN);
        shapeThree.setBackground(color.GREENLIGHT);
    }

    public panelRounded getShapeOne() {
        return shapeOne;
    }

    public panelRounded getShapeTwo() {
        return shapeTwo;
    }

    public panelRounded getShapeThree() {
        return shapeThree;
    }

}
