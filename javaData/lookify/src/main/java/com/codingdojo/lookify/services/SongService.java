// SERVICE LAYER that handles Controller /API requests and bounces with the Repository level to query from and store to database

package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // returns all the books
    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    // creates a book
    public Song createSong(Song b) {
        return songRepository.save(b);
    }

    // retrieves a book
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    // update a book
    public Song updateSong(Song b) {
        // something happens here
        return songRepository.save(b);
    }

    // deletes a book
    public void deleteSong(Long id) {
        // not sure what to put here...
        songRepository.deleteById(id);
    }

    // Get all songs ordered by rating
    public List<Song> findAllByRating() {
        return songRepository.findAllByOrderByRatingDesc();
    }

    // Find all songs containing input artist
    public List<Song> findArtist(String search) {
        return songRepository.findByArtistContaining(search);
    }
}