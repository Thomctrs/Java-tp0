package com.example.tp1;

import java.sql.Date;

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
