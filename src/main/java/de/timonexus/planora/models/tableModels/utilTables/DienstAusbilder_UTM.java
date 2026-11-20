package de.timonexus.planora.models.tableModels.utilTables;

import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.ui.table.TableElement;

public class DienstAusbilder_UTM implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement("Name", 0, 400, 400, Integer.MAX_VALUE),
            new TableElement("Kleine", 1, 30, 30, 30),
            new TableElement("Große", 2, 30, 30, 30),
            new TableElement("Komplett", 3, 30, 30, 30)
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
		DienstAusbilder_UM dienstAusbilder_UM = (DienstAusbilder_UM) nModel;
        switch (nColumnID) {
            case 0:
                return dienstAusbilder_UM.getAusbilderName();
            case 1:
                return dienstAusbilder_UM.isParticipationYounger();
            case 2:
                return dienstAusbilder_UM.isParticipationOlder();
            case 3:
                return dienstAusbilder_UM.isParticipationWhole();
        }
        return "";
    }
    
}
