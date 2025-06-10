package com.main.controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class doubleInputFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, string);

        if (isValidDouble(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);

        if (isValidDouble(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValidDouble(String text) {
        if (text.isEmpty())
            return true;
        try {
            double value = Double.parseDouble(text);
            return value >= 0.0 && value <= 1.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
