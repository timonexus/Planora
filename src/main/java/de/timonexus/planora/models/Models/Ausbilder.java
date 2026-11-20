package de.timonexus.planora.models.Models;

import de.timonexus.planora.models.Model;

public class Ausbilder implements Model{

    // attributes
    private final int id;
    private String name;

    public Ausbilder(int nId, String nName){
        this.id = nId;
        this.name = nName;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public int getID() {
        return this.id;
	}
    
}
