package com.example.tp1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class WebController {
    
    // annotation
    @RequestMapping("/")
    public String index(Model model) {  //model = partie back
        return "index"; // index = partie front
    }

    @RequestMapping("/catalogue")
    public String catalogue(Model model) {  //model = partie back
        // Création d'une liste de livres fictive
        List<Livre> livres = new ArrayList<>();
        livres.add(new Livre("Titre du Livre 1", "Auteur 1", "Édition 1", "Description du Livre 1"));
        livres.add(new Livre("Titre du Livre 2", "Auteur 2", "Édition 2", "Description du Livre 2"));
        livres.add(new Livre("Titre du Livre 3", "Auteur 3", "Édition 3", "Description du Livre 3"));

        // Ajout de la liste de livres au modèle
        model.addAttribute("livres", livres);
        return "catalogue"; // index = partie front
    }

    @RequestMapping("/emprunt")
    public String emprunt(Model model) {  //model = partie back
        return "emprunt"; // index = partie front
    }

    @PostMapping("/submit")
    static String result(@RequestParam("nomEmprunteur") String nomEmprunteur, 
                        @RequestParam("numeroEmprunteur") String numeroEmprunteur, 
                        @RequestParam("titreLivre") String titreLivre, 
                        @RequestParam("editionLivre") String editionLivre, 
                        @RequestParam("dateDebutEmprunt") Date dateDebutEmprunt, 
                     Model model) 
    {
        model.addAttribute("nomEmprunteur", nomEmprunteur);
        model.addAttribute("numeroEmprunteur", numeroEmprunteur);
        model.addAttribute("titreLivre", titreLivre);
        model.addAttribute("editionLivre", editionLivre);
        model.addAttribute("dateDebutEmprunt", dateDebutEmprunt);

        return "confirmation";
    }

 
}
