package com.example.tp3_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp3_api.dao.PersonneRepository;
import com.example.tp3_api.entity.Personne;

@RestController
public class PersonneController {
    private final PersonneRepository repo; // final = cst

    public PersonneController(PersonneRepository pr) {
        this.repo = pr;
    }

    @GetMapping("/rest/personnes")
    public List<Personne> getPersonnes() {
        return repo.findAll();
    }

    @GetMapping("/rest/personnes/{id}") // {id} = variable
    public Personne getPersonne(@PathVariable long id) {
        return repo.findById(id).orElse(new Personne("Inconnu", "Inconnu"));
    }

    @PostMapping("/rest/personnes")
    public Personne addPersonne(@RequestBody Personne newPersonne) {
        return repo.save(newPersonne);
    }

    @PutMapping("/rest/personnes/{id}")
    public Personne updateFruit(@RequestBody Personne newPersonne, @PathVariable long id) {
        return repo.findById(id)
                .map(personne -> {
                    personne.setNom(newPersonne.getNom());
                    personne.setEmail(newPersonne.getEmail());
                    return repo.save(personne);
                })
                .orElseGet(() -> {
                    newPersonne.setId(id);
                    return repo.save(newPersonne);
                });
    }

    @DeleteMapping("/rest/personnes/{id}")
        public void delPersonne(@PathVariable long id){
        repo.deleteById(id);
}
}


