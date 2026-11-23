package de.timonexus.planora.service.utilServices;

import java.util.List;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.repositorys.utilRepositorys.DienstAusbilder_UR;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.table.Table;

public class DienstAusbilder_US implements DefaultPageService{

    // attributes
    private final Repository repository;

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
	}

	@Override
	public void setTable(Table nTable) {
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
    
}
