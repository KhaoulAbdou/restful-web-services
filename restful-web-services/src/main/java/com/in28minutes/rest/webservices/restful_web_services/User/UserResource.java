package com.in28minutes.rest.webservices.restful_web_services.User;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	private static List<User> users = new ArrayList<>();
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	//Get /Users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	
	  //Get /Users/1
	  @GetMapping("/users/{id}") 
	  public User retrieveUser(@PathVariable int id){ 
		  
		  User user = service.findOne(id); 
		  if (user==null) 
			  throw new UserNotFoundException ("id:"+id);
		  return user;
		  
	  }
	
	//Post /Users
	 @PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
	  User savedUser = service.save(user);
	// users/4 => /users  user.getId
	  URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			  .path("/{id}")
			  .buildAndExpand(savedUser.getId())
			  .toUri();			  
	  return ResponseEntity.created(location ).build(); // if user created so it return 201 location return id of user 

		 	
	}
	 
	 @DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id) {
			service.deleteById(id);
		}
		 

}
