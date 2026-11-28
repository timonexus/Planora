package de.timonexus.planora.ui.frame.frameHeaderV2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;

public class FrameHeader extends JPanel implements Component{

    // attributes
    private Point dragPoint;

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(0, 40));
    }

    @Override
    public void skinParts() {
    }

    @Override
    public void addParts() {
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void refresh() {
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
        super.add((JComponent) nComponent, nBorderLayout);
    }
    
}
