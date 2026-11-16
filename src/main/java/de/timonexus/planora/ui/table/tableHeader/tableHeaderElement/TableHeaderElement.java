package de.timonexus.planora.ui.table.tableHeader.tableHeaderElement;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;

public class TableHeaderElement extends JPanel implements Component{

    // attributes
    private final JComponent columnObject;
    private final int width;
    private final int maxWidth;

    // constructor
    public TableHeaderElement(JComponent nColumnObject, int nWidth, int nMaxWidth){
        this.columnObject = nColumnObject;
        this.width = nWidth;
        this.maxWidth = nMaxWidth;
    }

    @Override
    public void designComponent() {
        this.setMinimumSize(new Dimension(this.width, 50));
        this.setMaximumSize(new Dimension(this.maxWidth, 100));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        this.setLayout(new BorderLayout());
    }

    @Override
    public void skinParts() {
    }

    @Override
    public void addParts() {
        this.add(this.columnObject, BorderLayout.CENTER);
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
    
}
