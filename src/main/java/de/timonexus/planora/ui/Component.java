package de.timonexus.planora.ui;

public interface Component {
    
    default void prepareComponent(){
        designComponent();
        skinParts();
        addParts();
        prepareComponents();
        addComponents();

    }

    void designComponent();
    void skinParts();
    void addParts();
    void prepareComponents();
    void addComponents();
}
