package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class TableIsEmpty extends JPanel {

    // --------------------------------------------------
    // Attributes
    // --------------------------------------------------

    private final RoundedPanel tableIsEmpty;

    private JLabel icon;
    private JLabel title;
    private JLabel description;


    // --------------------------------------------------
    // Constructor
    // --------------------------------------------------

    public TableIsEmpty() {

        this.tableIsEmpty = new RoundedPanel();

        prepareComponent();
    }


    // --------------------------------------------------
    // Component
    // --------------------------------------------------

    private void prepareComponent() {

        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        skinTableIsEmpty();
        createComponents();
        fillComponents();

        this.add(this.tableIsEmpty, BorderLayout.CENTER);
    }


    // --------------------------------------------------
    // Styling
    // --------------------------------------------------

    private void skinTableIsEmpty() {

        this.tableIsEmpty.setLayout(
            new BoxLayout(this.tableIsEmpty, BoxLayout.Y_AXIS)
        );

        this.tableIsEmpty.setRadius(15);
        this.tableIsEmpty.setBackground(
            Colors.MENUES.getColor()
        );

        this.tableIsEmpty.setPreferredSize(
            new Dimension(300, 300)
        );
    }


    // --------------------------------------------------
    // Create Components
    // --------------------------------------------------

    private void createComponents() {

        // Icon
        this.icon = new JLabel("📂");
        this.icon.setFont(
            new Font("Segoe UI Emoji", Font.PLAIN, 42)
        );
        this.icon.setForeground(
            Colors.TEXT_SECONDARY.getColor()
        );
        this.icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title
        this.title = new JLabel("Noch keine Einträge");
        this.title.setFont(
            new Font("Segoe UI", Font.BOLD, 19)
        );
        this.title.setForeground(
            Colors.TEXT.getColor()
        );
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description
        this.description = new JLabel(
            "<html><div style='text-align:center; width:230px;'>"
            + "Hier gibt es momentan noch nichts zu sehen.<br>"
            + "Erstelle einen neuen Eintrag, um loszulegen."
            + "</div></html>"
        );

        this.description.setFont(
            new Font("Segoe UI", Font.PLAIN, 12)
        );
        this.description.setForeground(
            Colors.TEXT_SECONDARY.getColor()
        );
        this.description.setHorizontalAlignment(
            SwingConstants.CENTER
        );
        this.description.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


    // --------------------------------------------------
    // Fill Components
    // --------------------------------------------------

    private void fillComponents() {

        this.tableIsEmpty.add(Box.createVerticalGlue());

        this.tableIsEmpty.add(this.icon);

        this.tableIsEmpty.add(
            Box.createVerticalStrut(20)
        );

        this.tableIsEmpty.add(this.title);

        this.tableIsEmpty.add(
            Box.createVerticalStrut(10)
        );

        this.tableIsEmpty.add(this.description);

        this.tableIsEmpty.add(Box.createVerticalGlue());
    }
}