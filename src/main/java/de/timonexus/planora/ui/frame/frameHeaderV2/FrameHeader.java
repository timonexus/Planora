package de.timonexus.planora.ui.frame.frameHeaderV2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.enums.Colors;

public class FrameHeader extends JPanel implements Component{

    // attributes
    private Point dragPoint;
    private boolean maximized;

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());

        this.setBackground(Colors.BASE.getColor());
        this.setPreferredSize(new Dimension(0, 40));
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
        super.add((JComponent) nComponent, nBorderLayout);
    }
    
}
