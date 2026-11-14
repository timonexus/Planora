package de.timonexus.planora.ui.frame;

import de.timonexus.planora.ui.pages.DefaultPage;

public interface Frame{
    
    default void prepareFrame(){
        skinFrame();
        prepareComponents();
        addComponents();
    };
    void skinFrame();
    void prepareComponents();
    void addComponents();

    public void setPage(DefaultPage nDefaultPage);
    public void refresh();

}
