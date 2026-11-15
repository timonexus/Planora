package de.timonexus.planora.ui.pages.pageHeader;

import de.timonexus.planora.utils.Values;

public enum PageHeaderValues implements Values<Object>{
	
    WIDTH(20),
    HEIGHT(70),

    ;

    // attributes
    private Object value;

    // constructor
    private PageHeaderValues(Object nValue){
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
