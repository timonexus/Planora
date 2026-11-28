package de.timonexus.planora.service.frame.buttonServices;

import java.awt.Color;

import javax.swing.JLabel;

import de.timonexus.planora.service.services.ButtonService;
import de.timonexus.planora.service.services.FrameService;

public abstract class FrameButtonService implements ButtonService{

    // attributes
    private final FrameService frameService;

    private final JLabel iconLabel;
    private final Color buttonColor;

    // constructor
    public FrameButtonService(FrameService nFrameService, JLabel nIconLabel, Color nButtonColor){
        this.frameService = nFrameService;

        this.iconLabel = nIconLabel;
        this.buttonColor = nButtonColor;
    }

    @Override
    public JLabel getIconLabel() {
        return this.iconLabel;
    }

    @Override
    public Color getButtonColor() {
        return this.buttonColor;
    }
}
