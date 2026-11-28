package de.timonexus.planora.service.frame;

import java.awt.BorderLayout;
import java.awt.Point;

import de.timonexus.planora.service.frame.header.PlanoraFrameHeaderService;
import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.frame.PlanoraFrame;

public class PlanoraFrameService implements FrameService{

    // attributes
    private final Frame frame;

    private final ComponentService header;

    // constructor
    public PlanoraFrameService(){
        this.frame = new PlanoraFrame();

        this.header = new PlanoraFrameHeaderService(this);
    }

    @Override
    public void prepareComponent() {
        this.frame.prepareFrame();
        this.header.prepareComponent();
        this.frame.add(this.header.getComponent(), BorderLayout.NORTH);
    }

    @Override 
    public void isVisible(boolean isVisible){
        this.frame.setVisible(isVisible);
    }

    @Override
    public void close() {
        this.frame.close();
    }

    @Override
    public void maximize() {
        this.frame.maximize();
    }

    @Override
    public void minimize() {
        this.frame.minimize();
    }


    @Override
    public void add(Component nComponent, String nBorderLayout) {
        this.frame.add(nComponent, nBorderLayout);
    }

    @Override
    public boolean isMaximized() {
        return this.frame.isMaximized();
    }
    @Override
    public void setLocation(Point nPoint) {
        this.frame.setLocation(nPoint);
    }
    @Override
    public Point getLocation() {
        return this.frame.getLocation();
    }
}
