package de.timonexus.planora.ui.pages.pageHeader.pageHeaderSearchbar;

import javax.swing.BorderFactory;

import de.timonexus.planora.utils.Values;

public enum PageHeaderSearchbarValues implements Values<Object>{

    WIDTH(300),
    HEIGHT(20),
    BORDER(BorderFactory.createEmptyBorder(15, 20, 15, 20)),
	;

    // attributes
    private Object value;

    // constructor
    private PageHeaderSearchbarValues(Object nValue){
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
