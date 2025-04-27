package com.components.popUp.popUpLogin;

import com.main.resources.templates.framePopUp.framePopUp;

public class parentShowFailure extends framePopUp {

    private showFailure componentPopUpFailure = new showFailure();

    public parentShowFailure() {
        super();
        initsPopUpFailure();
    }

    private void initsPopUpFailure() {
        popUpPanel.add(componentPopUpFailure);
    }

}
