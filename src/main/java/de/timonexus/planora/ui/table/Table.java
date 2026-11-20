package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class Table extends JPanel implements Component{

	// attributes
	private final RoundedPanel basePanel;
	private final TableModel tableModel;
	private Model[] lines;
	private final DefaultPageService service;
	private final List<Integer> selectedLines;

	private Component tableHeader;
	private Component tablebody;

    // constructor
    public Table(Model[] nLines, TableModel nTableModel, DefaultPageService nService){
		this.lines = nLines;
		this.tableModel = nTableModel;
		this.basePanel = new RoundedPanel();
		this.service = nService;
		this.service.setTable(this);
		this.selectedLines = new ArrayList<>();

		this.tableHeader = new TableHeader(this.tableModel, nService, this.selectedLines);
		this.tablebody = new TableBody(this.lines, this.tableModel, nService, this.selectedLines);
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

	}

	@Override
	public void prepareComponents() {

		this.tableHeader.prepareComponent();
		this.tablebody.prepareComponent();
	}

	@Override
	public void addComponents() {
		this.basePanel.removeAll();
		this.removeAll();

		this.basePanel.add((JPanel) this.tableHeader, BorderLayout.NORTH);
		this.basePanel.add((JPanel) this.tablebody, BorderLayout.CENTER);

		this.add(this.basePanel, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
		this.lines = this.service.loadAll();
		this.tableHeader = new TableHeader(this.tableModel, this.service, this.selectedLines);
		this.tablebody = new TableBody(this.lines, this.tableModel, this.service, this.selectedLines);
		
		this.removeAll();

		this.prepareComponents();
		this.addComponents();

	}

    private void skinBasePanel(){
		this.basePanel.setBackground(Colors.APP_BAR.getColor());
		this.basePanel.setRadius(15);
		this.basePanel.setLayout(new BorderLayout());
    }

	public void addSelectedLine(int nId) {
		this.selectedLines.add(nId);
	}

	public List<Integer> getSelectedLines() {
		return selectedLines;
	}

	public void resetSelectedLines(){
		this.selectedLines.clear();
	}

	public void removeSelectedLine(int nId) {
		this.selectedLines.remove(Integer.valueOf(nId));
	}
}
