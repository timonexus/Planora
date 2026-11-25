package de.timonexus.planora.ui.ToastSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class ToastNotification extends RoundedPanel implements Component{

        private final JPanel icon;
        private final JPanel text;
        private final JPanel closeButton;

    public ToastNotification(ToastType type, String message) {
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
    }

    @Override
    public void addParts() {
        this.add(this.icon, BorderLayout.WEST);
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
        this.icon.setOpaque(false);
        this.icon.setPreferredSize(new Dimension(55, 55));
        this.icon.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.icon.setLayout(new BorderLayout());

        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(new Color(Colors.SUCCESS.getColor().getRed(), Colors.SUCCESS.getColor().getGreen(), Colors.SUCCESS.getColor().getBlue(), 50));
        roundedPanel.setLayout(new BorderLayout());
        roundedPanel.setRadius(200);
        roundedPanel.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));

        RoundedPanel roundedPanelInner = new RoundedPanel();
        roundedPanelInner.setBackground(Colors.SUCCESS.getColor());
        roundedPanelInner.setLayout(new BorderLayout());
        roundedPanelInner.setRadius(200);
        roundedPanel.add(roundedPanelInner, BorderLayout.CENTER);

        this.icon.add(roundedPanel, BorderLayout.CENTER);
    }
}