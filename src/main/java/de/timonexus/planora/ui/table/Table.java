package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableHeader.TableHeader;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class Table extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
	private final Component tableHeader;

	private Model tableModel;

	private TableColumn[] columns;

    // constructor
    public Table(Model nTableModel){
		this.tableModel = nTableModel;
		this.columns = this.tableModel.getColumns();

        this.basePanel = new RoundedPanel();
		this.tableHeader = new TableHeader(this.columns);
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	}

	@Override
	public void skinParts() {
        skinBasePanel();
	}

	@Override
	public void addParts() {
		// basePanel
		this.basePanel.add((JPanel) this.tableHeader, BorderLayout.NORTH);

        this.add(this.basePanel, BorderLayout.CENTER);
	}

	@Override
	public void prepareComponents() {
		this.tableHeader.prepareComponent();
	}

	@Override
	public void addComponents() {
	}

	@Override
	public void refresh() {
	}

    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.APP_BAR.getColor());
        this.basePanel.setRadius(15);
        this.basePanel.setLayout(new BorderLayout());
    }
    
}
