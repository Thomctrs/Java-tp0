package com.example.tp1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livres")
public class Livre {
    private @Id @GeneratedValue Long id;
    private String titre;
    private String auteur;
    private String description;
    private String edition;

    // Constructeurs
    public Livre() {
    }
    
    public Livre( String titre, String auteur, String edition, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    
