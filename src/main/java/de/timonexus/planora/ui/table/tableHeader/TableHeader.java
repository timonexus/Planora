package de.timonexus.planora.ui.table.tableHeader;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.TableColumn;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class TableHeader extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private TableColumn[] columns;

    // constructor
    public TableHeader(TableColumn[] nColumns){
        this.columns = nColumns;
        this.basePanel = new RoundedPanel();
    }

    @Override
    public void designComponent() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(0, 50));
    }

    @Override
    public void skinParts() {
        skinBasePanel();
        fillHeader();
    }

    @Override
    public void addParts() {
        this.add(this.basePanel, BorderLayout.CENTER);
    }

    @Override
    public void prepareComponents() {}

    @Override
    public void addComponents() {}

    @Override
    public void refresh() {}
    

    private void skinBasePanel(){
        this.basePanel.setCornerRadii(15, 15, 0, 0);
        this.basePanel.setBackground(Colors.MENUES.getColor());
        this.basePanel.setLayout(new BoxLayout(this.basePanel, BoxLayout.X_AXIS));
    }

    // getter
    public TableColumn[] getColumns() {
        return columns;
    }

    // setter
    public void setColumns(TableColumn[] columns) {
        this.columns = columns;
    }

    private void fillHeader(){
        for(TableColumn column : this.columns){
            this.basePanel.add(column.getHeaderObject());
        }
    }

}
