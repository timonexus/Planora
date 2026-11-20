package de.timonexus.planora.models.tableModels.Dienste;

import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.TableElement;
import de.timonexus.planora.ui.table.TableObject;

public class DienstAusbilderTableModel implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement(TableObject.PANEL, "Name", 0, 400, 400, Integer.MAX_VALUE),
            new TableElement(TableObject.CHECKBOX, "", 1, 30, 30, 30),
            new TableElement(TableObject.CHECKBOX, "", 2, 30, 30, 30),
            new TableElement(TableObject.CHECKBOX, "", 3, 30, 30, 30)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTableElements'");
	}
    
}
