package de.timonexus.planora.ui.ToastSystem;

import java.awt.Color;

import de.timonexus.planora.utils.enums.Colors;

public enum ToastType {

    SUCCESS(Colors.PRIMARY.getColor(), "Erfolgreich"),
    ERROR(Colors.ERROR.getColor(), "Fehler"),
    INFO(Colors.PRIMARY.getColor(), "Information"),
    WARNING(new Color(230, 170, 70), "Achtung");

    private final Color color;
    private final String title;

    ToastType(Color color, String title) {
        this.color = color;
        this.title = title;
    }

    public Color getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }
}