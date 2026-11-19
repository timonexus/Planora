package de.timonexus.planora.ui.formulars;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;

public class LayeredPane extends JLayeredPane implements Component{

    private JPanel basePanel;

    public LayeredPane(){
        this.basePanel = new JPanel();
    }

	@Override
	public void designComponent() {
        this.setLayout(null);
	}

	@Override
	public void skinParts() {

	}

	@Override
	public void addParts() {
        this.add(this.basePanel, JLayeredPane.DEFAULT_LAYER);
	}

	@Override
	public void prepareComponents() {

	}

	@Override
	public void addComponents() {

	}

	@Override
	public void refresh() {

	}

    public void setFormular(Formular nFormular){
        this.basePanel = (JPanel) nFormular;
    }
    
}
