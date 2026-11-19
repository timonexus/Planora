package de.timonexus.planora.service;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.table.Table;

public interface DefaultPageService {

    Model[] loadAll();

    public void refreshTable();
    public void setTable(Table nTable);

    public void addSelectedLine(int nId);
    public void removeSelectedLine(int nId);
    
}
