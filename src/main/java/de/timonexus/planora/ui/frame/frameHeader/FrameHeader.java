package de.timonexus.planora.ui.frame.frameHeader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.timonexus.planora.utils.enums.Colors;

public class FrameHeader extends JPanel {

    private final JFrame frame;

    private Point dragPoint;

    private boolean maximized;

    public FrameHeader(JFrame nFrame) {
        this.frame = nFrame;

        this.designComponent();
    }

    private void designComponent() {
        this.setLayout(new BorderLayout());

        this.setBackground(Colors.BASE.getColor());
        this.setPreferredSize(new java.awt.Dimension(0, 40));

        this.add(createWindowButtons(), BorderLayout.WEST);
        //this.add(createTitle(), BorderLayout.CENTER);

        this.addDragListener();
    }

    private JPanel createWindowButtons() {
        JPanel panel = new JPanel(new FlowLayout(
            FlowLayout.LEFT,
            8,
            8
        ));

        panel.setOpaque(false);

        WindowButton closeButton = new WindowButton(
            new Color(255, 95, 87), 0
        );

        WindowButton minimizeButton = new WindowButton(
            new Color(254, 188, 46), 1
        );

        WindowButton maximizeButton = new WindowButton(
            new Color(40, 200, 64), 2
        );

        closeButton.addActionListener(e -> frame.dispose());

        //minimizeButton.addActionListener(e ->
            //frame should be minimized
        //);

        maximizeButton.addActionListener(e -> toggleMaximize());

        panel.add(closeButton);
        panel.add(minimizeButton);
        panel.add(maximizeButton);

        return panel;
    }

    private void toggleMaximize() {
        if (maximized) {
            frame.setExtendedState(JFrame.NORMAL);
        } else {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        maximized = !maximized;
    }

    private void addDragListener() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                dragPoint = e.getPoint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    toggleMaximize();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (maximized || dragPoint == null) {
                    return;
                }

                Point location = frame.getLocation();

                frame.setLocation(
                    location.x + e.getX() - dragPoint.x,
                    location.y + e.getY() - dragPoint.y
                );
            }
        });
    }
}