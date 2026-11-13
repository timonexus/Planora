package de.timonexus.planora.ui.sidebar;

import java.awt.Dimension;

import javax.swing.JPanel;

import de.timonexus.planora.ui.Colors;

public class PlanoraSidebar extends JPanel implements Sidebar{

	@Override
	public void designSidebar() {
        this.setPreferredSize(new Dimension((int) SidebarValues.WIDTH.getValue(), (int) SidebarValues.HEIGHT.getValue()));
        this.setBackground(Colors.APP_BAR.getColor());
    }

	@Override
	public void fillSidebar() {}

	@Override
	public void addComponents() {}
    
}
