package de.timonexus.planora.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public enum Fonts {
    LOGO("/fonts/montserrat/Montserrat-Black.ttf", 800, 20);

    // attributes
    private final String path;
    private final int style;
    private final float size;

    // constructor
    private Fonts(String nPath, int nStyle, float nSize){
        this.path = nPath;
        this.style = nStyle;
        this.size = nSize;
    }

    public Font loadFont(){
        try(InputStream stream = Fonts.class.getResourceAsStream(path)){
            if(stream == null) throw new IllegalStateException("Font not found: " + path);

            return Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(this.style, this.size);
        } catch (FontFormatException | IOException e) {
            throw new IllegalStateException(
                    "Could not load font: " + path, e
            );
        }
    }
}
