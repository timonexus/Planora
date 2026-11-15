package de.timonexus.planora.ui.pages.pageHeader.pageHeaderButton;

import javax.swing.BorderFactory;

import de.timonexus.planora.utils.Values;

public enum PageHeaderButtonValues implements Values<Object>{

    WIDTH(40),
    HEIGHT(40),
    BORDER(BorderFactory.createEmptyBorder(15, 20, 15, 20)),
	;

    // attributes
    private Object value;

    // constructor
    private PageHeaderButtonValues(Object nValue){
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
