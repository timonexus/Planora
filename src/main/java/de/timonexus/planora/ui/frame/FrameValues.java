package de.timonexus.planora.ui.frame;

import java.awt.*;

public enum FrameValues {

    WIDTH(200),
    HEIGHT(200),
    BACKGROUNDCOLOR(new Color(42,42,42)),
    TITLE("Planora");
    
    // attribute
    private Object value;

    // constructor
    private FrameValues(Object nValue){
        this.value = nValue;
    }

    // getter
    public Object getValue() {
        return value;
    }

    // setter
    public void setValue(Object value) {
        this.value = value;
    }
}
