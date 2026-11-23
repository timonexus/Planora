package de.timonexus.planora.models.Models.utilModels;

import de.timonexus.planora.models.Model;

public class DienstAusbilder_UM implements Model{

    // attribute
    private final int id;
    private final int idDienst;
    private final int idAusbilder;
    private final String ausbilderName;
    private boolean participationYounger;
    private boolean participationOlder;
    private boolean participationWhole;

    // constructor
    public DienstAusbilder_UM(int nId, int nIdDienst, int nIdAusbilder, boolean nParticipationYounger, boolean nParticipationOlder){
        this(nId, nIdDienst, nIdAusbilder, "", nParticipationYounger, nParticipationOlder);
    }

    public DienstAusbilder_UM(int nId, int nIdDienst, int nIdAusbilder, String nAusbilderName, boolean nParticipationYounger, boolean nParticipationOlder){
        this.id = nId;
        this.idDienst = nIdDienst;
        this.idAusbilder = nIdAusbilder;
        this.ausbilderName = nAusbilderName;
        this.participationYounger = nParticipationYounger;
        this.participationOlder = nParticipationOlder;

        setParticitpationWhole();
    }

    // method for setting the whole
    private void setParticitpationWhole(){
        if(participationOlder && participationYounger){
            this.participationWhole = true;
        }else{
            this.participationWhole = false;
        }
    }

    // method to set participation variables
    private void setParticipations(){
        if(this.participationWhole){
            this.participationOlder = true;
            this.participationYounger = true;
        }
    }


    // getter
    public int getIdAusbilder() {
        return idAusbilder;
    }
    public int getIdDienst() {
        return idDienst;
    }
    public boolean isParticipationOlder() {
        return participationOlder;
    }
    public boolean isParticipationWhole() {
        return participationWhole;
    }
    public boolean isParticipationYounger() {
        return participationYounger;
    }
    public String getAusbilderName() {
        return ausbilderName;
    }
	@Override
	public int getID() {
        return this.id;
	}

    // setter
    public void setParticipationOlder(boolean participationOlder) {
        this.participationOlder = participationOlder;
        setParticitpationWhole();
    }
    public void setParticipationWhole(boolean participationWhole) {
        this.participationWhole = participationWhole;
        setParticipations();
    }
    public void setParticipationYounger(boolean participationYounger) {
        this.participationYounger = participationYounger;
        setParticitpationWhole();
    }
    
}
