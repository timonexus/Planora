package de.timonexus.planora.ui.table.tableLineList;

import java.util.List;

public abstract class ListenElement {

    // attributes
    protected  ListenElement nachfolger;
    protected DatenElement datenElement;

    public abstract ListenElement getNachfolger();
    public abstract DatenElement getDatenElement();
    public abstract ListenElement einfügen(DatenElement nDatenElement);
    public abstract List<DatenElement> listDatenElemente(List<DatenElement> nListDatenElement);
    public abstract int size();
    
}
