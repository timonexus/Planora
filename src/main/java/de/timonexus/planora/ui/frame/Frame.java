package de.timonexus.planora.ui.frame;

public interface Frame{
    
    default void prepareFrame(){
        skinFrame();
        addComponents();
    };
    void skinFrame();
    void addComponents();

}
