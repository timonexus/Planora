package de.timonexus.planora.ui.ToastSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;
import de.timonexus.planora.utils.enums.Icons;

public class ToastNotification extends RoundedPanel implements Component{

        private final JPanel icon;
        private final JPanel text;
        private final JPanel closeButton;

        private final Runnable close;
        private final String message;
        private final ToastType type;

    public ToastNotification(ToastType type, String message, Runnable nClose) {
        this.close = nClose;
        this.message = message;
        this.type = type;

        this.icon = new JPanel();
        this.text = new JPanel();
        this.closeButton = new JPanel();
    }

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(320, 75));
        this.setBackground(Colors.MENUES.getColor());
        this.setRadius(15);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
    }

    @Override
    public void skinParts() {
        skinIcon();
        skinClose();
        skinText();
    }

    @Override
    public void addParts() {
        this.add(this.icon, BorderLayout.WEST);
        this.add(this.text, BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.EAST);
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void refresh() {

    }

    private void skinIcon(){
        Color defaultColor;
        JLabel icon = Icons.CHECK_DARK.getIconLabel();
        switch (this.type) {
                case SUCCESS:
                        defaultColor = Colors.SUCCESS.getColor();
                        icon = Icons.CHECK_DARK.getIconLabel();
                        break;
                case ERROR:
                        defaultColor = Colors.ERROR.getColor();
                        icon = Icons.ERROR_DARK.getIconLabel();
                        break;
                default:
                        defaultColor = Colors.ERROR.getColor();
                        break;
        }

        this.icon.setOpaque(false);
        this.icon.setPreferredSize(new Dimension(55, 55));
        this.icon.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.icon.setLayout(new BorderLayout());

        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(new Color(defaultColor.getRed(), defaultColor.getGreen(), defaultColor.getBlue(), 50));
        roundedPanel.setLayout(new BorderLayout());
        roundedPanel.setRadius(200);
        roundedPanel.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));

        RoundedPanel roundedPanelInner = new RoundedPanel();
        roundedPanelInner.setBackground(defaultColor);
        roundedPanelInner.setLayout(new BorderLayout());
        roundedPanelInner.setRadius(200);

        icon.setVerticalAlignment(SwingConstants.CENTER);
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        roundedPanelInner.add(icon, BorderLayout.CENTER);

        roundedPanel.add(roundedPanelInner, BorderLayout.CENTER);

        this.icon.add(roundedPanel, BorderLayout.CENTER);
    }

    private void skinClose(){
        this.closeButton.setOpaque(false);
        this.closeButton.setPreferredSize(new Dimension(55, 55));
        this.closeButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.closeButton.setLayout(new BorderLayout());
        this.closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.closeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    close.run();
                }
        });

        JLabel closeIcon = Icons.CLOSE_BRIGHT.getIconLabel();
        closeIcon.setVerticalAlignment(SwingConstants.CENTER);
        closeIcon.setHorizontalAlignment(SwingConstants.CENTER);
        closeButton.add(closeIcon, BorderLayout.CENTER);
    }

    private void skinText(){
        this.text.setOpaque(false);
        this.text.setPreferredSize(new Dimension(55, 55));
        this.text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.text.setLayout(new BorderLayout());

        JTextPane description = new JTextPane();
        description.setText(this.message);
        description.setFont(Fonts.TEXT.loadFont());
        description.setForeground(Colors.TEXT_SECONDARY.getColor());
        description.setOpaque(false);
        description.setEditable(false);
        description.setFocusable(false);
        description.setBorder(null);

        this.text.add(description, BorderLayout.CENTER);
    }
}