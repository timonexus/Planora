package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.tableModels.TableModel;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.tableLineList.TableLineList;
import de.timonexus.planora.utils.enums.Colors;

public class TableBody extends JPanel implements Component{

    // attributes
    private Model[] lines;
    private final TableModel tableModel;
    private TableLineList tableLineList;
    private final DefaultPageService service;
    private final List<Integer> selectedLines;

    // constructor
    public TableBody(Model[] nLines, TableModel nTableModel, DefaultPageService nService, List<Integer> nSelectedLines){
        this.lines = nLines;
        this.tableModel = nTableModel;
        this.service = nService;
        this.selectedLines = nSelectedLines;

        this.tableLineList = new TableLineList();
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
	}

	@Override
	public void skinParts() {
        fillTable();
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
	}

    private void fillTable() {
        this.removeAll();
        this.setLayout(new BorderLayout());

        if (lines.length == 0) {
            this.setLayout(new GridBagLayout());
            this.add(new TableIsEmpty(), new GridBagConstraints());
        } else {
            JPanel contentPanel = new JPanel();
            contentPanel.setOpaque(false);
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

            this.tableLineList = new TableLineList();

            for (Model model : lines) {
                TableLine currentTableLine = new TableLine(
                    model,
                    this.tableModel,
                    this.service,
                    this.selectedLines.contains(model.getID())
                        || this.selectedLines.contains(-1)
                );

                currentTableLine.setOpaque(false);
                contentPanel.add(currentTableLine);
                this.tableLineList.einfügen(currentTableLine);
            }

            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);

            // Scrollbar konfigurieren
            scrollPane.setBorder(null);
            scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
            );
            scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            );

            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
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

            this.add(scrollPane, BorderLayout.CENTER);
        }

        this.revalidate();
        this.repaint();
    }
    
}
