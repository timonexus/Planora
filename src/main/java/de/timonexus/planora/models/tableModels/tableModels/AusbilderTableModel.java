package de.timonexus.planora.models.tableModels.tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.TableElement;

public class AusbilderTableModel implements TableModel{

	@Override
	public List<TableElement> getColumns() {
        return List.of(
            new TableElement(false, 0, 30, 30, 30, null, SwingConstants.CENTER),
            new TableElement("Name", 1, 500, 300, Integer.MAX_VALUE, null, SwingConstants.LEFT),
            new TableElement("Vorliebenanzahl", 2, 200, 200, 200, null, SwingConstants.RIGHT)
        );
	}

	@Override
	public List<TableElement> getTableElements(Model nModel) {
        List<TableElement> columns = getColumns();
        List<TableElement> result = new ArrayList<>();

        for(TableElement column : columns){
            column.setValue(this.getValue(column.getColumnId(), (Ausbilder) nModel));
            result.add(column);
        }

        return result;
	}

    public Object getValue(int nColumnID, Model nModel){
        Ausbilder ausbilder = (Ausbilder) nModel;
        switch (nColumnID) {
            case 0:
                return false;
            case 1:
                return String.valueOf(ausbilder.getName());
            case 2:
                return String.valueOf(ausbilder.getVorliebenIds().size());
        }
        return "";
    }
    
}
