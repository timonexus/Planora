package de.timonexus.planora.ui.sidebar.footer;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;

import de.timonexus.planora.utils.Values;

public enum PlanoraSidebarFooterValues implements Values<Object>{

    WIDTH(20),
    HEIGHT(210),
    OPAQUE(false),
    LAYOUT(new BorderLayout()),
    BORDER(BorderFactory.createEmptyBorder(25, 20, 20, 20)),
    ;

    // attributes
    private Object value;

    // constructor
    private PlanoraSidebarFooterValues(Object nValue){
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
