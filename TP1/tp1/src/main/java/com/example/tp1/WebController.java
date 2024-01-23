package com.example.tp1;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tp1.dao.LivreRepository;
import com.example.tp1.dao.EmprunteurRepository;
import com.example.tp1.entity.Emprunteur;
import com.example.tp1.entity.Livre;




@Controller
public class WebController {

    @Autowired
    private LivreRepository lr;

    @Autowired
    private EmprunteurRepository er;
    
    // annotation
    @RequestMapping("/")
    public String index(Model model) {  //model = partie back
        return "index"; // index = partie front
    }

    @GetMapping("/catalogue")
    public String showCatalog(Model model) {

        List<com.example.tp1.entity.Livre> livres = lr.findAll();
        model.addAttribute("livres", livres);
        return "catalogue";
    }
    

    @GetMapping("/formulaire")
    public String askBooking(Model model) {
        
        List<com.example.tp1.entity.Livre> livres = lr.findAll();
        List<Emprunteur> emprunteurs = er.findAll();

        model.addAttribute("livres", livres);
        model.addAttribute("emprunteurs", emprunteurs);

        return "formulaire";
    }
    @PostMapping("/emprunt")
    public String saveBooking(
        @RequestParam("choix_emprunteur") Long id_emprunteur,
        @RequestParam("choix_livre") Long id_livre,
        Model model){
            
        Emprunteur inconnu = new Emprunteur();
        inconnu.setNom("Inconnu");

        Livre livreInconnu = new Livre();
        livreInconnu.setTitre("Inconnu");

        Emprunteur emprunteur = er.findById(id_emprunteur).orElse(inconnu);
        Livre livre = lr.findById(id_livre).orElse(livreInconnu);

        model.addAttribute("qui", emprunteur.getNom());
        model.addAttribute("quoi", livre.getTitre());
        return "emprunt";
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
