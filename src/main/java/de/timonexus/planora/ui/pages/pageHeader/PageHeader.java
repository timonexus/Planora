package de.timonexus.planora.ui.pages.pageHeader;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.pageHeader.pageHeaderButtonContainer.PageHeaderButtonContainer;
import de.timonexus.planora.ui.pages.pageHeader.pageHeaderSearchbar.PageHeaderSearchbar;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class PageHeader extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel; 
    private final Component searchbar;
    private final Component buttonContainer;

    // constructor
    public PageHeader(DefaultPageService nService){
        this.basePanel = new RoundedPanel();
        this.searchbar = new PageHeaderSearchbar();
        this.buttonContainer = new PageHeaderButtonContainer(nService);
    }

	@Override
	public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension((int) PageHeaderValues.WIDTH.getValue(), (int) PageHeaderValues.HEIGHT.getValue()));
        this.setOpaque(false);
	}

	@Override
	public void skinParts() {
        skinBasePanel();
	}

	@Override
	public void addParts() {
        this.add(this.basePanel, BorderLayout.CENTER);
	}

	@Override
	public void prepareComponents() {
        this.searchbar.prepareComponent();
        this.buttonContainer.prepareComponent();
	}

	@Override
	public void addComponents() {
        this.basePanel.add((JPanel) this.searchbar, BorderLayout.WEST);
        this.basePanel.add((JPanel) this.buttonContainer, BorderLayout.EAST);
	}

	@Override
	public void refresh() {
	}

    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.APP_BAR.getColor());
        this.basePanel.setRadius(35);
        this.basePanel.setLayout(new BorderLayout());
    }
    
}
