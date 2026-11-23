package de.timonexus.planora.models.tableModels.utilTables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.utilServices.DienstAusbilder_US;
import de.timonexus.planora.ui.table.TableElement;

public class DienstAusbilder_UTM implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement("Name", 0, 80, 80, Integer.MAX_VALUE, null, SwingConstants.LEFT),
            new TableElement("Kleine", 1, 70, 70, 70, value -> this.changeValues(value, 1), SwingConstants.RIGHT),
            new TableElement("Große", 2, 70, 70, 70, value -> this.changeValues(value, 2), SwingConstants.RIGHT),
            new TableElement("Komplett", 3, 100, 100, 100, value -> this.changeValues(value, 3), SwingConstants.RIGHT)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
        List<TableElement> columns = getColumns();
        List<TableElement> result = new ArrayList<>();

        for(TableElement column : columns){
            column.setValue(this.getValue(column.getColumnId(), (DienstAusbilder_UM) nModel));
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

    private void changeValues(Integer nLineId, Integer nFieldId){
        DienstAusbilder_US service = new DienstAusbilder_US();
        service.change(nLineId, nFieldId);
    }
    
}
