package de.timonexus.planora.service.Duties;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.DutiesRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.pages.DefaultPage;

public class DutiesService implements DefaultPageService{

    // attributes
    private final Repository repository;
    private final DefaultPage page;

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
        this.page.refresh();
    }
}
