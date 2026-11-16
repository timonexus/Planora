package de.timonexus.planora.ui.table;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;

public class TableColumn {
    
    // attributes
    private final JComponent headerObject;
    private final int columnID;
    private int width;
    private final int minWidth;
    private final int maxWidth;

    // cosntructor
    public TableColumn(JComponent nHeaderObject, int nColumnID, int nWidth, int nMinWidth, int nMaxWidth){
        this.headerObject = nHeaderObject;
        this.columnID = nColumnID;
        this.width = nWidth;
        this.minWidth = nMinWidth;
        this.maxWidth = nMaxWidth;

        adaptHeaderComponent();
    }
    public TableColumn(JComponent nHeaderObject, int nColumnID){
        this(nHeaderObject, nColumnID, 0, 20, 100);
    }

    private void adaptHeaderComponent(){
        this.headerObject.setMaximumSize(new Dimension(this.maxWidth, 50));
        this.headerObject.setMinimumSize(new Dimension(this.minWidth, 50));
        this.headerObject.setPreferredSize(new Dimension(this.width, 50));
        this.headerObject.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    // getter
    public int getColumnID() {
        return columnID;
    }
    public JComponent getHeaderObject() {
        return headerObject;
    }
    public int getMaxWidth() {
        return maxWidth;
    }
    public int getMinWidth() {
        return minWidth;
    }
    public int getWidth() {
        return width;
    }

    // setter
    public void setWidth(int width) {
        this.width = width;
    }
}
