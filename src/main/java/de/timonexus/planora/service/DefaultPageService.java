package de.timonexus.planora.service;

import de.timonexus.planora.models.Model;

public interface DefaultPageService {

    Model[] loadAll();

    public void refreshTable();
    
}
