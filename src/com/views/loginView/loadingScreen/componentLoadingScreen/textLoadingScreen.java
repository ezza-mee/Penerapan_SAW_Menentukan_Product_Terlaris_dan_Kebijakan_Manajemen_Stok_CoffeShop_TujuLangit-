package com.views.loginView.loadingScreen.componentLoadingScreen;

import com.partials.*;

import javax.swing.*;

public class textLoadingScreen {
    private textLabel lettersTujulangit;
    private textLabel lettersForestpark;

    public textLoadingScreen() {
        configTextBranding();
    }

    public void configTextBranding() {
        lettersTujulangit = new textLabel("TujuLangit", 0, 800, 1080, 100);
        lettersForestpark = new textLabel("Forestpark", 10, 850, 1080, 100);

        lettersTujulangit.setFont(fontSize.FONT_SIZE_80);
        lettersTujulangit.setForeground(color.WHITE);
        lettersTujulangit.setVerticalAlignment(JLabel.CENTER);
        lettersTujulangit.setHorizontalAlignment(JLabel.CENTER);

        lettersForestpark.setFont(fontSize.FONT_SIZE_35);
        lettersForestpark.setForeground(color.WHITE);
        lettersForestpark.setVerticalAlignment(JLabel.CENTER);
        lettersForestpark.setHorizontalAlignment(JLabel.CENTER);
    }

    public textLabel getLettersTujulangit() {
        return lettersTujulangit;
    }

    public textLabel getLettersForestpark() {
        return lettersForestpark;
    }
}
