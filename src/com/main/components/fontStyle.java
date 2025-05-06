package com.main.components;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class fontStyle {

    private static final String FONT_DIR = "src/com/main/resources/fonts/";
    private static final Map<String, Font> FONT_CACHE = new HashMap<>();

    public enum FontStyle {
        REGULAR("Poppins-Regular.ttf"),
        MEDIUM("Poppins-Medium.ttf"),
        SEMIBOLD("Poppins-SemiBold.ttf"),
        BOLD("Poppins-Bold.ttf"),
        BLACK("Poppins-Black.ttf"),
        LIGHT("Poppins-Light.ttf"),
        THIN("Poppins-Thin.ttf"),
        EXTRABOLD("Poppins-ExtraBold.ttf");

        private final String fileName;

        FontStyle(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    /**
     * Load font based on style and size.
     *
     * @param style Enum FontStyle (e.g., SEMIBOLD, BOLD, etc.)
     * @param size  float size of the font
     * @return Font object with the specified style and size
     */
    public static Font getFont(FontStyle style, float size) {
        try {
            if (!FONT_CACHE.containsKey(style.name())) {
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_DIR + style.getFileName()));
                FONT_CACHE.put(style.name(), baseFont);
            }
            return FONT_CACHE.get(style.name()).deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, (int) size); // fallback font
        }
    }
}
