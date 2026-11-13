package de.timonexus.planora.ui.frame;

public interface Frame{
    
    default void prepareFrame(){
        skinFrame();
        prepareComponents();
        addComponents();
    };
    void skinFrame();
    void prepareComponents();
    void addComponents();

}
