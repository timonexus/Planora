
package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.LayeredPane;
import de.timonexus.planora.ui.frame.frameHeader.FrameHeader;
import de.timonexus.planora.ui.frame.frameHeader.FrameResizer;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.PlanoraSidebar;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Logo;

public class PlanoraFrame extends JFrame implements Frame {

    // attributes
    private final Component sidebar;
    private final FrameHeader header;
    private DefaultPage page;
    private final LayeredPane formularPane;
    private FrameResizer frameResizer;
    private final WindowAnimator windowAnimator;

    // constructor
    public PlanoraFrame() {

        this.sidebar = new PlanoraSidebar(this);
        this.windowAnimator = new WindowAnimator(this);
        this.header = new FrameHeader(this, this.windowAnimator);
        this.frameResizer = new FrameResizer(this, () -> {
            this.sidebar.refresh();
            this.page.refresh();

            this.revalidate();
            this.repaint();
        });

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

        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateWindowShape();
            }
        });

        this.updateWindowShape();

        this.setLayout(new BorderLayout());
    }

    private void updateWindowShape() {
        int width = this.getWidth();
        int height = this.getHeight();

        if (width > 0 && height > 0) {
            this.setShape(new RoundRectangle2D.Double(
                0,
                0,
                width,
                height,
                24,
                24
            ));
        }
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

        this.add(this.header, BorderLayout.NORTH);
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

    public void openWindow(){
        this.windowAnimator.open();
    }
}
