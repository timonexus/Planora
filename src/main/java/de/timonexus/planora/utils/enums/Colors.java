package de.timonexus.planora.utils.enums;

import java.awt.Color;

public enum Colors {

    BASE(new Color(18, 18, 18)), // #121212
    CARDS(new Color(30, 30, 30)), // #1E1E1E
    APP_BAR(new Color(39, 39, 39)), // #272727
    MENUES(new Color(46, 46, 46)), // #2E2E2E
    DIALOGS(new Color(56, 56, 56)), // #383838
    TEXT(new Color(224, 224, 224)), // #E0E0E0
    TEXT_SECONDARY(new Color(160, 160, 160)), // #A0A0A0
    TEXT_DISABLED(new Color(108, 108, 108)), // #6C6C6C
    PRIMARY(new Color(187, 134, 252)), // #BB86FC
    ERROR(new Color(207, 102, 121)); // #CF6679
    

    // attributes
    private final Color color;

    // constructor
    private Colors(Color nColor){
        this.color = nColor;
    }

    // getter
    public Color getColor() {
        return color;
    }
}
