package de.timonexus.planora.utils.enums;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public enum Logo {
    LOGOV0_0_1("/logo/LogoPlanora_[2026-11-13].png");

    // attributes
    private final String path;

    // constructor
    private Logo(String nPath){
        this.path = nPath;
    }

    // getter
    public String getPath() {
        return path;
    }

    // method to get a iconLabel
    public JLabel getIconLabel(){
        JLabel label = new JLabel();

        java.net.URL logoURL = getClass().getResource(this.path);
        if (logoURL != null) {
            ImageIcon originalIcon = new ImageIcon(logoURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("Planora logo could not be found.");
        }

        return label;
    }
}
