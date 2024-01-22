package com.example.tp1;

public class Emprunteur {
    private String id;
    private String nom;
    private String numero;
   

    // Constructeurs
    public Emprunteur() {
    }

    public Emprunteur(String id, String nom, String numero){
        this.id = id;
        this.nom = nom;
        this.numero = numero;
    }
    // Getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
