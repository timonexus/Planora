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

public class SecondStep extends JPanel implements Component{

    // attributes
    private final int dienstId;
    private final Repository repositoryDienstAusbilder;
	private final DefaultPageService service;
	private final Table table;
	private final DienstAusbilder_UTM tableModel;

    // constructor
    public SecondStep(int nDienstId, boolean isNew){

        this.dienstId = nDienstId;
        this.repositoryDienstAusbilder = new DienstAusbilder_UR();
		this.service = new DienstAusbilder_US();
		this.tableModel = new DienstAusbilder_UTM();
		this.table = new Table(this.service.loadAll(nDienstId), tableModel, service);
		this.table.setId(nDienstId);

		if(nDienstId != 0 && isNew){
			fillDatabase();
		}
    }

    // initialize Data
    private void fillDatabase() {
        Repository repositoryAusbilder = new AusbilderRepository();
        Model[] ausbilder = repositoryAusbilder.loadAll(this.dienstId);

        for (Model model : ausbilder) {
            Ausbilder ausbilder_temp = (Ausbilder) model;
            repositoryDienstAusbilder.safe(
                new DienstAusbilder_UM(
                    0,
                    dienstId,
                    ausbilder_temp.getID(),
                    false,
                    false
                )
            );
        }

		this.table.refresh(this.service.loadAll(this.dienstId));
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
		this.table.prepareComponent();
	}

	@Override
	public void addComponents() {
		this.add(this.table, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
		this.prepareComponent();
	}
    
}
