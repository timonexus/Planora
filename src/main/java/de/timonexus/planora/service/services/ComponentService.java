package de.timonexus.planora.service.services;

import de.timonexus.planora.ui.Component;

public interface ComponentService {
    
    void prepareComponent();
    void add(Component nComponent, String nBorderLayout);
    Component getComponent();
}
