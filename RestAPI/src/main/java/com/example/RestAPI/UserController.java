package com.example.RestAPI;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	//so spring will now create an instance of user service and 
	// will autowire it here "@Autowired
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<UserAccount> retrieveAllUsers(){
		return userDAO.findAll();
	}
	
	@GetMapping("/users/{id}")
	public UserAccount retrieveUser(@PathVariable int id) {
		UserAccount user = userDAO.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+ id);
		}
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		UserAccount user = userDAO.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+ id);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UserAccount user) {
		UserAccount savedUser = userDAO.save(user);
		         //will give the current url
		//Because we want to know what id is assigned to the user when it is 
		//newly created, so in Headers section, we will get the location
		// like: http://localhost:8080/users/4(is created)
		//We will get a status of 201 Created.
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(loc).build();
		
	}
	
}
