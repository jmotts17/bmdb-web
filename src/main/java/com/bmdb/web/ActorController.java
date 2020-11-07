package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {

	/* 
	 * A controller will implement 5 CRUD methods
	 * 1) GET ALL
	 * 2) GET BY ID
	 * 3) POST - Insert
	 * 4) PUT - Update
	 * 5) DELETE - delete 
	 */
	
	@Autowired
	private ActorRepo actorRepo;
	
	// Get all actors
	@GetMapping("/")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	// Get a actor by id
	@GetMapping("/{id}")
	public Optional<Actor> getById(@PathVariable int id) {
		return actorRepo.findById(id);
	}
	
	// Add a actor
	@PostMapping("/")
	public Actor addActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}
	
	// Update a actor
	@PutMapping("/")
	public Actor updateActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}
	
	// Delete a actor by id
	@DeleteMapping("{id}")
	public Actor deleteActor(@PathVariable int id) {
		// Optional type will wrap a actor
		Optional<Actor> a = actorRepo.findById(id);
		// isPresent() will return true if a actor was found
		if (a.isPresent()) {
			actorRepo.deleteById(id);
		} else {
			System.out.println("Error - actor not found for id " + id);
		}
		return a.get();
	}
}
