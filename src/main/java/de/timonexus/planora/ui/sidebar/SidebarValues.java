package de.timonexus.planora.ui.sidebar;

import de.timonexus.planora.utils.Values;

public enum SidebarValues implements Values<Object>{

    WIDTH(200),
    HEIGHT(20),
	;

    // attributes
    private Object value;

    // constructor
    private SidebarValues(Object nValue){
        this.value = nValue;
    }

    // getter
	@Override
	public Object getValue() {
		return value;
	}

    // setter
	@Override
	public void setValue(Object nValue) {
        this.value = nValue;
	}
    
}
