package de.timonexus.planora.service.frame.header.buttonServices;

import java.awt.Color;

import javax.swing.JLabel;

import de.timonexus.planora.service.services.ButtonService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.frameHeaderV2.windowButtons.WindowButton;

public abstract class FrameButtonService implements ButtonService{

    // attributes
    protected final FrameService frameService;

    private final Component button;

    private final JLabel iconLabel;
    private final Color buttonColor;

    // constructor
    public FrameButtonService(FrameService nFrameService, JLabel nIconLabel, Color nButtonColor){
        this.frameService = nFrameService;

        this.iconLabel = nIconLabel;
        this.buttonColor = nButtonColor;

        this.button = new WindowButton(this);
    }

    @Override
    public JLabel getIconLabel() {
        return this.iconLabel;
    }

    @Override
    public Color getButtonColor() {
        return this.buttonColor;
    }

    @Override
    public Component getButton() {
        this.button.prepareComponent();
        return this.button;
    }
}
