package com.mjc.rest.api;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjc.rest.DataStore;
import com.mjc.rest.domain.User;

@RestController
@RequestMapping("/user")
public class UserRest {

	
	@PostMapping
	private ResponseEntity<String> createUser(@RequestBody User user) {
		
		// InMemory data store
		DataStore.getUserData().put(user.getUserId(), user);
		
		return ResponseEntity.created(URI.create("/user")).body("Success");
	}
	
	@GetMapping
	private ResponseEntity<Collection<User>> getUser() {
		
		Collection<User> userList = DataStore.getUserData().values();
		
		return ResponseEntity.ok(userList);
	}

	
	@GetMapping({"{userId}"})
	private ResponseEntity<User> getUserById(@PathVariable String userId) {
		
		User user = DataStore.getUserData().get(userId);
		
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping
	private ResponseEntity<String> updateUser(@RequestBody User user) {
		
		// InMemory data store
		DataStore.getUserData().put(user.getUserId(), user);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("{userId}")
	private ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
		
		// InMemory data store
		DataStore.getUserData().remove(userId);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}



}
