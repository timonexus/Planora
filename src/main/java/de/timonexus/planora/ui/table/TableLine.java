package de.timonexus.planora.ui.table;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.table.tableLineList.DatenElement;
import de.timonexus.planora.utils.enums.Colors;

public class TableLine extends JPanel implements DatenElement{

    // attributes
    private Model model;
    private final TableModel tableModel;
    private final DefaultPageService service;
    private boolean isChecked;

    // constructor
    public TableLine(Model nModel, TableModel nTableModel, DefaultPageService nService, boolean nIsChecked){
        this.tableModel = nTableModel;
        this.model = nModel;
        this.service = nService;
        this.isChecked = nIsChecked;

        getTableLine();
    }

	private void getTableLine() {
        this.setPreferredSize(new Dimension(0, 50));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        for(TableElement element : tableModel.getTableElements(model)){
            JPanel object = TableObject.getObject(element.getValue() instanceof Boolean ? (element.getAction() != null ? element.getValue() : this.isChecked) : element.getValue(), this.service, this.model.getID(), this.isChecked, element.getAction());
            object.setPreferredSize(new Dimension(element.getWidth(), 40));
            object.setMaximumSize(new Dimension(element.getMaxWidth(), 40));
            object.setMinimumSize(new Dimension(element.getMinWidth(), 40));
            if(this.isChecked){
                object.setOpaque(true);
                object.setBackground(Colors.DIALOGS.getColor());
            }
            this.add(object);
        }
	}
    
}
