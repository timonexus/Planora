package de.timonexus.planora.ui.pages.Help;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.*;

import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraHelp extends JPanel implements DefaultPage{

    // attributes

    public PlanoraHelp(){
    }

    @Override 
    public void skinPage(){
        this.setBackground(Colors.BASE.getColor());
		this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
    }

    @Override 
    public void prepareComponents(){
    }

    @Override 
    public void addComponents(){
        this.add(new JLabel("Anleitung / Hilfe"), BorderLayout.NORTH);
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
