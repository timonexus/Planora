package de.timonexus.planora.utils.enums;

import java.awt.Image;

import javax.swing.JLabel;

import de.timonexus.planora.utils.ImageLoader;

public enum Logo {
    LOGOV0_0_1("/logo/LogoPlanora_[2026-11-13].png"),
    DEFAULT_LOGO(Logo.LOGOV0_0_1);

    // attributes
    private final String path;

    // constructor
    private Logo(String nPath){
        this.path = nPath;
    }
    private Logo(Logo nLogo){
        this(nLogo.getPath());
    }
    // getter
    public String getPath() {
        return path;
    }

    // method to get a iconLabel
    public JLabel getIconLabel(){
        return new ImageLoader().getIconLabel(this.path, 35);
    }

    public Image getImage(){
        return new ImageLoader().getImage(this.path, 35);
    }
}
