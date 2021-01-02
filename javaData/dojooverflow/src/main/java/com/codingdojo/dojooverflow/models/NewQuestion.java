package com.codingdojo.dojooverflow.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewQuestion {

    @NotBlank(message = "Write a question")
    private String question;
    @Pattern(regexp = "^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$", message = "Tags must be separated by commas, max 3")
    private String tags;

    public NewQuestion() {

    }

    public NewQuestion(String question, String tags) {
        this.setQuestion(question);
        this.setTags(tags);
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String[] splitTags() {
        return this.tags.split("\\s*,\\s*");
    }
}
