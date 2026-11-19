package de.timonexus.planora.ui.pages;

import de.timonexus.planora.ui.frame.Frame;

public interface DefaultPage {
    
    default void preparePage(){
        skinPage();
        prepareComponents();
        addComponents();
    }

    void skinPage();
    void prepareComponents();
    void addComponents();
    public void refresh();

    public void setFrame(Frame nFrame);
}
