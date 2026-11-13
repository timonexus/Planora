package de.timonexus.planora.ui.sidebar.header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.Colors;
import de.timonexus.planora.utils.Fonts;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;

public class PlanoraSidebarHeader extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final JPanel labelPanel;
    private final JLabel labelPlanora;
    private final JPanel iconPanel;
    private final JLabel labelIcon;

    // constructor
    public PlanoraSidebarHeader(){
        this.basePanel = new RoundedPanel();
        this.labelPanel = new JPanel();
        this.labelPlanora = new JLabel();
        this.iconPanel = new JPanel();
        this.labelIcon = new JLabel();
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension((int) PlanoraSidebarHeaderValues.WIDTH.getValue(), (int) PlanoraSidebarHeaderValues.HEIGHT.getValue()));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 25, 20));
        this.setLayout(new BorderLayout());

        skinParts();
	}

	@Override
	public void prepareComponents() {}

	@Override
	public void addComponents() {

        //labelPanel
        this.labelPanel.add(this.labelPlanora, BorderLayout.CENTER);

        // iconPanel
        this.iconPanel.add(this.labelIcon, BorderLayout.CENTER);

        // basePanel
        this.basePanel.add(this.labelPanel, BorderLayout.EAST);
        this.basePanel.add(this.iconPanel, BorderLayout.WEST);

        this.add(basePanel, BorderLayout.CENTER);
	}

    private void skinParts(){
        skinBasePanel();
        skinLabelPanel();
        skinLabelPlanora();
        skinIconPanel();
        skinLabelIcon();
    }

    private void skinBasePanel(){
        this.basePanel.setPreferredSize(new Dimension());
        this.basePanel.setBackground(Colors.MENUES.getColor());
        this.basePanel.setRoundedBorder(Colors.DIALOGS.getColor(), 1, BorderPlacement.OUTSIDE);
        this.basePanel.setRadius(15);
        this.basePanel.setLayout(new BorderLayout());
    }

    private void skinLabelPanel(){
        this.labelPanel.setPreferredSize(new Dimension(140, 50));
        this.labelPanel.setOpaque(false);
        this.labelPanel.setLayout(new BorderLayout());
    }

    private void skinLabelPlanora(){
        this.labelPlanora.setText("Planora");
        this.labelPlanora.setForeground(Colors.TEXT.getColor());
        this.labelPlanora.setFont(Fonts.LOGO.loadFont());
        this.labelPlanora.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void skinIconPanel(){
        this.iconPanel.setPreferredSize(new Dimension(55, 50));
        this.iconPanel.setOpaque(false);
        this.iconPanel.setLayout(new BorderLayout());
    }

    private void skinLabelIcon(){
        this.labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
        this.labelIcon.setVerticalAlignment(SwingConstants.CENTER);

        java.net.URL logoURL = getClass().getResource("/logo/LogoPlanora_[2026-11-13].png");
        if (logoURL != null) {
            ImageIcon originalIcon = new ImageIcon(logoURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

            this.labelIcon.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("Planora logo could not be found.");
        }
    }
    
}
