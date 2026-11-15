package de.timonexus.planora.utils.enums;

import java.awt.Image;

import javax.swing.JLabel;

import de.timonexus.planora.utils.ImageLoader;

public enum Icons {

    STARTSEITE_BRIGHT("/icons/home_bright.png", 20),
    STARTSEITE_DARK("/icons/home_dark.png", 20),
    DUTIE_BRIGHT("/icons/dutie_bright.png", 20),
    DUTIE_DARK("/icons/dutie_dark.png", 20),
    CALENDAR_BRIGHT("/icons/calendar_bright.png", 20),
    CALENDAR_DARK("/icons/calendar_dark.png", 20),
    HELP_BRIGHT("/icons/help_bright.png", 20),
    HELP_DARK("/icons/help_dark.png", 20),
    SETTINGS_BRIGHT("/icons/settings_bright.png", 20),
    SETTINGS_DARK("/icons/settings_dark.png", 20),
    SUPPORT_BRIGHT("/icons/support_bright.png", 20),
    SUPPORT_DARK("/icons/support_dark.png", 20),
    TRAININGEVENTS_BRIGHT("/icons/trainingEvent_bright.png", 20),
    TRAININGEVENTS_DARK("/icons/trainingEvent_dark.png", 20),
    CATEGORIES_BRIGHT("/icons/folder_bright.png", 20),
    CATEGORIES_DARK("/icons/folder_dark.png", 20),
    TOPICS_BRIGHT("/icons/topic_bright.png", 20),
    TOPICS_DARK("/icons/topic_dark.png", 20),
    GROUPS_BRIGHT("/icons/group_bright.png", 20),
    GROUPS_DARK("/icons/group_dark.png", 20),
    TEACHER_BRIGHT("/icons/teacher_bright.png", 20),
    TEACHER_DARK("/icons/teacher_dark.png", 20),
    BAGDES_BRIGHT("/icons/badge_bright.png", 20),
    BADGES_DARK("/icons/badge_dark.png", 20)
    ;

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