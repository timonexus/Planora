package de.timonexus.planora.ui.pages;

import javax.swing.JLabel;

import de.timonexus.planora.ui.pages.Badges.PlanoraBadges;
import de.timonexus.planora.ui.pages.Calendar.PlanoraCalendar;
import de.timonexus.planora.ui.pages.Categories.PlanoraCategories;
import de.timonexus.planora.ui.pages.Dienste.PlanoraDuties;
import de.timonexus.planora.ui.pages.Groups.PlanoraGroups;
import de.timonexus.planora.ui.pages.Help.PlanoraHelp;
import de.timonexus.planora.ui.pages.Home.PlanoraHome;
import de.timonexus.planora.ui.pages.Settings.PlanoraSettings;
import de.timonexus.planora.ui.pages.Support.PlanoraSupport;
import de.timonexus.planora.ui.pages.Teachers.PlanoraTeachers;
import de.timonexus.planora.ui.pages.Topics.PlanoraTopics;
import de.timonexus.planora.ui.pages.TrainingEvents.PlanoraTrainingEvents;
import de.timonexus.planora.utils.enums.Icons;

public enum Pages {

    STARTSEITE("Startseite", Icons.STARTSEITE_BRIGHT, Icons.STARTSEITE_DARK, new PlanoraHome(), true),
    KALENDER("Kalender", Icons.CALENDAR_BRIGHT, Icons.CALENDAR_DARK, new PlanoraCalendar(), false),
    DIENST("Dienste", Icons.DUTIE_BRIGHT, Icons.DUTIE_DARK, new PlanoraDuties(), false),
    AUSBILDUNGEN("Ausbildungen", Icons.TRAININGEVENTS_BRIGHT, Icons.TRAININGEVENTS_DARK, new PlanoraTrainingEvents(), false),
    KATEGORIEN("Kategorien", Icons.CATEGORIES_BRIGHT, Icons.CATEGORIES_DARK, new PlanoraCategories(), false),
    THEMEN("Themen", Icons.TOPICS_BRIGHT, Icons.TOPICS_DARK, new PlanoraTopics(), false),
    GRUPPEN("Gruppen",Icons.GROUPS_BRIGHT, Icons.GROUPS_DARK, new PlanoraGroups(), false),
    AUSBILDER("Ausbilder", Icons.TEACHER_BRIGHT, Icons.TEACHER_DARK, new PlanoraTeachers(), false),
    ABZEICHEN("Abzeichen", Icons.BAGDES_BRIGHT, Icons.BADGES_DARK, new PlanoraBadges(), false),


    EINSTELLUNGEN("Einstellungen", Icons.SETTINGS_BRIGHT, Icons.SETTINGS_DARK, new PlanoraSettings(), false),
    SUPPORT("Support", Icons.SUPPORT_BRIGHT, Icons.SUPPORT_DARK, new PlanoraSupport(), false),
    ANLEITUNG("Anleitung", Icons.HELP_BRIGHT, Icons.HELP_DARK, new PlanoraHelp(), false),
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
