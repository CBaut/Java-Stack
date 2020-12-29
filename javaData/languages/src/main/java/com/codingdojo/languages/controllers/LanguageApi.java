package com.codingdojo.languages.controllers;

import java.util.List;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageApi {
    private final LanguageService languageService;

    public LanguageApi(LanguageService languageService) {
        this.languageService = languageService;
    }

    // THIS IS WHERE TO GO:
    // localhost:8080/api/languages
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }

    @RequestMapping(value = "/api/languages", method = RequestMethod.POST)
    public Language create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
            @RequestParam(value = "version") String version) {
        Language language = new Language(name, creator, version);
        return languageService.createLanguage(language);
    }

    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }

    @RequestMapping(value = "/api/languages/{id}", method = RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value = "name") String name,
            @RequestParam(value = "creator") String creator, @RequestParam(value = "version") String version,
            @RequestParam(value = "pages") Integer numOfPages) {
        Language language = languageService.updateLanguage(id, name, creator, version);
        return language;
    }

    @RequestMapping(value = "/api/languages/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}