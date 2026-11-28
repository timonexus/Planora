package de.timonexus.planora.ui.frame.frameHeaderV2.windowButtons;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.timonexus.planora.service.services.ButtonService;
import de.timonexus.planora.ui.Component;

public class WindowButton extends JPanel implements Component {

    // attributes
    private final ButtonService buttonService;
    private final JLabel iconLabel;

    private boolean hovered;

    // constructor
    public WindowButton(ButtonService nButtonService) {
        this.buttonService = nButtonService;
        this.iconLabel = this.buttonService.getIconLabel();
    }

    @Override
    public void designComponent() {
        this.setPreferredSize(new Dimension(30, 30));
        this.setMinimumSize(new Dimension(30, 30));
        this.setMaximumSize(new Dimension(30, 30));

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.iconLabel.setVisible(false);
        this.add(this.iconLabel);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                buttonService.execute();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                iconLabel.setVisible(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                iconLabel.setVisible(false);
                repaint();
            }
        });
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
        this.revalidate();
        this.repaint();
    }

    @Override
    public void add(Component nComponent, String nBorderLayout) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int size = hovered ? 16 : 12;

        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2.setColor(buttonService.getButtonColor());
        g2.fillOval(x, y, size, size);

        g2.dispose();
    }
}