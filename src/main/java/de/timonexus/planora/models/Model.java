package de.timonexus.planora.models;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.ui.table.TableColumn;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public interface Model {
    
    public TableColumn[] getColumns();

    default JPanel defaultTextElement(String nText){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JLabel label = new JLabel(nText);
        label.setFont(Fonts.TEXT.loadFont());
        label.setForeground(Colors.TEXT.getColor());
        label.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    default Checkbox defaultCheckbox(){
        Checkbox checkbox = new Checkbox();
        checkbox.setOpaque(false);

        return checkbox;
    }
}
