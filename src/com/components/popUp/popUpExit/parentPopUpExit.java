package com.components.popUp.popUpExit;

import com.main.resources.templates.framePopUp.framePopUp;
import com.partials.*;

public class parentPopUpExit extends framePopUp {

   private popUpExit componentPopUpExit = new popUpExit();

    public parentPopUpExit() {
        super();
        initsPopUpExit();
    }

    private void initsPopUpExit() {

        popUpPanel.add(componentPopUpExit);

        setVisible(true);
    }

}
