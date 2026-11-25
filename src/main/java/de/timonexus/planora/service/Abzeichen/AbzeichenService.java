package de.timonexus.planora.service.Abzeichen;

import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.AbzeichenRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.ToastSystem.ToastType;
import de.timonexus.planora.ui.formulars.Abzeichen.AbzeichenAnlegen.AbzeichenAnlegenFormular;
import de.timonexus.planora.ui.formulars.Deletion.AskingForDeletion;
import de.timonexus.planora.ui.formulars.Deletion.DeletionNotice;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.table.Table;

public class AbzeichenService implements DefaultPageService{

    // attributes
    private final Repository repository;
    private Frame frame;
    private Table table;

    // constructor
    public AbzeichenService(){
        this.repository = new AbzeichenRepository();
    }

    @Override
    public Model[] loadAll(int nId) {
        return this.repository.loadAll(nId);
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
    public void addAllLines() {
        this.table.addAllLines();
    }

    @Override
    public void removeAllLines() {
        this.table.resetSelectedLines();
    }

    @Override
    public void safe(Model nValues) {
       this.repository.safe(nValues);
       this.refreshTable();
       this.frame.showToast(ToastType.SUCCESS, "Das Abzeichen wurde erfolgreich erstellt!");
    }

    @Override
    public List<Integer> getSelectedLines() {
        return this.table.getSelectedLines();
    }

    @Override
    public void delete() {
        DeletionNotice deletionNotice = new DeletionNotice(this, "Abzeichen");
        deletionNotice.prepareComponent();

		this.frame.showFormularPane(deletionNotice);
    }

    public void deleteInDatabase(){
        int numberOfDeletions = this.table.getSelectedLines().size();
        if(this.table.getSelectedLines().contains(-1)) numberOfDeletions--;
        this.repository.delete(this.table.getSelectedLines());
        this.table.resetSelectedLines();
        this.closeFormular();
        this.refreshTable();

        this.frame.showToast(ToastType.SUCCESS, numberOfDeletions + " wurden erfolgreich gelöscht.");
    }

    @Override
    public void edit() {
        AbzeichenAnlegenFormular formular = new AbzeichenAnlegenFormular(this, this::closeFormular);
        formular.setData(this.table.loadSelectedLine());
        formular.prepareComponent();

        this.table.resetSelectedLines();
        this.frame.showFormularPane(formular);
    }

    @Override
    public void search(String nText) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public void showModel(int nLineId) {
        
    }

    @Override
    public void setFrame(Frame nFrame) {
       this.frame = nFrame;
    }

    @Override
    public void openFormular() {
        AbzeichenAnlegenFormular abzeichenAnlegenFormular = new AbzeichenAnlegenFormular(this, this::closeFormular);
        abzeichenAnlegenFormular.prepareComponent();
        this.frame.showFormularPane(abzeichenAnlegenFormular);
    }

    @Override
    public void closeFormular() {
        this.frame.hideFormularPane();
        this.table.refresh();
    }
    
}
