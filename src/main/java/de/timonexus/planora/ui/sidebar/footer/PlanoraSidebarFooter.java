package de.timonexus.planora.ui.sidebar.footer;

import java.awt.BorderLayout;import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.linksContainer.PlanoraSidebarLinksContainer;
import de.timonexus.planora.utils.ApplicationInfo;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSidebarFooter extends JPanel implements Component{

	// attributes
	private final JPanel versionPanel;
	private final JLabel versionLabel;

	private final Component links;

	// constructor
	public PlanoraSidebarFooter(Service nPageService){
		this.versionPanel = new JPanel();
		this.versionLabel = new JLabel();
		this.links = new PlanoraSidebarLinksContainer(List.of(Pages.EINSTELLUNGEN, Pages.SUPPORT, Pages.ANLEITUNG), 0, nPageService);
	}

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) PlanoraSidebarFooterValues.WIDTH.getValue(), (int) PlanoraSidebarFooterValues.HEIGHT.getValue()));
        this.setOpaque((boolean) PlanoraSidebarFooterValues.OPAQUE.getValue());
		this.setLayout((LayoutManager) PlanoraSidebarFooterValues.LAYOUT.getValue());
        this.setBorder((Border) PlanoraSidebarFooterValues.BORDER.getValue());	
	}

	@Override
	public void prepareComponents() {
		this.links.prepareComponent();
	}

	@Override
	public void addComponents() {
		this.add((JPanel) this.links, BorderLayout.NORTH);
	}

	@Override 
	public void skinParts(){
		skinVersionPanel();
		skinVersionLabel();
	}

	@Override 
	public void addParts(){
		//versionPanel
		this.versionPanel.add(versionLabel, BorderLayout.CENTER);

		this.add(versionPanel, BorderLayout.SOUTH);
	}

	private void skinVersionPanel(){
		this.versionPanel.setPreferredSize(new Dimension(20, 20));
		this.versionPanel.setLayout(new BorderLayout());
		this.versionPanel.setOpaque(false);
	}

	private void skinVersionLabel(){
		this.versionLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		this.versionLabel.setForeground(Colors.TEXT_SECONDARY.getColor());
		this.versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.versionLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.versionLabel.setText(ApplicationInfo.getName() + " " + ApplicationInfo.getVersion());
	}
    
}
