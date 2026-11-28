package de.timonexus.planora.service.frame.header;

import de.timonexus.planora.service.frame.header.buttonServices.CloseService;
import de.timonexus.planora.service.frame.header.buttonServices.FrameButtonService;
import de.timonexus.planora.service.frame.header.buttonServices.MaximizeService;
import de.timonexus.planora.service.frame.header.buttonServices.MinimizeService;
import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.frameHeaderV2.windowButtons.WindowButtons;

public class ButtonsService implements ComponentService{

    // attributes
    private final Component windowButtons;

    private final FrameButtonService maximize, minimize, close;

    // constructor
    public ButtonsService(FrameService nFrameService){
        this.windowButtons = new WindowButtons();

        this.maximize = new MaximizeService(nFrameService);
        this.minimize = new MinimizeService(nFrameService);
        this.close = new CloseService(nFrameService);
    }

    @Override
    public void prepareComponent() {
        this.windowButtons.prepareComponent();

        this.add(this.close.getButton(), null);
        this.add(this.minimize.getButton(), null);
        this.add(this.maximize.getButton(), null);
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
        this.windowButtons.add(nComponent, nBorderLayout);
    }

    @Override
    public Component getComponent() {
        return this.windowButtons;
    }
    
}
