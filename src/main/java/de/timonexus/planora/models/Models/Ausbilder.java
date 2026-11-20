package de.timonexus.planora.models.Models;

import java.util.List;

import de.timonexus.planora.models.Model;

public class Ausbilder implements Model{

    // attributes
    private final int id;
    private String name;
    private List<Integer> vorliebenIds;

    public Ausbilder(int nId, String nName, List<Integer> nVorliebenIds){
        this.id = nId;
        this.name = nName;
        this.vorliebenIds = nVorliebenIds;
    }

    // getter
    public String getName() {
        return name;
    }
    public List<Integer> getVorliebenIds() {
        return vorliebenIds;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    public void setVorliebenIds(List<Integer> vorliebenIds) {
        this.vorliebenIds = vorliebenIds;
    }

	@Override
	public int getID() {
        return this.id;
	}
    
}
