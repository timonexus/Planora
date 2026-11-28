package de.timonexus.planora.service.frame;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.frame.FrameV2;
import de.timonexus.planora.ui.frame.PlanoraFrameV2;

public class PlanoraFrameService implements FrameService{

    // attributes
    private final FrameV2 frame;

    // constructor
    public PlanoraFrameService(){
        this.frame = new PlanoraFrameV2();
    }

    @Override 
    public void isVisible(boolean isVisible){
        this.frame.prepareFrame();
        this.frame.setVisible(isVisible);
    }


    
}
