package de.timonexus.planora.ui.table.tableHeader;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;

import de.timonexus.planora.utils.Values;

public enum TableHeaderValues implements Values<Object>{

    WIDTH(20),
    HEIGHT(50),
    OPAQUE(false),
    LAYOUT(new BorderLayout()),
    BORDER(BorderFactory.createEmptyBorder(25, 20, 20, 20)),
    ;

    // attributes
    private Object value;

    // constructor
    private TableHeaderValues(Object nValue){
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
