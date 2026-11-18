package de.timonexus.planora.ui.table.tableLineList;

import java.util.List;

public class Knoten extends ListenElement{

    public Knoten(DatenElement nDatenElement, ListenElement nNachfolger){
        this.datenElement = nDatenElement;
        this.nachfolger = nNachfolger;
    }

    @Override
    public ListenElement einfügen(DatenElement nDatenElement) {
        return this.nachfolger.einfügen(nDatenElement);
    }

    @Override
    public List<DatenElement> listDatenElemente(List<DatenElement> nListDatenElement) {
        nListDatenElement.add(this.datenElement);
        return this.nachfolger.listDatenElemente(nListDatenElement);
    }

    @Override
    public int size() {
        return this.nachfolger.size() + 1;
    }
    
    @Override
    public ListenElement getNachfolger() {
        return this.nachfolger;
    }

    @Override
    public DatenElement getDatenElement() {
        return this.datenElement;
    }
}
