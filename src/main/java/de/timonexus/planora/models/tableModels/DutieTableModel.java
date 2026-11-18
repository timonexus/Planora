package de.timonexus.planora.models.tableModels;

import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.models.Dutie;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.table.TableElement;
import de.timonexus.planora.ui.table.TableObject;

public class DutieTableModel implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement(TableObject.CHECKBOX, "", 0, 30, 30, 30),
            new TableElement(TableObject.PANEL, "ID", 1, 100, 50, 200),
            new TableElement(TableObject.PANEL, "Datum", 2, 500, 300, Integer.MAX_VALUE),
            new TableElement(TableObject.PANEL, "Uhrzeit (kleine)", 3, 300, 200, 400),
            new TableElement(TableObject.PANEL, "Uhrzeit (große)", 4, 300, 200, 400),
            new TableElement(TableObject.PANEL, "Anzahl Betreuer", 5, 300, 200, 400)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
        List<TableElement> columns = getColumns();
        List<TableElement> result = new ArrayList<>();

        for(TableElement column : columns){
            column.setValue(this.getValue(column.getColumnID(), (Dutie) nModel));
            result.add(column);
        }

        return result;
	}

    private String getValue(int nColumnID, Dutie nModel){
        switch (nColumnID) {
            case 0:
                return "";

            case 1:
                return String.valueOf(nModel.getID());

            case 2:
                return String.valueOf(nModel.getDate());
            case 3:
                return String.valueOf(nModel.getUhrzeit_kleine());
            case 4:
                return String.valueOf(nModel.getUhrzeit_große());
            case 5:
                return String.valueOf(nModel.getAnzahlBetreuer());
            
        }
        return "";
    }
    
}
