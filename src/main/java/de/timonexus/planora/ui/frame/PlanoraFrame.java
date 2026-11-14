package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;

import javax.swing.*;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Logo;

public class PlanoraFrame extends JFrame implements Frame{

    // attributes
    private final Component sidebar;
    private DefaultPage page;

    // constructor
    public PlanoraFrame(){
        this.sidebar = new PlanoraSidebar(this);
        this.page = Pages.STARTSEITE.getPage();
    }

    @Override
    public void skinFrame() {
        this.setTitle((String) FrameValues.TITLE.getValue());
        this.setSize((int) FrameValues.WIDTH.getValue(), (int) FrameValues.HEIGHT.getValue());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Colors.BASE.getColor());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Logo.DEFAULT_LOGO.getImage());
        this.setLayout(new BorderLayout());
    }

    @Override 
    public void prepareComponents(){
        this.sidebar.prepareComponent();
        this.page.preparePage();
    }

    @Override
    public void addComponents() {
        this.add((JPanel)this.sidebar, BorderLayout.WEST);
        this.add((JPanel) this.page, BorderLayout.CENTER);
    }

    @Override 
    public void refresh(){
        this.repaint();
    }

    // getter
    public Component getSidebar() {
        return sidebar;
    }
    public DefaultPage getPage() {
        return page;
    }

    // setter
    @Override 
    public void setPage(DefaultPage page) {
        this.page = page;
        this.refresh();
    }
    
}
