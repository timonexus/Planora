package de.timonexus.planora.ui.sidebar.linksContainer;

import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.links.PlanoraSidebarLink;

public class PlanoraSidebarLinksContainer extends JPanel implements Component{

    // attributes
    private List<Pages> pages;
    private final int border;
    private final Service pageService;

    // constructor
    public PlanoraSidebarLinksContainer(List<Pages> nPages, int nBorder, Service nPageService){
        this.pages = nPages;
        this.border = nBorder;

        this.pageService = nPageService;
    }

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) PlanoraSidebarLinksContainerValues.WIDTH.getValue(), (int) PlanoraSidebarLinksContainerValues.HEIGHT.getValue()));
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(border == 1) this.setBorder((Border) PlanoraSidebarLinksContainerValues.BORDER.getValue());	
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
	}

    @Override
    public void addComponents() {

        this.removeAll();

        for (Pages page : pages) {
            PlanoraSidebarLink link = new PlanoraSidebarLink(page, this.pageService);
            link.prepareComponent();
            link.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

            this.add(link);
            this.add(Box.createVerticalStrut(4));
        }

        this.revalidate();
        this.repaint();
    }

    // getter
    public List<Pages> getPages() {
        return pages;
    }

    // setter
    public void setPages(List<Pages> pages) {
        this.pages = pages;
    }
    
}
