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
	public Model[] loadAll() {
        return this.repository.loadAll();
	}

	@Override
	public void refreshTable() {
	}

	@Override
	public void setTable(Table nTable) {
	}

	@Override
	public void addSelectedLine(int nId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addSelectedLine'");
	}

	@Override
	public void removeSelectedLine(int nId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeSelectedLine'");
	}

	@Override
	public void safe(Model nValues) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'safe'");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	public void delete(List<Integer> nIds){
		this.repository.delete(nIds);
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'edit'");
	}

	@Override
	public void search(String nText) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'search'");
	}

	@Override
	public void showModel(int nLineId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'showModel'");
	}

	@Override
	public void setFrame(Frame nFrame) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setFrame'");
	}

	@Override
	public void openFormular() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'openFormular'");
	}

	@Override
	public void closeFormular() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'closeFormular'");
	}
    
}
