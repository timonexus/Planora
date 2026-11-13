package de.timonexus.planora.ui.frame;

import de.timonexus.planora.utils.Values;

public enum FrameValues implements Values<Object>{

    WIDTH(1500),
    HEIGHT(800),
    TITLE("Planora");
    
    // attribute
    private Object value;

    // constructor
    private FrameValues(Object nValue){
        this.value = nValue;
    }

    // getter
    @Override 
    public Object getValue() {
        return value;
    }

    // setter
    @Override 
    public void setValue(Object value) {
        this.value = value;
    }
}
