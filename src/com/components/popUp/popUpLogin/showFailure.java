package com.components.popUp.popUpLogin;

import com.main.resources.templates.panelContentApp.popUpPanel;
import com.partials.*;

public class showFailure extends popUpPanel {

    private textLabel labelHeader;

    private textLabel labelPopUp;

    public showFailure() {
        super();
        initsComponentPopUpFailure();
    }

    private void initsComponentPopUpFailure() {
        setPositionComponent();

        popUpPanel.add(labelHeader);
        popUpPanel.add(labelPopUp);

        setVisible(true);
    }

    private void setPositionComponent() {
        labelHeader = new textLabel(TOOL_TIP_TEXT_KEY, ALLBITS, ABORT, WIDTH, HEIGHT);
        labelHeader = new textLabel("Check your Username and Password", 0, 40, 300, 100);

    }

    private void setColorComponent() {

    }

}
