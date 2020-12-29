
// REPOSITORY layer that works inbetween Servicees and models
package com.codingdojo.languages.repositories;

import java.util.List;

import com.codingdojo.languages.models.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    // this method retrieves all the Languages from the database
    List<Language> findAll();

    // this method finds Languages with descriptions containing the search string
    List<Language> findByCreatorContaining(String search);

    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);

    // this method deletes a Language that starts with a specific title
    Long deleteByNameStartingWith(String search);
}