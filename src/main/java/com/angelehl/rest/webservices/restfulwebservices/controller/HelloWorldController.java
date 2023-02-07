package com.angelehl.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.angelehl.rest.webservices.restfulwebservices.helloWorld.HelloWorldBean;

//REST-API
@RestController
public class HelloWorldController {
	
	//Se hace referencia al archivo message.properties
	//Este archivo DEBE llamarse asi
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource){
		
		this.messageSource=messageSource;
	}
	
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		
		return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldB() {
		
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean HelloWorldC(@PathVariable	String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping(path="/hello-world-internazionalized")
	public String HelloWorldInternationalized() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message",null,"Default message",locale);
		
	}

}
