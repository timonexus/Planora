package de.timonexus.planora.ui.pages.Support;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.*;

import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSupport extends JPanel implements DefaultPage{

    // attributes

    public PlanoraSupport(){
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
        this.add(new JLabel("Support"), BorderLayout.NORTH);
    }

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'refresh'");
	}
    
}
