package com.codingdojo.familiarwithrouting2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
//	3. Method that maps to the request route above
	public String hello() { // 3
		return "Hello World!";
	}
	
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String python() {
		return "Python / Django was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String java() {
		return "Java / Spring is better!";
	}
	
	
}
