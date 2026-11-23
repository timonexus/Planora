package de.timonexus.planora.models.tableModels.tableModels;

import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.TableElement;

public class DutieTableModel implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement(false, 0, 30, 30, 30, null),
            new TableElement("Datum", 2, 500, 300, Integer.MAX_VALUE, null),
            new TableElement("Uhrzeit (kleine)", 3, 300, 200, 400, null),
            new TableElement("Uhrzeit (große)", 4, 300, 200, 400, null),
            new TableElement("Anzahl Betreuer", 5, 300, 200, 400, null)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
        List<TableElement> columns = getColumns();
        List<TableElement> result = new ArrayList<>();

        for(TableElement column : columns){
            column.setValue(this.getValue(column.getColumnId(), (Dutie) nModel));
            result.add(column);
        }

        return result;
	}

    public Object getValue(int nColumnID, Model nModel){
        Dutie dutie = (Dutie) nModel;
        switch (nColumnID) {
            case 0:
                return false;
            case 2:
                return String.valueOf(dutie.getDate());
            case 3:
                return String.valueOf(dutie.getUhrzeit_kleine());
            case 4:
                return String.valueOf(dutie.getUhrzeit_große());
            case 5:
                return String.valueOf(dutie.getAnzahlBetreuer());
            
        }
        return "";
    }
    
}
