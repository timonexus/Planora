package de.timonexus.planora.ui.sidebar.header;

import de.timonexus.planora.utils.Values;

public enum PlanoraSidebarHeaderValues implements Values<Object>{
    
    WIDTH(20),
    HEIGHT(100),
	;

    // attributes
    private Object value;

    // constructor
    private PlanoraSidebarHeaderValues(Object nValue){
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
