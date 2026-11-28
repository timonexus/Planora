package de.timonexus.planora.service.frame.header.buttonServices;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Icons;

public class MinimizeService extends FrameButtonService{

    // constructor
    public MinimizeService(FrameService nFrameService){
        super(nFrameService, Icons.WINDOW_MINIMIZE_DARK.getIconLabel(), Colors.APPLE_MINIMIZE.getColor());
    }

    @Override
    public void execute() {
        this.frameService.minimize();
    }
        
}
