package com.angelehl.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.angelehl.rest.webservices.restfulwebservices.helloWorld.HelloWorldBean;

//REST-API
@RestController
public class HelloWorldController {
	
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
	
	

}
