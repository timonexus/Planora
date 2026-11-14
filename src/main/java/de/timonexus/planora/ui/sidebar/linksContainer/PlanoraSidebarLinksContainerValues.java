package de.timonexus.planora.ui.sidebar.linksContainer;

import javax.swing.BorderFactory;

import de.timonexus.planora.utils.Values;

public enum PlanoraSidebarLinksContainerValues  implements Values<Object>{

    WIDTH(20),
    HEIGHT(500),
    OPAQUE(false),
    BORDER(BorderFactory.createEmptyBorder(25, 20, 20, 20)),
    ;

    // attributes
    private Object value;

    // constructor
    private PlanoraSidebarLinksContainerValues(Object nValue){
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
