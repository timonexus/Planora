package de.timonexus.planora.ui.sidebar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.*;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.sidebar.header.PlanoraSidebarHeader;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSidebar extends JPanel implements Component{

	// attribute
	private final RoundedPanel basePanel;
	private final Component header;

	// constructor
	public PlanoraSidebar(){
		this.basePanel = new RoundedPanel();

		this.header = new PlanoraSidebarHeader();
	}

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) SidebarValues.WIDTH.getValue(), (int) SidebarValues.HEIGHT.getValue()));
        this.setOpaque(false);
		this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		skinBasePanel();
    }

	@Override
	public void prepareComponents() {
		this.header.prepareComponent();
	}

	@Override
	public void addComponents() {

		//basePanel
		this.basePanel.add((JPanel) this.header, BorderLayout.NORTH);

		this.add(this.basePanel, BorderLayout.CENTER);
	}

	private void skinBasePanel(){
		this.basePanel.setPreferredSize(new Dimension((int) SidebarValues.WIDTH.getValue(), (int) SidebarValues.HEIGHT.getValue()));
		this.basePanel.setBackground(Colors.APP_BAR.getColor());
		this.basePanel.setRadius(35);
		this.basePanel.setLayout(new BorderLayout());
	}
    
}
