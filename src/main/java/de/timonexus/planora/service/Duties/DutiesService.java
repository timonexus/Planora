package de.timonexus.planora.service.Duties;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.DutiesRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.repositorys.utilRepositorys.DienstAusbilder_UR;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.formulars.Deletion.AskingForDeletion;
import de.timonexus.planora.ui.formulars.Dienste.dienstAnlegen.DienstAnlegenFormular;
import de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen.DienstAnzeigenFormular;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.table.Table;

public class DutiesService implements DefaultPageService{

    // attributes
    private final Repository repository;
    private Frame frame;
    private Table table;

    private int dienstId;

    // constructor
    public DutiesService(DefaultPage nPage){
        this.repository = new DutiesRepository();
    }

	@Override
	public Model[] loadAll(int nId) {
        return this.repository.loadAll(nId);
	}

	@Override
	public void delete() {
		AskingForDeletion dialog = new AskingForDeletion(
			this.table.getSelectedLines().size(),

			// Bestätigen
			() -> {
				// Hier deine Löschlogik aufrufen
				deleteInDatabase();
			},

			// Abbrechen
			() -> {
				// Dialog schließen
				closeFormular();
			}
		);

		this.frame.showFormularPane(dialog);
	}

	public void deleteInDatabase(){
		Repository repository_DienstAusbilder = new DienstAusbilder_UR();
		repository_DienstAusbilder.delete(this.table.getSelectedLines());
        this.repository.delete(this.table.getSelectedLines());
        this.table.resetSelectedLines();
        this.refreshTable();
	}

    @Override
    public void edit() {
        DienstAnlegenFormular dienstAnlegenFormular = new DienstAnlegenFormular(this, () -> this.closeFormular());
        dienstAnlegenFormular.setData(this.table.loadSelectedLine());
        dienstAnlegenFormular.prepareComponent();
        this.table.resetSelectedLines();
        this.frame.showFormularPane(dienstAnlegenFormular);
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
        this.dienstId = this.repository.safe(nValues);
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
    public void addAllLines() {
        this.table.addAllLines();
    }

    @Override
    public void removeAllLines() {
        this.table.resetSelectedLines();
    }

    @Override
    public void setFrame(Frame nFrame) {
        this.frame = nFrame;
    }

    @Override
    public void openFormular() {
        DienstAnlegenFormular dienstAnlegenFormular = new DienstAnlegenFormular(this, () -> this.closeFormular());
        dienstAnlegenFormular.prepareComponent();
        this.frame.showFormularPane(dienstAnlegenFormular);
    }

    @Override
    public void closeFormular() {
        this.frame.hideFormularPane();
        this.table.refresh();
    }

    @Override 
    public void showModel(int nLineId){
        this.frame.showFormularPane(new DienstAnzeigenFormular(this, () -> this.closeFormular(), ((Table) this.table).loadLine(nLineId)));
    }

    public int getDienstId() {
        return dienstId;
    }
}
