package de.timonexus.planora.utils.enums;

import java.awt.Image;

import javax.swing.JLabel;

import de.timonexus.planora.utils.ImageLoader;

public enum Icons {

    STARTSEITE("/icons/Icon_Delete.png", 20),
    DUTIES("", 20);

    private final String path;
    private final int size;
    private final ImageLoader imageLoader;

    Icons(String nPath, int nSize) {
        this.path = nPath;
        this.size = nSize;
        this.imageLoader = new ImageLoader();
    }

    public String getPath() {
        return path;
    }

    public int getSize() {
        return size;
    }

    public JLabel getIconLabel() {
        return imageLoader.getIconLabel(path, size);
    }

    public Image getImage() {
        return imageLoader.getImage(path, size);
    }
}