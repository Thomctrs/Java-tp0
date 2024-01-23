package com.example.tp1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprunteurs")
public class Emprunteur {
    private @Id @GeneratedValue Long id;
    private String nom;
    private String numero;
   

    // Constructeurs
    public Emprunteur() {
    }

    public Emprunteur( String nom, String numero){
        
        this.nom = nom;
        this.numero = numero;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
