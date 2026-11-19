package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class TableHeader extends JPanel implements Component{

    // attributes
    private final TableModel tableModel;
    private final RoundedPanel basePanel;
    private final DefaultPageService service;
    private final List<Integer> selectedLines;

    // constuctor
    public TableHeader(TableModel nTableModel, DefaultPageService nService, List<Integer> nSelectedLines){
        this.tableModel = nTableModel;
        this.service = nService;
        this.selectedLines = nSelectedLines;

        this.basePanel = new RoundedPanel();
    }

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension(0, 50));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
	}

	@Override
	public void skinParts() {
        skinBasePanel();
        fillHeader();
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
	}

	@Override
	public void addComponents() {
        this.add(this.basePanel, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
	}
    
    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.MENUES.getColor());
        this.basePanel.setCornerRadii(15, 15, 0, 0);
        this.basePanel.setLayout(new BoxLayout(this.basePanel, BoxLayout.X_AXIS));
    }

    private void fillHeader(){
        this.basePanel.removeAll();
        List<TableElement> columns = this.tableModel.getColumns();
        for(TableElement column : columns){
            JPanel object = column.getDefaultTableObject().getObject(column.getValue(), this.service, -1, this.selectedLines.contains(-1));
            object.setPreferredSize(new Dimension(column.getWidth(), 50));
            object.setMaximumSize(new Dimension(column.getMaxWidth(), 50));
            object.setMinimumSize(new Dimension(column.getMinWidth(), 50));
            this.basePanel.add(object);
        }
    }
}
