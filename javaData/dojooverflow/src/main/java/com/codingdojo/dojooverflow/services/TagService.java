package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    // returns all the tags
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    // retrieve a tag
    public Tag findTagById(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }

    // Check if tag exists
    public Tag findBySubject(String subject) {
        subject = subject.trim();
        Optional<Tag> tag = tagRepository.findBySubject(subject);
        if (tag.isPresent()) {
            System.out.println("Found subject: " + subject);
            return tag.get();
        } else {
            System.out.println("Subject not found: " + subject);
            return null;
        }
    }

    // create a tag
    public Tag createTag(Tag t) {
        return tagRepository.save(t);
    }

    // update a tag
    public Tag updateTag(Tag t) {
        return tagRepository.save(t);
    }
}
