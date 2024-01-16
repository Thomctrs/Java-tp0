package com.example.tp1;

public class Livre {
    private String titre;
    private String auteur;
    private String edition;
    private String description;

    // Constructeurs
    public Livre() {
    }

    public Livre(String titre, String auteur, String edition, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.description = description;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
