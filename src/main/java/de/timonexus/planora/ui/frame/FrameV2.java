package de.timonexus.planora.ui.frame;

import de.timonexus.planora.ui.formulars.LayeredPane;
import de.timonexus.planora.ui.pages.DefaultPage;

public interface FrameV2 {

    default void prepareFrame(){
        skinFrame();
        prepareComponents();
        addComponents();
    }
    
    void skinFrame();
    void prepareComponents();
    void addComponents();

    void setPage(DefaultPage nDefaultPage);
    void refresh();

    LayeredPane getLayeredPage();
}
