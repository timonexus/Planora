package de.timonexus.planora.service;


import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.table.Table;

public interface DefaultPageService {

    Model[] loadAll(int nId);

    public void refreshTable();
    public void setTable(Table nTable);

    public void addSelectedLine(int nId);
    public void removeSelectedLine(int nId);
    public void addAllLines();
    public void removeAllLines();
    public List<Integer> getSelectedLines();

    public void safe(Model nValues);

    public void delete();

    public void edit();

    public void search(String nText);

    public void showModel(int nLineId);


    public void setFrame(Frame nFrame);
    public void openFormular(/*values */);
    public void closeFormular();
    
}
