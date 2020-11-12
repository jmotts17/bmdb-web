package com.bmdb.web;

import java.time.LocalDate;
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
	
	// List all actors by Gender
	// Using RequestParam to pass gender
	@GetMapping("/find-by-gender")
	public List<Actor> getAllByGender(@RequestParam String gender) {
		return actorRepo.findByGender(gender);
	}
	
	// List all actors by LastName
	@GetMapping("/find-by-last-name")
	public List<Actor> getAllByLastName(@RequestParam String lastName) {
		return actorRepo.findByLastName(lastName);
	}
	
	// List all actors by LastName starts with "letter"
	@GetMapping("/find-by-last-name-like")
	public List<Actor> getAllByLastNameLike(@RequestParam String letter) {
		return actorRepo.findByLastNameLike(letter + "%");
	}
	
	// List all actors by birth date range
	@GetMapping("/find-by-birth-date-between")
	public List<Actor> getAllByBirthDateBetween(@RequestParam String startDate, @RequestParam String endDate) {
		LocalDate ld1 = LocalDate.parse(startDate);
		LocalDate ld2 = LocalDate.parse(endDate);
		
		return actorRepo.findByBirthDateBetween(ld1, ld2);
	}
}
