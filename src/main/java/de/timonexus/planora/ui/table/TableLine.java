package de.timonexus.planora.ui.table;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.table.tableLineList.DatenElement;

public class TableLine extends JPanel implements DatenElement{

    // attributes
    private Model model;
    private final TableModel tableModel;

    // constructor
    public TableLine(Model nModel, TableModel nTableModel){
        this.tableModel = nTableModel;
        this.model = nModel;

        getTableLine();
    }

	private void getTableLine() {
        this.setPreferredSize(new Dimension(0, 50));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        for(TableElement element : tableModel.getTableElements(model)){
            JPanel object = element.getDefaultTableObject().getObject(element.getValue());
            object.setPreferredSize(new Dimension(element.getWidth(), 50));
            object.setMaximumSize(new Dimension(element.getMaxWidth(), 50));
            object.setMinimumSize(new Dimension(element.getMinWidth(), 50));
            this.add(object);
        }
	}
    
}
