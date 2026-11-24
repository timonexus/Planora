package de.timonexus.planora.models.tableModels.tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Abzeichen;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.TableElement;

public class Abzeichen_TM implements TableModel{

    @Override
    public List<TableElement> getColumns() {
        return List.of(
            new TableElement(false, 0, 30, 30, 30, null, SwingConstants.CENTER),
            new TableElement("Abzeichenname", 1, 100, 100, Integer.MAX_VALUE, null, SwingConstants.LEFT),
            new TableElement("Themenanzahl", 2, 160, 100, 200, null, SwingConstants.RIGHT)
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
    

    @Override
    public Object getValue(int nColumnID, Model nModel) {
        Abzeichen abzeichen = (Abzeichen) nModel;
        switch (nColumnID) {
            case 0:
                return false;
            case 1:
                return String.valueOf(abzeichen.getAbzeichenName());
            case 2:
                return String.valueOf(abzeichen.getThemenAnzahl());
        }
        return "";
    }
    
}
