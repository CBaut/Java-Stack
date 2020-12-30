package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RelationshipController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public RelationshipController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Person> allPersons = personService.findAllPersons();
        model.addAttribute("persons", allPersons);
        return "index.jsp";
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/persons/new.jsp";
    }

    @PostMapping("/persons")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
            personService.createPerson(person);
            System.out.println("Person created successfully");
            return "redirect:/persons/new";
        }
    }

    @RequestMapping("/licenses/new")
    public String newLicensesPage(Model model, @ModelAttribute("license") License license) {
        List<Person> unlicensed = personService.getUnlicensedPeople();
        model.addAttribute("persons", unlicensed);
        return "/licenses/new.jsp";
    }

    @PostMapping("/licenses")
    public String createLicense(@ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "/licenses/new.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/persons/" + license.getPerson().getId();
        }
    }

    @RequestMapping("/persons/{id}")
    public String personsPage(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPersonById(id);
        License license = person.getLicense();
        model.addAttribute("person", person);
        model.addAttribute("license", license);
        return "/persons/show.jsp";
    }

}
