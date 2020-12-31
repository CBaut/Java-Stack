package com.codingdojo.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public HomeController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Dojo> allDojos = dojoService.findAllDojos();
        List<Ninja> allNinjas = ninjaService.findAllNinjas();
        model.addAttribute("dojos", allDojos);
        model.addAttribute("ninjas", allNinjas);
        return "index.jsp";
    }

    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "/dojos/new.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/new.jsp";
        } else {
            dojoService.createDojo(dojo);
            System.out.println("Dojo created successfully");
            return "redirect:/";
        }
    }

    @RequestMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojoById(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/show.jsp";
    }

    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> allDojos = dojoService.findAllDojos();
        model.addAttribute("dojos", allDojos);
        return "/ninjas/new.jsp;";
    }

    @PostMapping("/ninjas")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "/ninjas/new.jsp";
        } else {
            ninjaService.createNinja(ninja);
            System.out.println("Ninja created successfully");
            return "redirect:/";
        }
    }
}
