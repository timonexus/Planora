
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

    private JScrollPane scrollPane;
    private JPanel contentPanel;

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
    }

    @Override
    public void refresh() {
        this.fillTable();
    }

    private void fillTable() {

        // Aktuelle Scrollposition sichern
        Point scrollPosition = this.scrollPane != null
                ? this.scrollPane.getViewport().getViewPosition()
                : new Point(0, 0);

        this.removeAll();

        if (this.lines == null || this.lines.length == 0) {

            this.scrollPane = null;
            this.contentPanel = null;

            this.setLayout(new GridBagLayout());
            this.add(new TableIsEmpty(), new GridBagConstraints());

        } else {

            this.setLayout(new BorderLayout());

            this.contentPanel = new JPanel();
            this.contentPanel.setOpaque(false);
            this.contentPanel.setLayout(
                    new BoxLayout(this.contentPanel, BoxLayout.Y_AXIS)
            );

            this.tableLineList = new TableLineList();

            for (Model model : this.lines) {

                TableLine currentTableLine = new TableLine(
                        model,
                        this.tableModel,
                        this.service,
                        this.selectedLines.contains(model.getID())
                                || this.selectedLines.contains(-1)
                );

                currentTableLine.setOpaque(false);

                this.contentPanel.add(currentTableLine);
                this.tableLineList.einfügen(currentTableLine);
            }

            this.scrollPane = new JScrollPane(this.contentPanel);

            this.scrollPane.setOpaque(false);
            this.scrollPane.getViewport().setOpaque(false);
            this.scrollPane.setBorder(null);

            this.scrollPane.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
            );

            this.scrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            );

            this.configureScrollBar();

            this.add(this.scrollPane, BorderLayout.CENTER);
        }

        this.revalidate();
        this.repaint();

        // Scrollposition nach dem Layout wiederherstellen
        if (this.scrollPane != null) {
            SwingUtilities.invokeLater(() -> {
                this.scrollPane.getViewport().setViewPosition(scrollPosition);
            });
        }
    }

    private void configureScrollBar() {

        JScrollBar verticalBar = this.scrollPane.getVerticalScrollBar();

        verticalBar.setPreferredSize(new Dimension(5, 0));
        verticalBar.setOpaque(false);
        verticalBar.setBackground(Colors.APP_BAR.getColor());

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

    // Scrollposition auslesen
    public Point getScrollPosition() {
        if (this.scrollPane == null) {
            return new Point(0, 0);
        }

        return this.scrollPane.getViewport().getViewPosition();
    }

    // Scrollposition setzen
    public void setScrollPosition(Point position) {
        if (this.scrollPane == null || position == null) {
            return;
        }

        SwingUtilities.invokeLater(() -> {
            this.scrollPane.getViewport().setViewPosition(position);
        });
    }

    // Neue Daten setzen
    public void setLines(Model[] lines) {
        this.lines = lines;
        this.refresh();
    }
}
