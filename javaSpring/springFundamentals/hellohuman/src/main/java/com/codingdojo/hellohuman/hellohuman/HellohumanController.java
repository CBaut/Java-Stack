package com.codingdojo.hellohuman.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellohumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {
        String getName;
        String message1 = "<h1>Hello ";
        String message2 = "!</h1><p>Welcome to SpringBoot!</p>";
        if (firstName == null) {
            getName = "Human";
        } else if (lastName == null) {
            getName = firstName;
        } else {
            getName = firstName + " " + lastName;
        }
        return message1 + getName + message2;
    }
}
