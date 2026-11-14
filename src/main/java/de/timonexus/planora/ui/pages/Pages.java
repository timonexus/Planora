package de.timonexus.planora.ui.pages;

import javax.swing.JLabel;

import de.timonexus.planora.utils.enums.Icons;

public enum Pages {

    STARTSEITE("Startseite", Icons.STARTSEITE, new PlanoraHome()),
    KALENDER("Kalender", Icons.STARTSEITE, new PlanoraHome()),
    DIENST("Dienst", Icons.STARTSEITE, new PlanoraDuties()),


    EINSTELLUNGEN("Einstellungen", Icons.STARTSEITE, new PlanoraHome()),
    SUPPORT("Support", Icons.STARTSEITE, new PlanoraDuties()),
    ANLEITUNG("Anleitung", Icons.STARTSEITE, new PlanoraHome()),
    ;

    private final String name;
    private final Icons icon;
    private final DefaultPage page;

    private Pages(String name, Icons icon, DefaultPage page) {
        this.name = name;
        this.icon = icon;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public JLabel getIconLabel() {
        return icon.getIconLabel();
    }

    public DefaultPage getPage() {
        return page;
    }
}
