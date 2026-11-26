package de.timonexus.planora.ui.frame;

import javax.swing.JLayeredPane;

import de.timonexus.planora.ui.ToastSystem.ToastType;
import de.timonexus.planora.ui.formulars.Formular;
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

    public void showFormularPane(Formular nFormular);
    public void hideFormularPane();

    public void showToast(ToastType type, String message);

    public JLayeredPane getLayeredPage();

}
