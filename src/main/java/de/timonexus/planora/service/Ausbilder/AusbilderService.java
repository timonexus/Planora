package de.timonexus.planora.service.Ausbilder;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.AusbilderRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.formulars.AusbilderFormular;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.table.Table;

public class AusbilderService implements DefaultPageService{

	// attributes
	private final Repository repository;
	private Frame frame;
	private Table table;

	// constructor
	public AusbilderService(){
		this.repository = new AusbilderRepository();
	}

	@Override
	public Model[] loadAll() {
		return this.repository.loadAll();
	}

	@Override
	public void refreshTable() {
		this.table.refresh();
	}

	@Override
	public void setTable(Table nTable) {
		this.table = nTable;
	}

	@Override
	public void addSelectedLine(int nId) {	
		this.table.addSelectedLine(nId);
	}

	@Override
	public void removeSelectedLine(int nId) {
		this.table.removeSelectedLine(nId);
	}

	@Override
	public void safe(Model nValues) {
		this.repository.safe(nValues);
		this.refreshTable();
	}

	@Override
	public void delete() {
		this.repository.delete(this.table.getSelectedLines());
		this.table.resetSelectedLines();
		this.refreshTable();
	}

	@Override
	public void edit() {
		AusbilderFormular formular = new AusbilderFormular(this, () -> this.closeFormular());
		formular.setData(this.table.loadSelectedLine());

		this.table.resetSelectedLines();
		this.frame.showFormularPane(formular);
	}

	@Override
	public void search(String nText) {
		this.table.refresh(this.repository.search(nText));
	}

	@Override
	public void showModel(int nLineId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'showModel'");
	}

	@Override
	public void setFrame(Frame nFrame) {
		this.frame = nFrame;
	}

	@Override
	public void openFormular() {
		this.frame.showFormularPane(new AusbilderFormular(this, () -> this.closeFormular()) );
	}

	@Override
	public void closeFormular() {
        this.frame.hideFormularPane();
	}
    
}
