package de.timonexus.planora.ui.table.tableLineList;

import java.util.List;

public class Abschluss extends ListenElement{

    @Override 
    public ListenElement getNachfolger(){
        return this;
    }

    @Override
    public ListenElement einfügen(DatenElement nDatenElement) {
        return new Knoten(nDatenElement, this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<DatenElement> listDatenElemente(List<DatenElement> nListDatenElement) {
        return nListDatenElement;
    }

    @Override
    public DatenElement getDatenElement() {
        return null;
    }
    
}
