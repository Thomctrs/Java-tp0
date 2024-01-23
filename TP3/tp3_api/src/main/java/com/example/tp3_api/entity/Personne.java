package com.example.tp3_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "personnes")
public class Personne {
    private @Id @GeneratedValue Long id;
    private String nom;
    private String email;

    // Constructeur par défaut pour SPRING
    public Personne() {
    }

    // Constructeur surchargé pour initialiser les attributs
    public Personne(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
