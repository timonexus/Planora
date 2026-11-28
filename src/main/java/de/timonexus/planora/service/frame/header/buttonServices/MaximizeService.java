package de.timonexus.planora.service.frame.header.buttonServices;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Icons;

public class MaximizeService extends FrameButtonService{

    // constructor
    public MaximizeService(FrameService nFrameService){
        super(nFrameService, Icons.WINDOW_MAXIMIZE_DARK.getIconLabel(), Colors.APPLE_MAXIMIZE.getColor());
    }

    @Override
    public void execute() {
        this.frameService.maximize();
    }
}
