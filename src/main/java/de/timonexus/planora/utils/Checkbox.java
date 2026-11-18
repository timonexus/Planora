package de.timonexus.planora.utils;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.utils.enums.Icons;

public class Checkbox extends JPanel{
    
    // attributes
    private boolean isChecked;

    // constructor
    public Checkbox(){
        this(false);
    }
    public Checkbox(boolean n_isChecked){
        this.isChecked = n_isChecked;
        skinPanel();
    }

    private void skinPanel(){
        this.setMinimumSize(new Dimension(20, 20));
        this.setMaximumSize(new Dimension(60, 60));
        this.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {  
            @Override
            public void mouseClicked(MouseEvent e) {
                isChecked = !isChecked;
                skinPanel();
            }
        });

        JLabel icon;
        if(isChecked){
            icon = Icons.CHECKBOX_CHECKED_BRIGHT.getIconLabel();
        }else{
            icon = Icons.CHECKBOX_BRIGHT.getIconLabel();
        }
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setVerticalAlignment(SwingConstants.CENTER);

        this.add(icon, BorderLayout.CENTER);
    }

    // getter
    public boolean isChecked(){
        return this.isChecked;
    }

    // setters
    public void setIsChecked(boolean n_isChecked){
        this.isChecked = n_isChecked;
        skinPanel();
    }
}
