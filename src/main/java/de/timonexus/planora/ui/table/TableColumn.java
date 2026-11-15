package de.timonexus.planora.ui.table;

public class TableColumn {
    
    // attributes
    private String columnTitle;
    private int columnWidth;

    // constructor
    public TableColumn(String nColumnTitle, int nColumnWidth){
        this.columnTitle = nColumnTitle;
        this.columnWidth = nColumnWidth;
    }

    // getter
    public String getColumnTitle() {
        return columnTitle;
    }
    public int getColumnWidth() {
        return columnWidth;
    }

    // setter
    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }
    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }
}
