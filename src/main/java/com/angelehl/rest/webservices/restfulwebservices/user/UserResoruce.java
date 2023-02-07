package com.angelehl.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResoruce {
	
	@Autowired
	private UserDaoService service; 	
	
	public UserResoruce(UserDaoService service){
		
		this.service = service;
	}
	
	//GETUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
	}
	
	//GET one user in specific
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		
		return service.findUser(id);
		
	}

}
