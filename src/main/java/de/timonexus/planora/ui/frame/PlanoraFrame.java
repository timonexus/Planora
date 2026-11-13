package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;

import javax.swing.*;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;
import de.timonexus.planora.utils.Colors;

public class PlanoraFrame extends JFrame implements Frame{

    // attributes
    private final Component sidebar;

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
        this.sidebar.prepareComponent();
    }

    @Override
    public void addComponents() {
        this.add((JPanel)this.sidebar, BorderLayout.WEST);
    }
    
}
