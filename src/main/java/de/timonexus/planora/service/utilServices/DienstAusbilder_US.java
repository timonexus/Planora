package de.timonexus.planora.service.utilServices;

import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.repositorys.utilRepositorys.DienstAusbilder_UR;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.table.Table;

public class DienstAusbilder_US implements DefaultPageService{

    // attributes
    private final Repository repository;
	private Table table;

    // constructor
    public DienstAusbilder_US(){
        this.repository = new DienstAusbilder_UR();
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
	public void addAllLines() {
	}

	@Override
	public void removeAllLines() {
	}

	@Override
	public void addSelectedLine(int nId) {
	}

	@Override
	public void removeSelectedLine(int nId) {
	}

	@Override
	public void safe(Model nValues) {
	}

	@Override
	public void delete() {
	}

	public void delete(List<Integer> nIds){
		this.repository.delete(nIds);
	}

	@Override
	public void edit() {
	}

	@Override
	public void search(String nText) {
	}

	@Override
	public void showModel(int nLineId) {
	}

	@Override
	public void setFrame(Frame nFrame) {
	}

	@Override
	public void openFormular() {
	}

	@Override
	public void closeFormular() {
	}

	public void change(int nLineId, int nFieldId){
		DienstAusbilder_UM model = (DienstAusbilder_UM) ((DienstAusbilder_UR) this.repository).loadAllId(nLineId)[0];

		switch (nFieldId) {
			case 1:
				model.setParticipationYounger(changeBool(model.isParticipationYounger()));
				break;
			case 2:
				model.setParticipationOlder(changeBool(model.isParticipationOlder()));
				break;
			case 3:
				model.setParticipationWhole(changeBool(model.isParticipationWhole()));
				break;
		
			default:
				break;
		}

		this.repository.safe(model);
	}

	private boolean changeBool(boolean value) {
		return !value;
	}
    
}
