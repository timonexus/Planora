package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class Table extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;

    // constructor
    public Table(){
        this.basePanel = new RoundedPanel();
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
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
	}

	@Override
	public void addComponents() {
	}

	@Override
	public void refresh() {
	}

    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.APP_BAR.getColor());
        this.basePanel.setRadius(15);
        this.basePanel.setLayout(new BorderLayout());
    }
    
}
