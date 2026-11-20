
package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.LayeredPane;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Logo;

public class PlanoraFrame extends JFrame implements Frame {

    // attributes
    private final Component sidebar;
    private DefaultPage page;
    private final LayeredPane formularPane;

    // constructor
    public PlanoraFrame() {

        this.sidebar = new PlanoraSidebar(this);

        this.page = loadActivePage();
        this.page.setFrame(this);

        this.formularPane = new LayeredPane();

        this.formularPane.prepareComponent();

        // Formular-Ebene über den gesamten Inhalt legen
        this.setGlassPane(this.formularPane);

        // Anfangs ist das Formular ausgeblendet
        this.formularPane.setVisible(false);
    }

    @Override
    public void skinFrame() {

        this.setTitle(
            (String) FrameValues.TITLE.getValue()
        );

        this.setSize(
            (int) FrameValues.WIDTH.getValue(),
            (int) FrameValues.HEIGHT.getValue()
        );

        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(
            Colors.BASE.getColor()
        );

        this.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        this.setIconImage(
            Logo.DEFAULT_LOGO.getImageForTaskbar()
        );

        this.setLayout(new BorderLayout());
    }

    @Override
    public void prepareComponents() {

        this.sidebar.prepareComponent();
        this.page.preparePage();
    }

    @Override
    public void addComponents() {

        this.add(
            (JPanel) this.sidebar,
            BorderLayout.WEST
        );

        this.add(
            (JPanel) this.page,
            BorderLayout.CENTER
        );
    }

    @Override
    public void refresh() {

        DefaultPage newPage = loadActivePage();

        if (newPage == this.page) {
            return;
        }

        if (this.page != null) {
            this.remove((JPanel) this.page);
        }

        this.page = newPage;

        this.page.setFrame(this);
        this.page.preparePage();

        this.add(
            (JPanel) this.page,
            BorderLayout.CENTER
        );

        this.revalidate();
        this.repaint();

        this.sidebar.refresh();
    }

    // --------------------------------------------------
    // Getter
    // --------------------------------------------------

    public Component getSidebar() {
        return this.sidebar;
    }

    public DefaultPage getPage() {
        return this.page;
    }

    // --------------------------------------------------
    // Setter
    // --------------------------------------------------

    @Override
    public void setPage(DefaultPage page) {
        this.page = page;
    }

    // --------------------------------------------------
    // Page
    // --------------------------------------------------

    private DefaultPage loadActivePage() {

        Pages pages = Pages.getActivePage();

        return pages.getPage();
    }

    // --------------------------------------------------
    // Formular
    // --------------------------------------------------

    public void showFormularPane(Formular nFormular) {

        this.formularPane.setFormular(
            (javax.swing.JComponent) nFormular
        );

        this.formularPane.setVisible(true);

        this.formularPane.revalidate();
        this.formularPane.repaint();
    }

    public void hideFormularPane() {

        this.formularPane.setVisible(false);

        this.formularPane.removeFormular();
    }
}
