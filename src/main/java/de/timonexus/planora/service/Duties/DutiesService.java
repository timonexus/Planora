package de.timonexus.planora.service.Duties;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.DutiesRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.formulars.DutiesFormular;
import de.timonexus.planora.ui.formulars.ViewFormulars.ViewDutie;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.table.Table;

public class DutiesService implements DefaultPageService{

    // attributes
    private final Repository repository;
    private Frame frame;
    private Table table;

    // constructor
    public DutiesService(DefaultPage nPage){
        this.repository = new DutiesRepository();
    }

	@Override
	public Model[] loadAll() {
        return this.repository.loadAll();
	}

    @Override
    public void delete(){
        this.repository.delete(this.table.getSelectedLines());
        this.table.resetSelectedLines();
        this.refreshTable();
    }

    @Override
    public void edit() {
        DutiesFormular formular = new DutiesFormular(this, () -> this.closeFormular());
        formular.setData(this.table.loadSelectedLine());
        this.table.resetSelectedLines();
        this.frame.showFormularPane(formular);
    }

    @Override
    public void search(String nText) {
        this.table.refresh(this.repository.search(nText));
    }

    public void refreshTable(){
        this.table.refresh();
    }

    @Override
    public void safe(Model nValues) {
        this.repository.safe(nValues);
        this.refreshTable();
    }

    @Override
    public void setTable(Table nTable) {
        this.table = nTable;
    }

    public void addSelectedLine(int nId){
        this.table.addSelectedLine(nId);
    }

    public void removeSelectedLine(int nId){
        this.table.removeSelectedLine(nId);
    }

    @Override
    public void setFrame(Frame nFrame) {
        this.frame = nFrame;
    }

    @Override
    public void openFormular() {
        this.frame.showFormularPane(new DutiesFormular(this, () -> this.closeFormular()));
    }

    @Override
    public void closeFormular() {
        this.frame.hideFormularPane();
    }

    @Override 
    public void showModel(int nLineId){
        this.frame.showFormularPane(new ViewDutie(this, () -> this.closeFormular(), ((Table) this.table).loadLine(nLineId)));
    }
}
