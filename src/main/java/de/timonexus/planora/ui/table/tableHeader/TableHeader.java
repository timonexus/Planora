package de.timonexus.planora.ui.table.tableHeader;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
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

    // constructor
    public TableHeader(){
        this.basePanel = new RoundedPanel();
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

        JLabel idL = new JLabel("ID");
        idL.setForeground(Colors.TEXT.getColor());
        idL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement id = new TableHeaderElement(idL, 20, 20);
        id.prepareComponent();
        this.basePanel.add(id);

        Checkbox checkboxJ = new Checkbox(true);
        TableHeaderElement checkbox = new TableHeaderElement(checkboxJ, 20, 20);
        checkbox.prepareComponent();
        this.basePanel.add(checkbox);

        JLabel nameL = new JLabel("Name");
        nameL.setForeground(Colors.TEXT.getColor());
        nameL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement name = new TableHeaderElement(nameL, 200, Integer.MAX_VALUE);
        name.prepareComponent();
        this.basePanel.add(name);

        JLabel datumL = new JLabel("Datum");
        datumL.setForeground(Colors.TEXT.getColor());
        datumL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement datum = new TableHeaderElement(datumL, 20, Integer.MAX_VALUE);
        datum.prepareComponent();
        this.basePanel.add(datum);

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
