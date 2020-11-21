package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.User;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	// Get all users
	@GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	// Get a user by id
	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable int id) {
		return userRepo.findById(id);
	}
	
	// Add a user
	@PostMapping("/")
	public User addUser(@RequestBody User m) {
		m = userRepo.save(m);
		return m;
	}
	
	// Update a user
	@PutMapping("/")
	public User updateUser(@RequestBody User m) {
		m = userRepo.save(m);
		return m;
	}
	
	// Delete a user by id
	@DeleteMapping("{id}")
	public User deleteUser(@PathVariable int id) {
		// Optional type will wrap a user
		Optional<User> m = userRepo.findById(id);
		// isPresent() will return true if a user was found
		if (m.isPresent()) {
			userRepo.deleteById(id);
		} else {
			System.out.println("Error - user not found for id " + id);
		}
		return m.get();
	}
	
	// Get Mapping - Get User by Username and Password
	@GetMapping("/login")
	public Optional<User> getByUserNameAndPassword(@RequestParam String userName, @RequestParam String password) {
		Optional<User> u = userRepo.findByUsernameAndPassword(userName, password);
		if(u.isPresent()) {
			return u;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}		
	}
	
	// Post Mapping - Get User by Username and Password
	@PostMapping("/login")
	public Optional<User> getByUserNameAndPassword(@RequestBody User u) {
		Optional<User> user = userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		if(user.isPresent()) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}		
	}
		
}
