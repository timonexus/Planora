package de.timonexus.planora.ui.pages;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.pageHeader.PageHeader;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraHome extends JPanel implements DefaultPage{

    // attributes
    private final Component pageHeader;

    public PlanoraHome(){
        this.pageHeader = new PageHeader();
    }

    @Override 
    public void skinPage(){
        this.setBackground(Colors.BASE.getColor());
		this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @Override 
    public void prepareComponents(){
        this.pageHeader.prepareComponent();
    }

    @Override 
    public void addComponents(){
        this.add((JPanel) this.pageHeader, BorderLayout.NORTH);
    }
    
}
