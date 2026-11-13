package de.timonexus.planora.ui.frame;

import java.awt.Color;

import javax.swing.JFrame;

public class PlanoraFrame extends JFrame implements Frame{

    // attributes

    // constructor

    @Override
    public void skinFrame() {
        this.setTitle((String) FrameValues.TITLE.getValue());
        this.setSize((int) FrameValues.WIDTH.getValue(), (int) FrameValues.HEIGHT.getValue());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground((Color) FrameValues.BACKGROUNDCOLOR.getValue());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void addComponents() {}
    
}
