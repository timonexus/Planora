package de.timonexus.planora.models.tableModels.Ausbilder;

import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.TableElement;
import de.timonexus.planora.ui.table.TableObject;

public class AusbilderTableModel implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement(TableObject.CHECKBOX, "", 0, 30, 30, 30),
            new TableElement(TableObject.PANEL, "Name", 1, 500, 300, Integer.MAX_VALUE),
            new TableElement(TableObject.PANEL, "Vorliebenanzahl", 2, 200, 200, 200)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
        List<TableElement> columns = getColumns();
        List<TableElement> result = new ArrayList<>();

        for(TableElement column : columns){
            column.setValue(this.getValue(column.getColumnID(), (Ausbilder) nModel));
            result.add(column);
        }

        return result;
	}

    private String getValue(int nColumnID, Ausbilder nModel){
        switch (nColumnID) {
            case 0:
                return "";
            case 1:
                return String.valueOf(nModel.getName());
            case 2:
                return String.valueOf(nModel.getVorliebenIds().size());
        }
        return "";
    }
    
}
