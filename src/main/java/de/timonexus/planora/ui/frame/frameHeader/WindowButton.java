package de.timonexus.planora.ui.frame.frameHeader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class WindowButton extends JButton {

    private final Color buttonColor;
    private final int buttonType;

    private boolean hovered;

    public WindowButton(Color nColor, int nType) {
        this.buttonColor = nColor;
        this.buttonType = nType;

        this.setPreferredSize(new Dimension(16, 24));
        this.setMinimumSize(new Dimension(16, 24));
        this.setMaximumSize(new Dimension(16, 24));

        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
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

        g2.setColor(buttonColor);
        g2.fillOval(x, y, size, size);

        if (hovered) {
            g2.setColor(new Color(0, 0, 0, 150));
            g2.setStroke(new java.awt.BasicStroke(
                1.4f,
                java.awt.BasicStroke.CAP_ROUND,
                java.awt.BasicStroke.JOIN_ROUND
            ));

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            if (buttonType == 0) {
                // Schließen
                g2.drawLine(centerX - 3, centerY - 3,
                            centerX + 3, centerY + 3);
                g2.drawLine(centerX + 3, centerY - 3,
                            centerX - 3, centerY + 3);

            } else if (buttonType == 1) {
                // Minimieren
                g2.drawLine(centerX - 3, centerY,
                            centerX + 3, centerY);

            } else if (buttonType == 2) {
                // Maximieren
                g2.drawLine(centerX - 3, centerY - 3,
                            centerX - 1, centerY - 3);
                g2.drawLine(centerX - 3, centerY - 3,
                            centerX - 3, centerY - 1);

                g2.drawLine(centerX + 3, centerY + 3,
                            centerX + 1, centerY + 3);
                g2.drawLine(centerX + 3, centerY + 3,
                            centerX + 3, centerY + 1);
            }
        }

        g2.dispose();
    }
}