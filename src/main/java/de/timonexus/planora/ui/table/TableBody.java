package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableLineList.TableLineList;

public class TableBody extends JPanel implements Component{

    // attributes
    private Model[] lines;
    private final TableModel tableModel;
    private TableLineList tableLineList;

    // constructor
    public TableBody(Model[] nLines, TableModel nTableModel){
        this.lines = nLines;
        this.tableModel = nTableModel;

        this.tableLineList = new TableLineList();
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
	}

	@Override
	public void skinParts() {
        fillTable();
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
	}

	@Override
	public void addComponents() {
	}

	@Override
	public void refresh() {
	}

    private void fillTable(){
        this.removeAll();
        if(lines.length == 0){
            this.setLayout(new BorderLayout());
            this.add(new TableIsEmpty(), BorderLayout.CENTER);
        }else{
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for(Model model : lines){
                TableLine currentTableLine = new TableLine(model, this.tableModel);
                currentTableLine.setOpaque(false);
                this.add(currentTableLine);
                this.tableLineList.einfügen(currentTableLine);
            }
        }
    }
    
}
