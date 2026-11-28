package de.timonexus.planora.service.frame.header;

import java.awt.BorderLayout;

import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.frameHeaderV2.FrameHeader;

public class PlanoraFrameHeaderService implements ComponentService{

    // attributes
    private final Component header;

    private final ComponentService buttonService;

    // constructor
    public PlanoraFrameHeaderService(FrameService nFrameService){
        this.header = new FrameHeader();
        this.buttonService = new ButtonsService(nFrameService);
    }

    @Override
    public void prepareComponent() {
        this.header.prepareComponent();
        this.buttonService.prepareComponent();

        this.add(this.buttonService.getComponent(), BorderLayout.WEST);
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
        this.header.add(nComponent, nBorderLayout);
    }

    @Override
    public Component getComponent() {
        return this.header;
    }
}
