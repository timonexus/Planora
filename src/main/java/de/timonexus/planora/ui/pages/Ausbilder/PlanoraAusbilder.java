package de.timonexus.planora.ui.pages.Ausbilder;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.models.tableModels.Ausbilder.AusbilderTableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.service.Ausbilder.AusbilderService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.pageHeader.PageHeader;
import de.timonexus.planora.ui.pages.pageTableContainer.PageTableContainer;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraAusbilder extends JPanel implements DefaultPage{

    // attributes
    private final Component header;
    private final Component tableCard;
    private Frame frame;
    private final DefaultPageService service;
    
    public PlanoraAusbilder(){
        this.service = new AusbilderService();
        this.header = new PageHeader(this.service);
        this.tableCard = new PageTableContainer("Ausbilder", this.service.loadAll(), new AusbilderTableModel(), this.service);
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

	@Override
	public void refresh() {
        this.prepareComponents();

        this.revalidate();
        this.repaint();
	}

	@Override
	public void setFrame(Frame nFrame) {
        this.frame = nFrame;
        this.service.setFrame(this.frame);
        refresh();
	}
}
