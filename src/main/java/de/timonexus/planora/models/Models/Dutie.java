package de.timonexus.planora.models.Models;

import de.timonexus.planora.models.Model;

public class Dutie implements Model{

    // attributes
    private final int id;
    private String date;
    private String uhrzeit_kleine;
    private String uhrzeit_große;
    private String anzahlBetreuer;

    // constructor
    public Dutie(int nId, String nDate, String nUhrzeit_kleine, String nUhrzeit_große, String nAnzahlBetreuer){
        this.id = nId;
        this.date = nDate;
        this.uhrzeit_kleine = nUhrzeit_kleine;
        this.uhrzeit_große = nUhrzeit_große;
        this.anzahlBetreuer = nAnzahlBetreuer;
    }


    // getter
    public String getDate() {
        return date;
    }
	@Override
	public int getID() {
        return this.id;
	}
    public String getAnzahlBetreuer() {
        return anzahlBetreuer;
    }
    public String getUhrzeit_große() {
        return uhrzeit_große;
    }
    public String getUhrzeit_kleine() {
        return uhrzeit_kleine;
    }

    // setter
    public void setDate(String nDate) {
        this.date = nDate;
    }
    public void setAnzahlBetreuer(String anzahlBetreuer) {
        this.anzahlBetreuer = anzahlBetreuer;
    }
    public void setUhrzeit_große(String uhrzeit_große) {
        this.uhrzeit_große = uhrzeit_große;
    }
    public void setUhrzeit_kleine(String uhrzeit_kleine) {
        this.uhrzeit_kleine = uhrzeit_kleine;
    }
}
