package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public enum TableObject {
    
    PANEL,
    CHECKBOX;

    public JPanel getObject(String nValue){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        switch (this) {
            case PANEL:
                JLabel label = new JLabel(nValue);
                label.setForeground(Colors.TEXT.getColor());
                label.setFont(Fonts.TEXT.loadFont());
                label.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(label, BorderLayout.CENTER);
                break;
            case CHECKBOX:
                Checkbox checkbox = new Checkbox();
                panel.add(checkbox, BorderLayout.CENTER);
                break;
        }

        return panel;
    }
}
