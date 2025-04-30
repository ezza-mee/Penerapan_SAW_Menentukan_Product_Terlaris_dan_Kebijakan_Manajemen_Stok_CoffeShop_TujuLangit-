package com.main.layouts.popUp.popUpExit;

import com.main.components.framePopUp.*;


public class parentPopUpExit extends framePopUp {

   private popUpExit componentPopUpExit = new popUpExit(this);

    public parentPopUpExit() {
        super();
        initsPopUpExit();
    }

    private void initsPopUpExit() {
        popUpPanel.add(componentPopUpExit);
    }

}
