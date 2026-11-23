
package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableLineList.TableLineList;
import de.timonexus.planora.utils.enums.Colors;

public class TableBody extends JPanel implements Component {

    // Attributes
    private Model[] lines;

    private final TableModel tableModel;
    private TableLineList tableLineList;

    private final DefaultPageService service;
    private final List<Integer> selectedLines;

    private final JScrollPane scrollPane;
    private final JPanel contentPanel;

    // Constructor
    public TableBody(
            Model[] nLines,
            TableModel nTableModel,
            DefaultPageService nService,
            List<Integer> nSelectedLines
    ) {
        this.lines = nLines;
        this.tableModel = nTableModel;
        this.service = nService;
        this.selectedLines = nSelectedLines;

        this.tableLineList = new TableLineList();

        this.contentPanel = new JPanel();
        this.contentPanel.setOpaque(false);
        this.contentPanel.setLayout(
                new BoxLayout(this.contentPanel, BoxLayout.Y_AXIS)
        );

        this.scrollPane = new JScrollPane(this.contentPanel);

        this.configureScrollPane();
    }

    @Override
    public void designComponent() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void skinParts() {
        this.fillTable();
    }

    @Override
    public void addParts() {
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
        this.removeAll();
        this.add(this.scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        this.fillTable();
    }

    private void configureScrollPane() {

        this.scrollPane.setOpaque(false);
        this.scrollPane.getViewport().setOpaque(false);
        this.scrollPane.setBorder(null);

        this.scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        this.scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        this.scrollPane.setWheelScrollingEnabled(true);

        // Scrollbar
        JScrollBar verticalBar = this.scrollPane.getVerticalScrollBar();

        verticalBar.setPreferredSize(new Dimension(5, 0));
        verticalBar.setOpaque(false);
        verticalBar.setBackground(Colors.APP_BAR.getColor());

        verticalBar.setUnitIncrement(30);
        verticalBar.setBlockIncrement(200);

        verticalBar.setUI(new BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Colors.TEXT_DISABLED.getColor();
                this.trackColor = Colors.APP_BAR.getColor();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();

                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));

                return button;
            }
        });
    }

    private void fillTable() {

        Point oldPosition = this.getScrollPosition();

        this.contentPanel.removeAll();
        this.tableLineList = new TableLineList();

        if (this.lines == null || this.lines.length == 0) {

            JPanel emptyPanel = new JPanel(new GridBagLayout());
            emptyPanel.setOpaque(false);

            emptyPanel.add(
                    new TableIsEmpty(),
                    new GridBagConstraints()
            );

            this.contentPanel.add(emptyPanel);

        } else {

            for (Model model : this.lines) {

                TableLine currentTableLine = new TableLine(
                        model,
                        this.tableModel,
                        this.service,
                        this.selectedLines.contains(model.getID())
                                || this.selectedLines.contains(-1)
                );

                currentTableLine.setOpaque(false);

                currentTableLine.setAlignmentX(LEFT_ALIGNMENT);

                this.contentPanel.add(currentTableLine);
                this.tableLineList.einfügen(currentTableLine);
            }
        }

        this.contentPanel.revalidate();
        this.contentPanel.repaint();

        this.scrollPane.revalidate();
        this.scrollPane.repaint();

        SwingUtilities.invokeLater(() -> {
            this.restoreScrollPosition(oldPosition);
        });
    }

    // Restore scroll position
    private void restoreScrollPosition(Point position) {

        if (position == null) {
            return;
        }

        //JScrollBar bar = this.scrollPane.getVerticalScrollBar();

        int maxY = Math.max(
                0,
                this.contentPanel.getHeight()
                        - this.scrollPane.getViewport().getHeight()
        );

        int y = Math.min(position.y, maxY);

        this.scrollPane.getViewport().setViewPosition(
                new Point(0, y)
        );
    }

    // Get scroll position
    public Point getScrollPosition() {
        return this.scrollPane.getViewport().getViewPosition();
    }

    // Set scroll position
    public void setScrollPosition(Point position) {

        if (position == null) {
            return;
        }

        SwingUtilities.invokeLater(() -> {
            this.restoreScrollPosition(position);
        });
    }

    // Set new lines
    public void setLines(Model[] lines) {
        this.lines = lines;
        this.refresh();
    }

    // Get table line list
    public TableLineList getTableLineList() {
        return this.tableLineList;
    }
}
