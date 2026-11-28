package de.timonexus.planora.service.frame;

import java.awt.BorderLayout;

import de.timonexus.planora.service.frame.header.PlanoraFrameHeaderService;
import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.FrameV2;
import de.timonexus.planora.ui.frame.PlanoraFrameV2;

public class PlanoraFrameService implements FrameService{

    // attributes
    private final FrameV2 frame;

    private final ComponentService header;

    // constructor
    public PlanoraFrameService(){
        this.frame = new PlanoraFrameV2();

        this.header = new PlanoraFrameHeaderService(this);
    }

    @Override
    public void prepareComponent() {
        this.frame.prepareFrame();
        this.header.prepareComponent();
        this.frame.add(this.header.getComponent(), BorderLayout.NORTH);
    }

    @Override 
    public void isVisible(boolean isVisible){
        this.frame.setVisible(isVisible);
    }

    @Override
    public void close() {
        this.frame.close();
    }

    @Override
    public void maximize() {
        this.frame.maximize();
    }

    @Override
    public void minimize() {
        this.frame.minimize();
    }


    @Override
    public void add(Component nComponent, String nBorderLayout) {
        this.frame.add(nComponent, nBorderLayout);
    }
}
