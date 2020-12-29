package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/dashboard")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "/songs/dashboard.jsp";
    }

    @RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Song> songs = songService.allSongs();
            model.addAttribute("songs", songs);
            return "/songs/index.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/songs";
        }
    }

    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }

    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
            songService.updateSong(song);
            return "redirect:/songs";
        }
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}