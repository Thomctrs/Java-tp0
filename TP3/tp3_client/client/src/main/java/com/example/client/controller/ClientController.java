package com.example.client.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.client.Entity.Personne;

import java.util.List;


@Controller
public class ClientController {
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes";
        ResponseEntity<List<Personne>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Personne>>() {});
        List<Personne> personnes = response.getBody();
        model.addAttribute("personnes", personnes);
        return "index";
    }

    @GetMapping("/personnes/{id}")
    public String getPersonne(Model model, @PathVariable long id){
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes/{id}";
        ResponseEntity<Personne> response = restTemplate.getForEntity(url, Personne.class, id);
        Personne personne = response.getBody();
        model.addAttribute("personne", personne);
        return "personne";
    }
    
    @GetMapping("/personnes/form/add")
    public String formPersonne(Model model) {
        Personne personne = new Personne();
        model.addAttribute("personne", personne);
        return "formulaire";
    }
    
    @GetMapping("/personnes/maj/{id}")
    public String majPersonne(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes/{id}";
        ResponseEntity<Personne> response = restTemplate.getForEntity(url, Personne.class, id);
        Personne personne = response.getBody();
        model.addAttribute("personne", personne);
        return "formulaire";
    }

    @GetMapping("/personnes/del/{id}")
    public String delPersonne(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes/{id}";
        restTemplate.delete(url, id);
        return "redirect:/";
    }

    @PostMapping("/personnes/maj/{id}")
    public String updatePersonne(@ModelAttribute("personne") Personne personne, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Personne> request = new HttpEntity<>(personne, headers);
        ResponseEntity<Personne> response = restTemplate.exchange(url, HttpMethod.PUT, request, Personne.class, id);
        return "redirect:/";
    }

    @PostMapping("/personnes/form/add")
    public String addPersonne(@ModelAttribute("personne") Personne personne) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/personnes";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Personne> request = new HttpEntity<>(personne, headers);
        ResponseEntity<Personne> response = restTemplate.postForEntity(url, request, Personne.class);
        return "redirect:/";
    }
}
