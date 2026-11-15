
package de.timonexus.planora.ui.sidebar.header;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;
import de.timonexus.planora.utils.enums.Logo;

public class PlanoraSidebarHeader extends JPanel implements Component {

    // Attributes
    private final RoundedPanel basePanel;
    private final JPanel labelPanel;
    private final JLabel labelPlanora;
    private final JPanel iconPanel;
    private final JLabel labelIcon;

    // Constructor
    public PlanoraSidebarHeader() {
        this.basePanel = new RoundedPanel();
        this.labelPanel = new JPanel();
        this.labelPlanora = new JLabel();
        this.iconPanel = new JPanel();
        this.labelIcon = Logo.DEFAULT_LOGO.getIconLabel();
    }

    @Override
    public void designComponent() {
        setOpaque(false);
        setPreferredSize(new Dimension(
                (int) PlanoraSidebarHeaderValues.WIDTH.getValue(),
                (int) PlanoraSidebarHeaderValues.HEIGHT.getValue()
        ));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 25, 20));
        setLayout(new BorderLayout());
    }

    @Override
    public void skinParts() {
        skinBasePanel();
        skinLabelPanel();
        skinLabelPlanora();
        skinIconPanel();
        skinLabelIcon();
    }

    @Override
    public void addParts() {
        labelPanel.add(labelPlanora, BorderLayout.CENTER);
        iconPanel.add(labelIcon, BorderLayout.CENTER);

        basePanel.add(iconPanel, BorderLayout.WEST);
        basePanel.add(labelPanel, BorderLayout.CENTER);

        add(basePanel, BorderLayout.CENTER);
    }

    @Override
    public void prepareComponents() {}

    @Override
    public void addComponents() {}

    private void skinBasePanel() {
        basePanel.setBackground(Colors.MENUES.getColor());
        basePanel.setRoundedBorder(
                Colors.DIALOGS.getColor(),
                1,
                BorderPlacement.OUTSIDE
        );
        basePanel.setRadius(15);
        basePanel.setLayout(new BorderLayout());
    }

    private void skinLabelPanel() {
        labelPanel.setPreferredSize(new Dimension(140, 50));
        labelPanel.setOpaque(false);
        labelPanel.setLayout(new BorderLayout());
    }

    private void skinLabelPlanora() {
        labelPlanora.setText("Planora");
        labelPlanora.setForeground(Colors.TEXT.getColor());
        labelPlanora.setFont(Fonts.LOGO.loadFont());
        labelPlanora.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void skinIconPanel() {
        iconPanel.setPreferredSize(new Dimension(55, 50));
        iconPanel.setOpaque(false);
        iconPanel.setLayout(new BorderLayout());
    }

    private void skinLabelIcon() {
        labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
        labelIcon.setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void refresh() {
        // Currently no dynamic content to refresh.
    }
}
