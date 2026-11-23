package de.timonexus.planora.ui.formulars.Dienste.dienstAnlegenBody;

import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.repositorys.AusbilderRepository;
import de.timonexus.planora.repositorys.Repository;
import de.timonexus.planora.repositorys.utilRepositorys.DienstAusbilder_UR;
import de.timonexus.planora.ui.Component;

public class SecondStep extends JPanel implements Component{

    // attributes
    private final int dienstId;
    private final Repository repositoryDienstAusbilder;

    // constructor
    public SecondStep(int nDienstId){
        this.dienstId = nDienstId;

        this.repositoryDienstAusbilder = new DienstAusbilder_UR();

        fillDatabase();
    }

    // initialize Data
    private void fillDatabase() {

        Repository repositoryAusbilder = new AusbilderRepository();
        Model[] ausbilder = repositoryAusbilder.loadAll();

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
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
	}

	@Override
	public void skinParts() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'skinParts'");
	}

	@Override
	public void addParts() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addParts'");
	}

	@Override
	public void prepareComponents() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'prepareComponents'");
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addComponents'");
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'refresh'");
	}
    
}
