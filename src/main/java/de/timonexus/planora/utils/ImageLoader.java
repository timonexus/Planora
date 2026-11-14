package de.timonexus.planora.utils;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLoader {
    
    public Image getImage(String nPath, int size){
        java.net.URL logoURL = getClass().getResource(nPath);
        if (logoURL != null) {
            ImageIcon originalIcon = new ImageIcon(logoURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return scaledImage;
        } else {
            System.err.println("Planora logo could not be found.");
            return null;
        }
    }

    public JLabel getIconLabel(String nPath, int size){
        JLabel label = new JLabel();

        label.setIcon(new ImageIcon(this.getImage(nPath, size)));

        return label;
    }
}
