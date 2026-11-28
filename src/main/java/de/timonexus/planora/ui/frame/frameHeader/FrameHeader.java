package de.timonexus.planora.ui.frame.frameHeader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.enums.Colors;

public class FrameHeader extends JPanel implements Component{

    // attributes
    private Point dragPoint;
    private FrameService frameService;

    // constructor
    public FrameHeader(FrameService nFrameService){
        this.frameService = nFrameService;
    }

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setBackground(Colors.BASE.getColor());
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
        addDragListener();
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

    private void addDragListener() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                dragPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragPoint = null;
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (frameService.isMaximized() || dragPoint == null) {
                    return;
                }

                Point location = frameService.getLocation();

                frameService.setLocation(new Point(
                    location.x + e.getX() - dragPoint.x,
                    location.y + e.getY() - dragPoint.y
                ));
            }
        });
    }
    
}
