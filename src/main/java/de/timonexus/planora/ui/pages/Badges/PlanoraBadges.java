package de.timonexus.planora.ui.pages.Badges;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.pageHeader.PageHeader;
import de.timonexus.planora.ui.pages.pageTableContainer.PageTableContainer;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraBadges extends JPanel implements DefaultPage{

    // attributes
    private final Component header;
    private final Component tableCard;
    
    public PlanoraBadges(){
        this.header = new PageHeader();
        this.tableCard = new PageTableContainer("Abzeichen", new PlanoraBadgeModel());
    }

    @Override 
    public void skinPage(){
        this.setBackground(Colors.BASE.getColor());
		this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
    }

    @Override 
    public void prepareComponents(){
        this.header.prepareComponent();
        this.tableCard.prepareComponent();

    }

    @Override 
    public void addComponents(){
        this.add((JPanel) this.header, BorderLayout.NORTH);
        this.add((JPanel) this.tableCard, BorderLayout.CENTER);
    }
}
