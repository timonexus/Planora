package de.timonexus.planora.service.frame;

import de.timonexus.planora.service.frame.buttonServices.CloseService;
import de.timonexus.planora.service.frame.buttonServices.MaximizeService;
import de.timonexus.planora.service.frame.buttonServices.MinimizeService;
import de.timonexus.planora.service.services.ButtonService;
import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.frameHeaderV2.FrameHeader;

public class PlanoraFrameHeaderService implements ComponentService{

    // attributes
    private final Component header;

    private final ButtonService close;
    private final ButtonService minimize;
    private final ButtonService maximize;

    // constructor
    public PlanoraFrameHeaderService(){
        this.header = new FrameHeader();

        this.close = new CloseService(null, null, null);
        this.minimize = new MinimizeService(null, null, null);
        this.maximize = new MaximizeService(null, null, null);
    }

    @Override
    public void prepareComponent() {
        this.header.prepareComponent();
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
        this.header.add(nComponent, nBorderLayout);
    }


    
}
