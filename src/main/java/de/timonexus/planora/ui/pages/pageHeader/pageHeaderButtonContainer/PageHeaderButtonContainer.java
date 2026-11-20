package de.timonexus.planora.ui.pages.pageHeader.pageHeaderButtonContainer;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.pageHeader.pageHeaderButton.PageHeaderButton;
import de.timonexus.planora.ui.pages.pageHeader.pageHeaderButton.Task;
import de.timonexus.planora.utils.enums.Icons;

public class PageHeaderButtonContainer extends JPanel implements Component{

    // attributes
    private final Component buttonExport;
    private final Component buttonEdit;
    private final Component buttonDelete;
    private final Component buttonFilter;
    private final Component buttonAdd;

    // constructor
    public PageHeaderButtonContainer(DefaultPageService nService){
        this.buttonExport = new PageHeaderButton(Icons.EXPORT_BRIGHT, false, nService, Task.EXPORT);
        this.buttonEdit = new PageHeaderButton(Icons.EDIT_BRIGHT, false, nService, Task.EDIT);
        this.buttonDelete = new PageHeaderButton(Icons.DELETE_BRIGHT, false, nService, Task.DELETE);
        this.buttonFilter = new PageHeaderButton(Icons.FILTER_BRIGHT, false, nService, Task.FIlTER);
        this.buttonAdd = new PageHeaderButton(Icons.ADD_DARK, true, nService, Task.ADD);
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
        this.buttonFilter.prepareComponent();
        this.buttonAdd.prepareComponent();
	}

	@Override
	public void addComponents() {
        this.removeAll();

        this.add((JPanel) this.buttonExport);
        this.add(Box.createHorizontalStrut(10));
        this.add((JPanel) this.buttonFilter);
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
