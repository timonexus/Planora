package de.timonexus.planora.ui.formulars.Dienste.dienstAnlegenBody;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.models.Models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.models.tableModels.utilTables.DienstAusbilder_UTM;
import de.timonexus.planora.repositorys.AusbilderRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.repositorys.utilRepositorys.DienstAusbilder_UR;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.service.utilServices.DienstAusbilder_US;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.table.Table;

public class SecondStep extends JPanel implements Component {

    private final int dienstId;
    private final boolean isNew;

    private final Repository repositoryDienstAusbilder;
    private final DefaultPageService service;

    private final Table table;

    public SecondStep(int dienstId, boolean isNew) {

        this.dienstId = dienstId;
        this.isNew = isNew;

        this.repositoryDienstAusbilder = new DienstAusbilder_UR();
        this.service = new DienstAusbilder_US();

        this.table = new Table(
            new Model[0],
            new DienstAusbilder_UTM(),
            this.service
        );

        this.table.setId(dienstId);
    }

    private void fillDatabase() {

        Repository repositoryAusbilder = new AusbilderRepository();

        Model[] ausbilder = repositoryAusbilder.loadAll(dienstId);

        for (Model model : ausbilder) {

            Ausbilder ausbilderTemp = (Ausbilder) model;

            repositoryDienstAusbilder.safe(
                new DienstAusbilder_UM(
                    0,
                    dienstId,
                    ausbilderTemp.getID(),
                    false,
                    false
                )
            );
        }
    }

    private void loadTableData() {
        Model[] models = service.loadAll(dienstId);
        table.refresh(models);
    }

    @Override
    public void designComponent() {
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
    }

    @Override
    public void skinParts() {
    }

    @Override
    public void addParts() {
    }

    @Override
    public void prepareComponents() {

        if (isNew) {
            fillDatabase();
        }

        loadTableData();

        table.prepareComponent();
    }

    @Override
    public void addComponents() {
        removeAll();
        add(table, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        loadTableData();
        revalidate();
        repaint();
    }
}