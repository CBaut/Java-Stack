package com.codingdojo.lookify.controllers;

import java.util.List;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongApi {
    private final SongService songService;

    public SongApi(SongService songService) {
        this.songService = songService;
    }

    // THIS IS WHERE TO GO:
    // localhost:8080/api/songs
    @RequestMapping("/api/songs")
    public List<Song> index() {
        return songService.allSongs();
    }

    @RequestMapping(value = "/api/songs", method = RequestMethod.POST)
    public Song create(@RequestParam(value = "title") String title, @RequestParam(value = "artist") String artist,
            @RequestParam(value = "rating") Integer rating) {
        Song song = new Song(title, artist, rating);
        return songService.createSong(song);
    }

    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
        return songService.findSong(id);
    }

    // @RequestMapping(value = "/api/songs/{id}", method = RequestMethod.PUT)
    // public Song update(@PathVariable("id") Long id, @RequestParam(value =
    // "title") String title,
    // @RequestParam(value = "artist") String artist, @RequestParam(value =
    // "rating") Integer rating) {
    // return songService.updateSong(id, title, artist, rating);
    // }

    @RequestMapping(value = "/api/songs/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
}