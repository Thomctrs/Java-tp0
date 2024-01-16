package com.example.tp0;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WebController {
/* un controleur fait le lien entre back et front , a chaque requete la fonction est executée  */

    // annotation
    @RequestMapping("/")
    public String home(Model model) {  //model = partie back
        return "index"; // index = partie front
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        return "form";
    }
    @PostMapping("/submit")
    static String result(@RequestParam("name") String name, 
                        @RequestParam("email") String email, 
                     Model model) 
    {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "result";
    }
 
    
    
}
