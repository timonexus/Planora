package de.timonexus.planora.ui.table;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableLineList.TableLineList;

public class TableBody extends JPanel implements Component{

    // attributes
    private Model[] lines;
    private final TableModel tableModel;
    private TableLineList tableLineList;
    private final DefaultPageService service;
    private final List<Integer> selectedLines;

    // constructor
    public TableBody(Model[] nLines, TableModel nTableModel, DefaultPageService nService, List<Integer> nSelectedLines){
        this.lines = nLines;
        this.tableModel = nTableModel;
        this.service = nService;
        this.selectedLines = nSelectedLines;

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
            this.setLayout(new GridBagLayout());
            this.add(new TableIsEmpty(), new GridBagConstraints());
        }else{
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for(Model model : lines){
                TableLine currentTableLine = new TableLine(model, this.tableModel, this.service, this.selectedLines.contains(model.getID()) || this.selectedLines.contains(-1));
                currentTableLine.setOpaque(false);
                this.add(currentTableLine);
                this.tableLineList.einfügen(currentTableLine);
            }
        }
    }
    
}
