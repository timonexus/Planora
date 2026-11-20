
package de.timonexus.planora.ui.frame.frameHeader;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class FrameResizer {

    private final JFrame frame;
    private final JLayeredPane layeredPane;

    private final int borderSize = 6;

    private JPanel north;
    private JPanel south;
    private JPanel east;
    private JPanel west;

    private JPanel northEast;
    private JPanel northWest;
    private JPanel southEast;
    private JPanel southWest;

    private final Runnable onResize;
    private final Timer resizeTimer;

    private Rectangle startBounds;
    private Point startMousePosition;

    private ResizeDirection currentDirection;

    private enum ResizeDirection {
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NORTH_EAST,
        NORTH_WEST,
        SOUTH_EAST,
        SOUTH_WEST
    }

    public FrameResizer(JFrame nFrame, Runnable nOnResize) {
        this.frame = nFrame;
        this.onResize = nOnResize;

        this.layeredPane = frame.getRootPane().getLayeredPane();

        this.resizeTimer = new Timer(150, e -> {
            this.onResize.run();
        });

        this.resizeTimer.setRepeats(false);

        createResizePanels();
        addResizePanels();

        updateResizePanels();

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateResizePanels();
                resizeTimer.restart();
            }
        });
    }

    private void createResizePanels() {
        north = createPanel(ResizeDirection.NORTH);
        south = createPanel(ResizeDirection.SOUTH);
        east = createPanel(ResizeDirection.EAST);
        west = createPanel(ResizeDirection.WEST);

        northEast = createPanel(ResizeDirection.NORTH_EAST);
        northWest = createPanel(ResizeDirection.NORTH_WEST);
        southEast = createPanel(ResizeDirection.SOUTH_EAST);
        southWest = createPanel(ResizeDirection.SOUTH_WEST);
    }

    private JPanel createPanel(ResizeDirection direction) {
        JPanel panel = new JPanel();

        panel.setOpaque(false);
        panel.setCursor(new Cursor(getCursor(direction)));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startResize(e, direction);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                startBounds = null;
                startMousePosition = null;
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                resizeWindow(e);
            }
        });

        return panel;
    }

    private void addResizePanels() {
        layeredPane.add(north, JLayeredPane.DRAG_LAYER);
        layeredPane.add(south, JLayeredPane.DRAG_LAYER);
        layeredPane.add(east, JLayeredPane.DRAG_LAYER);
        layeredPane.add(west, JLayeredPane.DRAG_LAYER);

        layeredPane.add(northEast, JLayeredPane.DRAG_LAYER);
        layeredPane.add(northWest, JLayeredPane.DRAG_LAYER);
        layeredPane.add(southEast, JLayeredPane.DRAG_LAYER);
        layeredPane.add(southWest, JLayeredPane.DRAG_LAYER);
    }

    private void updateResizePanels() {
        int width = layeredPane.getWidth();
        int height = layeredPane.getHeight();
        int size = borderSize;

        north.setBounds(size, 0, width - 2 * size, size);
        south.setBounds(size, height - size, width - 2 * size, size);

        west.setBounds(0, size, size, height - 2 * size);
        east.setBounds(width - size, size, size, height - 2 * size);

        northWest.setBounds(0, 0, size, size);
        northEast.setBounds(width - size, 0, size, size);

        southWest.setBounds(0, height - size, size, size);
        southEast.setBounds(width - size, height - size, size, size);

        layeredPane.repaint();
    }

    private void startResize(MouseEvent e, ResizeDirection direction) {
        if (frame.getExtendedState() != JFrame.NORMAL) {
            return;
        }

        currentDirection = direction;
        startBounds = frame.getBounds();
        startMousePosition = e.getLocationOnScreen();
    }

    private void resizeWindow(MouseEvent e) {
        if (startBounds == null || startMousePosition == null) {
            return;
        }

        Point currentMouse = e.getLocationOnScreen();

        int deltaX = currentMouse.x - startMousePosition.x;
        int deltaY = currentMouse.y - startMousePosition.y;

        int x = startBounds.x;
        int y = startBounds.y;
        int width = startBounds.width;
        int height = startBounds.height;

        Dimension minimum = frame.getMinimumSize();

        switch (currentDirection) {
            case NORTH:
                int newNorthHeight = height - deltaY;

                if (newNorthHeight >= minimum.height) {
                    y += deltaY;
                    height = newNorthHeight;
                } else {
                    y += height - minimum.height;
                    height = minimum.height;
                }
                break;

            case SOUTH:
                height = Math.max(minimum.height, height + deltaY);
                break;

            case EAST:
                width = Math.max(minimum.width, width + deltaX);
                break;

            case WEST:
                int newWestWidth = width - deltaX;

                if (newWestWidth >= minimum.width) {
                    x += deltaX;
                    width = newWestWidth;
                } else {
                    x += width - minimum.width;
                    width = minimum.width;
                }
                break;

            case NORTH_EAST:
                width = Math.max(minimum.width, width + deltaX);

                int newNorthEastHeight = height - deltaY;

                if (newNorthEastHeight >= minimum.height) {
                    y += deltaY;
                    height = newNorthEastHeight;
                } else {
                    y += height - minimum.height;
                    height = minimum.height;
                }
                break;

            case NORTH_WEST:
                int newNorthWestWidth = width - deltaX;
                int newNorthWestHeight = height - deltaY;

                if (newNorthWestWidth >= minimum.width) {
                    x += deltaX;
                    width = newNorthWestWidth;
                } else {
                    x += width - minimum.width;
                    width = minimum.width;
                }

                if (newNorthWestHeight >= minimum.height) {
                    y += deltaY;
                    height = newNorthWestHeight;
                } else {
                    y += height - minimum.height;
                    height = minimum.height;
                }
                break;

            case SOUTH_EAST:
                width = Math.max(minimum.width, width + deltaX);
                height = Math.max(minimum.height, height + deltaY);
                break;

            case SOUTH_WEST:
                int newSouthWestWidth = width - deltaX;

                if (newSouthWestWidth >= minimum.width) {
                    x += deltaX;
                    width = newSouthWestWidth;
                } else {
                    x += width - minimum.width;
                    width = minimum.width;
                }

                height = Math.max(minimum.height, height + deltaY);
                break;
        }

        frame.setBounds(x, y, width, height);
    }

    private int getCursor(ResizeDirection direction) {
        switch (direction) {
            case NORTH:
                return Cursor.N_RESIZE_CURSOR;
            case SOUTH:
                return Cursor.S_RESIZE_CURSOR;
            case EAST:
                return Cursor.E_RESIZE_CURSOR;
            case WEST:
                return Cursor.W_RESIZE_CURSOR;
            case NORTH_EAST:
                return Cursor.NE_RESIZE_CURSOR;
            case NORTH_WEST:
                return Cursor.NW_RESIZE_CURSOR;
            case SOUTH_EAST:
                return Cursor.SE_RESIZE_CURSOR;
            case SOUTH_WEST:
                return Cursor.SW_RESIZE_CURSOR;
            default:
                return Cursor.DEFAULT_CURSOR;
        }
    }
}
