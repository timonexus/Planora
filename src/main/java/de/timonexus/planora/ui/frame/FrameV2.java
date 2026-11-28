package de.timonexus.planora.ui.frame;

import de.timonexus.planora.ui.Component;
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

    void setVisible(boolean isVisible);
    void maximize();
    void minimize();
    void close();

    void add(Component nComponent, String nBorderLayout);

    LayeredPane getLayeredPage();
}
