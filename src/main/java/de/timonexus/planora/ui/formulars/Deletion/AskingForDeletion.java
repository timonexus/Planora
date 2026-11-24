
package de.timonexus.planora.ui.formulars.Deletion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class AskingForDeletion extends RoundedPanel implements Formular, Component {

    // attributes
    private final int numberOfElements;
    private final Runnable onConfirm;
    private final Runnable onCancel;

    // components
    private JLabel countLabel;
    private JButton deleteButton;
    private JButton cancelButton;

    // constructor
    public AskingForDeletion(
            int numberOfElements,
            Runnable onConfirm,
            Runnable onCancel) {

        this.numberOfElements = Math.max(0, numberOfElements);
        this.onConfirm = onConfirm;
        this.onCancel = onCancel;

        designComponent();
        skinParts();
        prepareComponents();
        addParts();
        addComponents();
    }

    // component design
    @Override
    public void designComponent() {

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(440, 400));

        setBackground(Colors.CARDS.getColor());
        setRadius(20);

        setRoundedBorder(
                Colors.TEXT_DISABLED.getColor(),
                1,
                BorderPlacement.OUTSIDE
        );

        setBorder(BorderFactory.createEmptyBorder(
                25, 25, 22, 25
        ));
    }

    @Override
    public void skinParts() {
        // No additional styling required.
    }

    @Override
    public void addParts() {
        // Components are created in prepareComponents().
    }

    @Override
    public void prepareComponents() {

        countLabel = new JLabel(
                numberOfElements + (
                        numberOfElements == 1
                                ? " Element"
                                : " Elemente"
                )
        );

        countLabel.setForeground(Colors.TEXT.getColor());
        countLabel.setFont(Fonts.TEXT.loadFont().deriveFont(Font.BOLD, 24f));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        deleteButton = createButton(
                "Endgültig löschen",
                Colors.ERROR.getColor(),
                Colors.BASE.getColor()
        );

        cancelButton = createButton(
                "Abbrechen",
                Colors.MENUES.getColor(),
                Colors.TEXT.getColor()
        );

        deleteButton.addActionListener(e -> {
            if (onConfirm != null) {
                onConfirm.run();
                onCancel.run();
            }
        });

        cancelButton.addActionListener(e -> {
            if (onCancel != null) {
                onCancel.run();
            }
        });

        deleteButton.setEnabled(numberOfElements > 0);
    }

    @Override
    public void addComponents() {

        add(createContent(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);
    }

    // content
    private JPanel createContent() {

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // warning icon
        RoundedPanel iconPanel = new RoundedPanel();
        iconPanel.setLayout(new BorderLayout());
        iconPanel.setBackground(new Color(
                Colors.ERROR.getColor().getRed(),
                Colors.ERROR.getColor().getGreen(),
                Colors.ERROR.getColor().getBlue(),
                35
        ));

        iconPanel.setRadius(35);
        iconPanel.setPreferredSize(new Dimension(70, 70));
        iconPanel.setMaximumSize(new Dimension(70, 70));
        iconPanel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel icon = new JLabel("!");
        icon.setForeground(Colors.ERROR.getColor());
        icon.setFont(Fonts.TEXT.loadFont().deriveFont(Font.BOLD, 38f));
        icon.setHorizontalAlignment(SwingConstants.CENTER);

        iconPanel.add(icon, BorderLayout.CENTER);

        // title
        JLabel title = new JLabel("Elemente löschen?");
        title.setForeground(Colors.TEXT.getColor());
        title.setFont(Fonts.TEXT.loadFont().deriveFont(Font.BOLD, 22f));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // description
        JLabel description = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Möchtest du die ausgewählten Elemente wirklich löschen?"
                        + "</div></html>"
        );

        description.setForeground(Colors.TEXT_SECONDARY.getColor());
        description.setFont(Fonts.TEXT.loadFont().deriveFont(12f));
        description.setAlignmentX(CENTER_ALIGNMENT);

        // count card
        RoundedPanel countPanel = new RoundedPanel();
        countPanel.setLayout(new BorderLayout());
        countPanel.setBackground(Colors.MENUES.getColor());
        countPanel.setRadius(13);
        countPanel.setBorder(BorderFactory.createEmptyBorder(
                15, 15, 15, 15
        ));
        countPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));

        JLabel countTitle = new JLabel("BETROFFENE ELEMENTE");
        countTitle.setForeground(Colors.TEXT_SECONDARY.getColor());
        countTitle.setFont(Fonts.TEXT.loadFont().deriveFont(10f));
        countTitle.setHorizontalAlignment(SwingConstants.CENTER);

        countPanel.add(countTitle, BorderLayout.NORTH);
        countPanel.add(countLabel, BorderLayout.CENTER);

        // warning text
        JLabel warning = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Diese Aktion kann nicht rückgängig gemacht werden."
                        + "</div></html>"
        );

        warning.setForeground(Colors.ERROR.getColor());
        warning.setFont(Fonts.TEXT.loadFont().deriveFont(11f));
        warning.setAlignmentX(CENTER_ALIGNMENT);

        content.add(iconPanel);
        content.add(Box.createVerticalStrut(20));
        content.add(title);
        content.add(Box.createVerticalStrut(9));
        content.add(description);
        content.add(Box.createVerticalStrut(24));
        content.add(countPanel);
        content.add(Box.createVerticalStrut(18));
        content.add(warning);

        return content;
    }

    // footer
    private JPanel createFooter() {

        JPanel footer = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 0)
        );

        footer.setOpaque(false);

        cancelButton.setPreferredSize(new Dimension(150, 43));
        deleteButton.setPreferredSize(new Dimension(185, 43));

        footer.add(cancelButton);
        footer.add(deleteButton);

        return footer;
    }

    // button factory
    private JButton createButton(
            String text,
            Color background,
            Color foreground) {

        JButton button = new JButton(text);

        button.setFont(Fonts.TEXT.loadFont().deriveFont(Font.BOLD, 12f));
        button.setForeground(foreground);
        button.setBackground(background);

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(
                10, 16, 10, 16
        ));

        Color hoverColor = background.brighter();

        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.isEnabled()) {
                    button.setBackground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(background);
            }
        });

        return button;
    }

    @Override
    public void refresh() {
        revalidate();
        repaint();
    }

    @Override
    public Model getData() {
        return null;
    }
}
