package com.components.popUp.popUpExit;

import com.main.resources.templates.framePopUp.framePopUp;


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
