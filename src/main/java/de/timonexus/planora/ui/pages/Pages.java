package de.timonexus.planora.ui.pages;

import javax.swing.JLabel;

import de.timonexus.planora.ui.pages.Dienste.PlanoraDuties;
import de.timonexus.planora.utils.enums.Icons;

public enum Pages {

    STARTSEITE("Startseite", Icons.STARTSEITE_BRIGHT, Icons.STARTSEITE_DARK, new PlanoraHome(), true),
    KALENDER("Kalender", Icons.CALENDAR_BRIGHT, Icons.CALENDAR_DARK, new PlanoraHome(), false),
    DIENST("Dienste", Icons.DUTIE_BRIGHT, Icons.DUTIE_DARK, new PlanoraDuties(), false),
    AUSBILDUNGEN("Ausbildungen", Icons.TRAININGEVENTS_BRIGHT, Icons.TRAININGEVENTS_DARK, new PlanoraTrainingEvents(), false),
    KATEGORIEN("Kategorien", Icons.CATEGORIES_BRIGHT, Icons.CATEGORIES_DARK, new PlanoraDuties(), false),
    THEMEN("Themen", Icons.TOPICS_BRIGHT, Icons.TOPICS_DARK, new PlanoraDuties(), false),
    GRUPPEN("Gruppen",Icons.GROUPS_BRIGHT, Icons.GROUPS_DARK, new PlanoraDuties(), false),
    AUSBILDER("Ausbilder", Icons.TEACHER_BRIGHT, Icons.TEACHER_DARK, new PlanoraTeachers(), false),
    ABZEICHEN("Abzeichen", Icons.BAGDES_BRIGHT, Icons.BADGES_DARK, new PlanoraHome(), false),


    EINSTELLUNGEN("Einstellungen", Icons.SETTINGS_BRIGHT, Icons.SETTINGS_DARK, new PlanoraHome(), false),
    SUPPORT("Support", Icons.SUPPORT_BRIGHT, Icons.SUPPORT_DARK, new PlanoraDuties(), false),
    ANLEITUNG("Anleitung", Icons.HELP_BRIGHT, Icons.HELP_DARK, new PlanoraHome(), false),
    ;

    private final String name;
    private final Icons icon_bright;
    private final Icons icon_dark;
    private final DefaultPage page;
    private boolean active;

    private Pages(String name, Icons icon_bright, Icons icon_dark, DefaultPage page, boolean active) {
        this.name = name;
        this.icon_bright = icon_bright;
        this.icon_dark = icon_dark;
        this.page = page;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public JLabel getIconLabel_bright() {
        return icon_bright.getIconLabel();
    }
    public JLabel getIconLabel_dark() {
        return icon_dark.getIconLabel();
    }

    public DefaultPage getPage() {
        return page;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


    public static void deactivateAll() {
        for (Pages page : Pages.values()) {
            page.setActive(false);
        }
    }

    public static Pages getActivePage() {
        for (Pages page : Pages.values()) {
            if (page.isActive()) {
                return page;
            }
        }

        return null;
    }
}
