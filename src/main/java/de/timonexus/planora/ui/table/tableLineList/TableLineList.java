package de.timonexus.planora.ui.table.tableLineList;

import java.util.ArrayList;
import java.util.List;

public class TableLineList {
    
    // attribute
    private ListenElement anfang;

    // constructor
    public TableLineList(){
        this.anfang = new Abschluss();
    }

    // getter
    public ListenElement getAnfang() {
        return anfang;
    }

    public void einfügen(DatenElement nDatenElement){
        this.anfang.einfügen(nDatenElement);
    }

    public int size(){
        return this.anfang.size();
    }

    public List<DatenElement> listDatenElemente(){
        return this.anfang.listDatenElemente(new ArrayList<>());
    }

    // setter
    public void setAnfang(ListenElement anfang) {
        this.anfang = anfang;
    }
}
