package de.timonexus.planora.ui.table.tableHeader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableHeader.tableHeaderElement.TableHeaderElement;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class TableHeader extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final List<TableHeaderElement> headerElements;

    // constructor
    public TableHeader(List<TableHeaderElement> nHeaderElements){
        this.basePanel = new RoundedPanel();

        this.headerElements = nHeaderElements;
    }

    @Override
    public void designComponent() {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension((int) TableHeaderValues.WIDTH.getValue(), (int) TableHeaderValues.HEIGHT.getValue()));
        this.setLayout(new BorderLayout());
    }

    @Override
    public void skinParts() {
        skinBasePanel();
    }

    @Override
    public void addParts() {
        this.basePanel.removeAll();

        for(TableHeaderElement element : this.headerElements){
            this.basePanel.add(element);
        }

        this.add(basePanel, BorderLayout.CENTER);
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
        this.basePanel.setBackground(Colors.MENUES.getColor());
        this.basePanel.setCornerRadii(15, 15, 0, 0);
        this.basePanel.setLayout(new BoxLayout(this.basePanel, BoxLayout.X_AXIS));
    }
    
}
