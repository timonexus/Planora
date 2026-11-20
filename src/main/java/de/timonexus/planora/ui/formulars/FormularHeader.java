
package de.timonexus.planora.ui.formulars;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;
import de.timonexus.planora.utils.enums.Icons;

public class FormularHeader extends JPanel {

    // attributes
    private final JPanel labelPanel;
    private final JLabel labelLabel;

    private final JPanel iconPanel;
    private final JLabel iconLabel;

    private final Runnable onClose;

    // constructor
    public FormularHeader(String nTitle, Runnable nOnClose) {

        this.labelPanel = new JPanel();
        this.labelLabel = new JLabel(nTitle);

        this.iconPanel = new JPanel();
        this.iconLabel = Icons.CLOSE_BRIGHT.getIconLabel();

        this.onClose = nOnClose;

        this.prepareComponent();
    }

    // --------------------------------------------------
    // Preparation
    // --------------------------------------------------

    private void prepareComponent() {

        this.skinComponent();

        this.skinLabelPanel();
        this.skinLabelLabel();

        this.skinIconPanel();
        this.skinIconLabel();

        this.addComponents();
    }

    // --------------------------------------------------
    // Component
    // --------------------------------------------------

    private void skinComponent() {

        this.setOpaque(false);

        this.setPreferredSize(
            new Dimension(0, 40)
        );

        this.setLayout(
            new BorderLayout()
        );
    }

    // --------------------------------------------------
    // Label
    // --------------------------------------------------

    private void skinLabelPanel() {

        this.labelPanel.setOpaque(false);

        this.labelPanel.setLayout(
            new BorderLayout()
        );
    }

    private void skinLabelLabel() {

        this.labelLabel.setForeground(
            Colors.TEXT.getColor()
        );

        this.labelLabel.setFont(
            Fonts.TEXT_SECOND.loadFont()
        );

        this.labelLabel.setVerticalAlignment(
            SwingConstants.CENTER
        );
    }

    // --------------------------------------------------
    // Icon
    // --------------------------------------------------

    private void skinIconPanel() {

        this.iconPanel.setPreferredSize(
            new Dimension(40, 40)
        );

        this.iconPanel.setOpaque(false);

        this.iconPanel.setLayout(
            new BorderLayout()
        );
    }

    private void skinIconLabel() {

        this.iconLabel.setVerticalAlignment(
            SwingConstants.CENTER
        );

        this.iconLabel.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        this.iconLabel.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        this.iconLabel.addMouseListener(
            new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (onClose != null) {
                        onClose.run();
                    }
                }
            }
        );
    }

    // --------------------------------------------------
    // Components
    // --------------------------------------------------

    private void addComponents() {

        this.labelPanel.add(
            this.labelLabel,
            BorderLayout.CENTER
        );

        this.iconPanel.add(
            this.iconLabel,
            BorderLayout.CENTER
        );

        this.add(
            this.labelPanel,
            BorderLayout.CENTER
        );

        this.add(
            this.iconPanel,
            BorderLayout.EAST
        );
    }
}
