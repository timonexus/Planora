
package de.timonexus.planora.ui.formulars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;

public class LayeredPane extends JLayeredPane implements Component {

    // --------------------------------------------------
    // Attributes
    // --------------------------------------------------

    private JComponent formular;

    private final JPanel toastLayer;

    private static final int FORMULAR_MARGIN = 40;

    private static final Color OVERLAY_COLOR =
        new Color(0, 0, 0, 170);


    // --------------------------------------------------
    // Constructor
    // --------------------------------------------------

    public LayeredPane() {

        this.formular = null;

        this.toastLayer = new JPanel(null);
        this.toastLayer.setOpaque(false);
    }


    // --------------------------------------------------
    // Component
    // --------------------------------------------------

    @Override
    public void designComponent() {

        this.setLayout(null);
        this.setOpaque(false);
    }

    @Override
    public void skinParts() {
        // Keine zusätzlichen Komponenten notwendig.
    }

    @Override
    public void addParts() {
        // Keine zusätzlichen Komponenten notwendig.
    }

    @Override
    public void prepareComponents() {
        // Keine zusätzlichen Komponenten notwendig.
    }

    @Override
    public void addComponents() {

        if (this.toastLayer.getParent() == this) {
            return;
        }

        // Toasts liegen hinter dem Formular.
        this.add(
            this.toastLayer,
            Integer.valueOf(JLayeredPane.PALETTE_LAYER)
        );
    }

    @Override
    public void refresh() {

        this.revalidate();
        this.repaint();
    }


    // --------------------------------------------------
    // Formular
    // --------------------------------------------------

    public void setFormular(JComponent nFormular) {

        if (nFormular == null) {
            return;
        }

        this.removeFormular();

        this.formular = nFormular;

        this.add(
            this.formular,
            Integer.valueOf(JLayeredPane.DEFAULT_LAYER)
        );

        this.moveToFront(this.formular);

        this.refresh();
    }

    public void removeFormular() {

        if (this.formular == null) {
            return;
        }

        this.remove(this.formular);

        this.formular = null;

        this.refresh();
    }

    public boolean hasFormular() {

        return this.formular != null;
    }

    public JComponent getFormular() {

        return this.formular;
    }


    // --------------------------------------------------
    // Toasts
    // --------------------------------------------------

    public JPanel getToastLayer() {

        return this.toastLayer;
    }


    // --------------------------------------------------
    // Layout
    // --------------------------------------------------

    @Override
    public void doLayout() {

        this.layoutToastLayer();
        this.layoutFormular();
    }

    private void layoutToastLayer() {

        this.toastLayer.setBounds(
            0,
            0,
            this.getWidth(),
            this.getHeight()
        );
    }

    private void layoutFormular() {

        if (this.formular == null) {
            return;
        }

        Dimension preferredSize =
            this.formular.getPreferredSize();

        int availableWidth = Math.max(
            0,
            this.getWidth() - FORMULAR_MARGIN
        );

        int availableHeight = Math.max(
            0,
            this.getHeight() - FORMULAR_MARGIN
        );

        int width = Math.min(
            preferredSize.width,
            availableWidth
        );

        int height = Math.min(
            preferredSize.height,
            availableHeight
        );

        int x = (this.getWidth() - width) / 2;
        int y = (this.getHeight() - height) / 2;

        this.formular.setBounds(
            x,
            y,
            width,
            height
        );
    }


    // --------------------------------------------------
    // Background
    // --------------------------------------------------

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (!this.hasFormular()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(OVERLAY_COLOR);

        g2.fillRect(
            0,
            0,
            this.getWidth(),
            this.getHeight()
        );

        g2.dispose();
    }


    // --------------------------------------------------
    // Visibility
    // --------------------------------------------------

    public boolean hasToasts() {

        return this.toastLayer.getComponentCount() > 0;
    }

    public void updateVisibility() {

        this.setVisible(
            this.hasFormular() || this.hasToasts()
        );
    }
}
