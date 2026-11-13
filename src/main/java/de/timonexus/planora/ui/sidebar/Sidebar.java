package de.timonexus.planora.ui.sidebar;

public interface Sidebar {
    
    default void prepareSidebar(){
        designSidebar();
        fillSidebar();
        addComponents();
    }

    void designSidebar();
    void fillSidebar();
    void addComponents();
}
