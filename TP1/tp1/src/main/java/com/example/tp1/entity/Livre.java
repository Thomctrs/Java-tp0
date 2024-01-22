package com.example.tp1.entity;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String description;
    private String edition;

    // Constructeurs
    public Livre() {
    }
    
    public Livre(int id, String titre, String auteur, String edition, String description) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
    
