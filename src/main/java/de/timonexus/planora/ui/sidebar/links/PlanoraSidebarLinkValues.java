package de.timonexus.planora.ui.sidebar.links;

import java.awt.BorderLayout;

import de.timonexus.planora.utils.Values;

public enum PlanoraSidebarLinkValues implements Values<Object>{

    WIDTH(200),
    HEIGHT(40),
    LAYOUT(new BorderLayout()),
    OPAQUE(false),
    ;

    // attributes
    private Object value;

    // constructor
    private PlanoraSidebarLinkValues(Object nValue){
        this.value = nValue;
    }

	@Override
	public Object getValue() {
        return this.value;
	}

	@Override
	public void setValue(Object nValue) {
        this.value = nValue;
	}
    
}
