package com.partials;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class fontSize {
    public static final Font FONT_SIZE_1;
    public static final Font FONT_SIZE_2;
    public static final Font FONT_SIZE_3;
    public static final Font FONT_SIZE_4;
    public static final Font FONT_SIZE_5;
    public static final Font FONT_SIZE_6;
    public static final Font FONT_SIZE_7;
    public static final Font FONT_SIZE_8;
    public static final Font FONT_SIZE_9;
    public static final Font FONT_SIZE_10;
    public static final Font FONT_SIZE_11;
    public static final Font FONT_SIZE_12;
    public static final Font FONT_SIZE_13;
    public static final Font FONT_SIZE_14;
    public static final Font FONT_SIZE_15;
    public static final Font FONT_SIZE_16;
    public static final Font FONT_SIZE_17;
    public static final Font FONT_SIZE_18;
    public static final Font FONT_SIZE_19;
    public static final Font FONT_SIZE_20;
    public static final Font FONT_SIZE_21;
    public static final Font FONT_SIZE_22;
    public static final Font FONT_SIZE_23;
    public static final Font FONT_SIZE_24;
    public static final Font FONT_SIZE_25;
    public static final Font FONT_SIZE_26;
    public static final Font FONT_SIZE_27;
    public static final Font FONT_SIZE_28;
    public static final Font FONT_SIZE_29;
    public static final Font FONT_SIZE_30;
    public static final Font FONT_SIZE_31;
    public static final Font FONT_SIZE_32;
    public static final Font FONT_SIZE_33;
    public static final Font FONT_SIZE_34;
    public static final Font FONT_SIZE_35;
    public static final Font FONT_SIZE_36;
    public static final Font FONT_SIZE_37;
    public static final Font FONT_SIZE_38;
    public static final Font FONT_SIZE_39;
    public static final Font FONT_SIZE_80;

    static {
        FONT_SIZE_1 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 1);
        FONT_SIZE_2 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 2);
        FONT_SIZE_3 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 3);
        FONT_SIZE_4 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 4);
        FONT_SIZE_5 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 5);
        FONT_SIZE_6 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 6);
        FONT_SIZE_7 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 7);
        FONT_SIZE_8 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 8);
        FONT_SIZE_9 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 9);
        FONT_SIZE_10 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 10);
        FONT_SIZE_11 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 11);
        FONT_SIZE_12 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 12);
        FONT_SIZE_13 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 13);
        FONT_SIZE_14 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 14);
        FONT_SIZE_15 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 15);
        FONT_SIZE_16 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 16);
        FONT_SIZE_17 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 17);
        FONT_SIZE_18 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 18);
        FONT_SIZE_19 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 19);
        FONT_SIZE_20 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 20);
        FONT_SIZE_21 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 21);
        FONT_SIZE_22 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 22);
        FONT_SIZE_23 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 23);
        FONT_SIZE_24 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 24);
        FONT_SIZE_25 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 25);
        FONT_SIZE_26 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 26);
        FONT_SIZE_27 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 27);
        FONT_SIZE_28 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 28);
        FONT_SIZE_29 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 29);
        FONT_SIZE_30 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 30);
        FONT_SIZE_31 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 31);
        FONT_SIZE_32 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 32);
        FONT_SIZE_33 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 33);
        FONT_SIZE_34 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 34);
        FONT_SIZE_35 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 35);
        FONT_SIZE_36 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 36);
        FONT_SIZE_37 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 37);
        FONT_SIZE_38 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 38);
        FONT_SIZE_39 = loadFont("src/com/main/resources/fonts/Poppins-SemiBold.ttf", Font.PLAIN, 39);
        FONT_SIZE_80 = loadFont("src/com/main/resources/fonts/Poppins-Black.ttf", Font.PLAIN, 80);
    }

    private static Font loadFont(String path, int style, float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return font.deriveFont(style, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Jika terjadi kesalahan saat memuat font, fallback ke font default
            return new Font("Serif", style, (int) size);
        }
    }
}
