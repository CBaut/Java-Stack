package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1. Annotation
@RestController
//  class level annotations
@RequestMapping("/hello")
public class HomeController {
//	1. Annotation
	@RequestMapping("")
//	3. Method that maps to the request route above
	public String hello() { // 3
		return "Hello World!";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
