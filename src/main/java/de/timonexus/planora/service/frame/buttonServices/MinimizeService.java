package de.timonexus.planora.service.frame.buttonServices;

import java.awt.Color;

import javax.swing.JLabel;

import de.timonexus.planora.service.services.FrameService;

public class MinimizeService extends FrameButtonService{

    // constructor
    public MinimizeService(FrameService nFrameService, JLabel nIconLabel, Color nButtonColor){
        super(nFrameService, nIconLabel, nButtonColor);
    }

    @Override
    public void execute() {
        System.out.println("Minimize Frame");
    }
        
}
