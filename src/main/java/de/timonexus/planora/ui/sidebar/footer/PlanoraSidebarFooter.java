
package de.timonexus.planora.ui.sidebar.footer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.ui.sidebar.linksContainer.PlanoraSidebarLinksContainer;
import de.timonexus.planora.utils.ApplicationInfo;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSidebarFooter extends JPanel implements Component {

    // Attributes
    private final JPanel versionPanel;
    private final JLabel versionLabel;

    private final PlanoraSidebarLinksContainer links;

    // Constructor
    public PlanoraSidebarFooter(Service nPageService) {
        this.versionPanel = new JPanel();
        this.versionLabel = new JLabel();

        this.links = new PlanoraSidebarLinksContainer(
                List.of(
                        Pages.EINSTELLUNGEN,
                        Pages.SUPPORT,
                        Pages.ANLEITUNG
                ),
                0,
                nPageService
        );
    }

    @Override
    public void designComponent() {
        setPreferredSize(new Dimension(
                (int) PlanoraSidebarFooterValues.WIDTH.getValue(),
                (int) PlanoraSidebarFooterValues.HEIGHT.getValue()
        ));

        setOpaque((boolean) PlanoraSidebarFooterValues.OPAQUE.getValue());
        setLayout((LayoutManager) PlanoraSidebarFooterValues.LAYOUT.getValue());
        setBorder((Border) PlanoraSidebarFooterValues.BORDER.getValue());
    }

    @Override
    public void skinParts() {
        skinVersionPanel();
        skinVersionLabel();
    }

    @Override
    public void addParts() {
        versionPanel.add(versionLabel, BorderLayout.CENTER);
        add(versionPanel, BorderLayout.SOUTH);
    }

    @Override
    public void prepareComponents() {
        links.prepareComponent();
    }

    @Override
    public void addComponents() {
        add(links, BorderLayout.NORTH);
    }

    private void skinVersionPanel() {
        versionPanel.setPreferredSize(new Dimension(0, 20));
        versionPanel.setLayout(new BorderLayout());
        versionPanel.setOpaque(false);
    }

    private void skinVersionLabel() {
        versionLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        versionLabel.setForeground(Colors.TEXT_SECONDARY.getColor());

        versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        versionLabel.setVerticalAlignment(SwingConstants.CENTER);

        versionLabel.setText(
                ApplicationInfo.getName() + " " + ApplicationInfo.getVersion()
        );
    }

    @Override
    public void refresh() {
        this.links.refresh();
    }
}
