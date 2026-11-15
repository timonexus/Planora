package de.timonexus.planora.ui.pages.pageHeader.pageHeaderButtonContainer;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.pageHeader.pageHeaderButton.PageHeaderButton;
import de.timonexus.planora.utils.enums.Icons;

public class PageHeaderButtonContainer extends JPanel implements Component{

    // attributes
    private final Component buttonExport;
    private final Component buttonEdit;
    private final Component buttonDelete;
    private final Component buttonAdd;

    // constructor
    public PageHeaderButtonContainer(){
        this.buttonExport = new PageHeaderButton(Icons.EXPORT_BRIGHT, false);
        this.buttonEdit = new PageHeaderButton(Icons.EDIT_BRIGHT, false);
        this.buttonDelete = new PageHeaderButton(Icons.DELETE_BRIGHT, false);
        this.buttonAdd = new PageHeaderButton(Icons.ADD_DARK, true);
    }

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) PageHeaderButtonContainerValues.WIDTH.getValue(), (int) PageHeaderButtonContainerValues.HEIGHT.getValue()));
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
        this.buttonExport.prepareComponent();
        this.buttonEdit.prepareComponent();
        this.buttonDelete.prepareComponent();
        this.buttonAdd.prepareComponent();
	}

	@Override
	public void addComponents() {
        this.removeAll();

        this.add((JPanel) this.buttonExport);
        this.add(Box.createHorizontalStrut(10));
        this.add((JPanel) this.buttonDelete);
        this.add(Box.createHorizontalStrut(10));
        this.add((JPanel) this.buttonEdit);
        this.add(Box.createHorizontalStrut(10));
        this.add((JPanel) this.buttonAdd);
	}

	@Override
	public void refresh() {
	}
    
}
