package de.timonexus.planora.ui.ToastSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class ToastNotification extends RoundedPanel {

    public ToastNotification(ToastType type, String message) {

        setLayout(new BorderLayout(12, 0));
        setPreferredSize(new Dimension(320, 75));

        setBackground(Colors.DIALOGS.getColor());
        setRadius(14);

        setBorder(BorderFactory.createEmptyBorder(
                12, 14, 12, 14
        ));

        // Accent
        JPanel accent = new JPanel();
        accent.setBackground(type.getColor());
        accent.setPreferredSize(new Dimension(4, 0));

        // Text
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BorderLayout(0, 5));

        JLabel title = new JLabel(type.getTitle());
        title.setForeground(Colors.TEXT.getColor());
        title.setFont(
                Fonts.TEXT.loadFont().deriveFont(Font.BOLD, 13f)
        );

        JLabel description = new JLabel(
                "<html><div style='width:240px;'>"
                        + message
                        + "</div></html>"
        );

        description.setForeground(Colors.TEXT_SECONDARY.getColor());
        description.setFont(
                Fonts.TEXT.loadFont().deriveFont(11f)
        );

        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(description, BorderLayout.CENTER);

        add(accent, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
    }
}