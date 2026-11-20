package de.timonexus.planora.models.tableModels;

import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.table.TableElement;

public interface TableModel {
    
    List<TableElement> getColumns();

    List<TableElement> getTableElements(Model nModel);

    Object getValue(int nColumnID, Model nModel);
}
