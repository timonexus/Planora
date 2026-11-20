
package de.timonexus.planora.ui.formulars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

import de.timonexus.planora.ui.Component;

public class LayeredPane extends JLayeredPane implements Component {

    // attributes
    private JComponent formular;

    // constructor
    public LayeredPane() {
        this.formular = null;
    }

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
        // Das Formular wird erst bei Bedarf hinzugefügt.
    }

    @Override
    public void prepareComponents() {
        // Keine zusätzlichen Komponenten notwendig.
    }

    @Override
    public void addComponents() {
        // Keine zusätzlichen Komponenten notwendig.
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

        this.removeAll();

        this.formular = nFormular;

        this.add(
            this.formular,
            JLayeredPane.DEFAULT_LAYER
        );

        this.revalidate();
        this.repaint();
    }

    public void removeFormular() {

        this.removeAll();

        this.formular = null;

        this.revalidate();
        this.repaint();
    }

    // --------------------------------------------------
    // Layout
    // --------------------------------------------------

    @Override
    public void doLayout() {

        if (this.formular == null) {
            return;
        }

        Dimension preferredSize =
            this.formular.getPreferredSize();

        int width = Math.min(
            preferredSize.width,
            this.getWidth() - 40
        );

        int height = Math.min(
            preferredSize.height,
            this.getHeight() - 40
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

        g.setColor(new Color(0, 0, 0, 170));

        g.fillRect(0,0, this.getWidth(),this.getHeight());
    }
}
