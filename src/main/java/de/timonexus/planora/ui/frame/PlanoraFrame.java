package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;

import javax.swing.*;

import de.timonexus.planora.ui.Colors;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;
import de.timonexus.planora.ui.sidebar.Sidebar;

public class PlanoraFrame extends JFrame implements Frame{

    // attributes
    private final Sidebar sidebar;

    // constructor
    public PlanoraFrame(){
        this.sidebar = new PlanoraSidebar();
    }

    @Override
    public void skinFrame() {
        this.setTitle((String) FrameValues.TITLE.getValue());
        this.setSize((int) FrameValues.WIDTH.getValue(), (int) FrameValues.HEIGHT.getValue());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Colors.BASE.getColor());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    @Override 
    public void prepareComponents(){
        this.sidebar.prepareSidebar();
    }

    @Override
    public void addComponents() {
        this.add((JPanel)this.sidebar, BorderLayout.WEST);
    }
    
}
