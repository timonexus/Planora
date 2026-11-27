package de.timonexus.planora.ui.frame;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.LayeredPane;
import de.timonexus.planora.ui.frame.frameHeader.FrameHeader;
import de.timonexus.planora.ui.frame.frameHeader.FrameResizer;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;

public class PlanoraFrameV2 implements FrameV2{

    // attributes
    private final Component sidebar;
    private final Component header;
    private final LayeredPane formularPane;
    private final FrameResizer frameResizer;

    // constructor
    public PlanoraFrame(){
        this.sidebar = new PlanoraSidebar(null);
        this.header = new FrameHeader(null);
        
    }

    @Override
    public void skinFrame() {
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void setPage(DefaultPage nDefaultPage) {
    }

    @Override
    public void refresh() {
    }

    @Override
    public LayeredPane getLayeredPage() {
        return null;
    }
    
}
