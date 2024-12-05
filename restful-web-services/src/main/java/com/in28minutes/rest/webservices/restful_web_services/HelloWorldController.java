package com.in28minutes.rest.webservices.restful_web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//API REST
@RestController
public class HelloWorldController {
	
	//  helloWorld
	@GetMapping(path="/HelloWorld")
	public String HelloWorld() {
		return "Hello World!";
	}

	
	@GetMapping(path="/HelloWorld-Bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World!") ;
	}
	
	
	@GetMapping(path="/HelloWorld-Bean/path-varible/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(
				String.format("Hello World, %s", name)) ;
	}
}
