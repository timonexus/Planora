package de.timonexus.planora.ui.frame.frameHeaderV2.windowButtons;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;

public class WindowButtons extends JPanel implements Component{

    @Override
    public void designComponent() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
        this.setOpaque(false);
    }

    @Override
    public void skinParts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'skinParts'");
    }

    @Override
    public void addParts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addParts'");
    }

    @Override
    public void prepareComponents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepareComponents'");
    }

    @Override
    public void addComponents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComponents'");
    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refresh'");
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
        super.add((JComponent) nComponent);
    }
    
}
