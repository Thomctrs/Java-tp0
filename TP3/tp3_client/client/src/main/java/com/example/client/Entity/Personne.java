package com.example.client.Entity;

public class Personne {
    private long id;
    private String nom; 
    
    private String email;

    public Personne() {
    }
    
    public Personne(long id, String nom,  String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

   

    public String getEmail() {
        return this.email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
