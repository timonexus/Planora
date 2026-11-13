package de.timonexus.planora.ui;

public interface Component {
    
    default void prepareComponent(){
        designComponent();
        prepareComponents();
        addComponents();
    }

    void designComponent();
    void prepareComponents();
    void addComponents();
}
