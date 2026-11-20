package de.timonexus.planora.ui.sidebar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.*;

import de.timonexus.planora.service.PageService;
import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.footer.PlanoraSidebarFooter;
import de.timonexus.planora.ui.sidebar.header.PlanoraSidebarHeader;
import de.timonexus.planora.ui.sidebar.linksContainer.PlanoraSidebarLinksContainer;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSidebar extends JPanel implements Component{

	// attribute
	private final RoundedPanel basePanel;
	private final Component header;
	private final Component linkContainer;
	private final Component footer;
	private final Service pageService;

	// constructor
	public PlanoraSidebar(Frame nFrame){
		this.basePanel = new RoundedPanel();
		this.pageService = new PageService(nFrame);

		this.header = new PlanoraSidebarHeader();
		this.linkContainer = new PlanoraSidebarLinksContainer(List.of(Pages.STARTSEITE, Pages.KALENDER, Pages.DIENST, Pages.AUSBILDUNGEN, Pages.KATEGORIEN, Pages.THEMEN, Pages.GRUPPEN, Pages.AUSBILDER, Pages.ABZEICHEN), 1, pageService);
		this.footer = new PlanoraSidebarFooter(pageService);
	}

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) SidebarValues.WIDTH.getValue(), (int) SidebarValues.HEIGHT.getValue()));
        this.setOpaque(true);
		this.setBackground(Colors.BASE.getColor());
		this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

		skinBasePanel();
    }

	@Override
	public void prepareComponents() {
		this.header.prepareComponent();
		this.linkContainer.prepareComponent();
		this.footer.prepareComponent();
	}

	@Override
	public void addComponents() {

		//basePanel
		this.basePanel.add((JPanel) this.header, BorderLayout.NORTH);
		this.basePanel.add((JPanel) this.linkContainer, BorderLayout.CENTER);
		this.basePanel.add((JPanel) this.footer, BorderLayout.SOUTH);
	}

	@Override 
	public void skinParts(){
		skinBasePanel();
	}

	@Override
	public void addParts(){
		this.add(this.basePanel, BorderLayout.CENTER);
	}

	private void skinBasePanel(){
		this.basePanel.setPreferredSize(new Dimension((int) SidebarValues.WIDTH.getValue(), (int) SidebarValues.HEIGHT.getValue()));
		this.basePanel.setBackground(Colors.APP_BAR.getColor());
		this.basePanel.setRadius(35);
		this.basePanel.setLayout(new BorderLayout());
	}

	@Override 
	public void refresh(){
		addComponents();
		this.linkContainer.refresh();
		this.footer.refresh();
		this.linkContainer.refresh();
	}
    
}
