package de.timonexus.planora.ui.frame.frameHeader.windowButtons;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.ComponentContainer;

public class WindowButtons extends JPanel implements Component, ComponentContainer{

    @Override
    public void designComponent() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(200, 80));
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
        super.add((JComponent) nComponent);
    }
    
}
