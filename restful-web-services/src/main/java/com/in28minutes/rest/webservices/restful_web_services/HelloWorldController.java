package com.in28minutes.rest.webservices.restful_web_services;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//API REST
@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	

	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}


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
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
  }
}
