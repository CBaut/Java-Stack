package com.codingdojo.events.validator;

import java.util.Date;

import com.codingdojo.events.models.Event;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        Date eventDate = event.getDate();
        Date today = new Date();
        if (!eventDate.after(today)) {
            errors.rejectValue("date", "After");
        }
    }
}
