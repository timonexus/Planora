package de.timonexus.planora.ui.pages;

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
}
