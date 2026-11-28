package de.timonexus.planora.service.frame.header;

import de.timonexus.planora.service.frame.header.buttonServices.CloseService;
import de.timonexus.planora.service.frame.header.buttonServices.FrameButtonService;
import de.timonexus.planora.service.frame.header.buttonServices.MaximizeService;
import de.timonexus.planora.service.frame.header.buttonServices.MinimizeService;
import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.ComponentContainer;
import de.timonexus.planora.ui.frame.frameHeader.windowButtons.WindowButtons;

public class ButtonsService implements ComponentService{

    // attributes
    private final Component windowButtons;

    private final FrameButtonService maximize, minimize, close;

    // Constructor
    public ButtonsService(FrameService nFrameService) {
        this(
            new WindowButtons(),
            new MaximizeService(nFrameService),
            new MinimizeService(nFrameService),
            new CloseService(nFrameService)
        );
    }

    public ButtonsService(
            Component nWindowButtons,
            FrameButtonService nMaximize,
            FrameButtonService nMinimize,
            FrameButtonService nClose) {

        this.windowButtons = nWindowButtons;
        this.maximize = nMaximize;
        this.minimize = nMinimize;
        this.close = nClose;
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
        ((ComponentContainer) this.windowButtons).add(nComponent, nBorderLayout);
    }

    @Override
    public Component getComponent() {
        return this.windowButtons;
    }
    
}
