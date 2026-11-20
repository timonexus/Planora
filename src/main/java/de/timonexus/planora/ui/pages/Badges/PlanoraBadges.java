package de.timonexus.planora.ui.pages.Badges;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.pageHeader.PageHeader;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraBadges extends JPanel implements DefaultPage{

    // attributes
    private final Component header;
    
    public PlanoraBadges(){
        this.header = new PageHeader(null);
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
    }

    @Override 
    public void addComponents(){
        this.add((JPanel) this.header, BorderLayout.NORTH);
    }

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'refresh'");
	}

	@Override
	public void setFrame(Frame nFrame) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setFrame'");
	}
}
