package de.timonexus.planora.service.Duties;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.DutiesRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.table.Table;

public class DutiesService implements DefaultPageService{

    // attributes
    private final Repository repository;
    private final DefaultPage page;
    private Frame frame;
    private Table table;

    // constructor
    public DutiesService(DefaultPage nPage){
        this.repository = new DutiesRepository();
        this.page = nPage;
    }

	@Override
	public Model[] loadAll() {
        return this.repository.loadAll();
	}

    public void refreshTable(){
        this.table.refresh();
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
        this.frame.showFormularPane(null);
    }

    @Override
    public void closeFormular() {
        this.frame.hideFormularPane();
    }
}
