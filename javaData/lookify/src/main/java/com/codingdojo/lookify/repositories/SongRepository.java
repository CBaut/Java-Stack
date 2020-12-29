// REPOSITORY layer that works inbetween Servicees and models

package com.codingdojo.lookify.repositories;

import java.util.List;

import com.codingdojo.lookify.models.Song;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // this method retrieves all the Languages from the database
    List<Song> findAll();

    // this method finds Languages with descriptions containing the search string
    List<Song> findByArtistContaining(String search);

    // this method counts how many titles contain a certain string
    // Long countByNameContaining(String search);

    // this method deletes a Song that starts with a specific title
    // Long deleteByNameStartingWith(String search);
}