package de.timonexus.planora.models.Models;

import de.timonexus.planora.models.Model;

public class Abzeichen implements Model{

    // attribute
    private final int id;
    private String abzeichenName;
    private int themenAnzahl;

    // constructor 
    public Abzeichen(int nId, String nAbzeichenName, int nThemenAnzahl){
        this.id = nId;
        this.themenAnzahl = nThemenAnzahl;
        this.abzeichenName = nAbzeichenName;
    }

    // setter
    public String getAbzeichenName() {
        return abzeichenName;
    }
    public int getThemenAnzahl() {
        return themenAnzahl;
    }

    // setter
    public void setAbzeichenName(String abzeichenName) {
        this.abzeichenName = abzeichenName;
    }
    public void setThemenAnzahl(int themenAnzahl) {
        this.themenAnzahl = themenAnzahl;
    }

    @Override
    public int getID() {
        return this.id;
    }
    
}
