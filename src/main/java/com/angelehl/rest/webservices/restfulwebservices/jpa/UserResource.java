package com.angelehl.rest.webservices.restfulwebservices.jpa;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.angelehl.rest.webservices.restfulwebservices.user.User;
import com.angelehl.rest.webservices.restfulwebservices.user.UserDaoService;
import com.angelehl.rest.webservices.restfulwebservices.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	
	private UserDaoService service; 
	
	private UserRepository repository;
	
	public UserResource(UserDaoService service, UserRepository repository){
		
		this.service = service;
		this.repository = repository;
	}
	
	//GETUsers
	/*@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
	}*/
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		
		return repository.findAll();
	}
	
	//GET one user in specific
	/*@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		
		User user=service.findUser(id);
		
		if(user==null)
			throw new UserNotFoundException("id: "+id);
		
		return service.findUser(id);
		
	}*/
	//-----------------------HATEOAS-------------------------
	/*@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		
		User user=service.findUser(id);
		
		if(user==null)
			throw new UserNotFoundException("id: "+id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
		
	}*/
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		
		Optional<User> user=repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
		
	}
	
	
	
	//----------------------------------------------------------
	/*@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = service.createUser(user);
		
		//Se añade la ubicación (URI) en el header del recurso creado 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		
		return  ResponseEntity.created(location).build();
	}*/
	
	/*@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		
		service.deleteById(id);
		
	}}**/
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		
		repository.deleteById(id);
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = repository.save(user);
		
		//Se añade la ubicación (URI) en el header del recurso creado 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		
		return  ResponseEntity.created(location).build();
	}
}

