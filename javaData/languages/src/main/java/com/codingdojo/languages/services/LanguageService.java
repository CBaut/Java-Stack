// SERVICE LAYER that handles Controller /API requests and bounces with the Repository level to query from and store to database

package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    // creates a book
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }

    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    // update a book
    public Language updateLanguage(Language b) {
        // something happens here
        return languageRepository.save(b);
    }

    // deletes a book
    public void deleteLanguage(Long id) {
        // not sure what to put here...
        languageRepository.deleteById(id);
    }
}