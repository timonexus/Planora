package de.timonexus.planora.service.Duties;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.repositorys.DutiesRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.service.DefaultPageService;

public class DutiesService implements DefaultPageService{

    // attributes
    private final Repository repository;

    // constructor
    public DutiesService(){
        this.repository = new DutiesRepository();
    }

	@Override
	public Model[] loadAll() {
        return this.repository.loadAll();
	}
}
