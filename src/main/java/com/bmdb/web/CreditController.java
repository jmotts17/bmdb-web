package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {

	@Autowired
	private CreditRepo creditRepo;
	
	// Get all credits
	@GetMapping("/")
	public List<Credit> getAll() {
		return creditRepo.findAll();
	}
	
	// Get a credit by id
	@GetMapping("/{id}")
	public Optional<Credit> getById(@PathVariable int id) {
		return creditRepo.findById(id);
	}
	
	// Add a credit
	@PostMapping("/")
	public Credit addCredit(@RequestBody Credit c) {
		c = creditRepo.save(c);
		return c;
	}
	
//	// Update a actor
//	@PutMapping("/")
//	public Actor updateActor(@RequestBody Actor a) {
//		a = actorRepo.save(a);
//		return a;
//	}
//	
//	// Delete a actor by id
//	@DeleteMapping("{id}")
//	public Actor deleteActor(@PathVariable int id) {
//		// Optional type will wrap a actor
//		Optional<Actor> a = actorRepo.findById(id);
//		// isPresent() will return true if a actor was found
//		if (a.isPresent()) {
//			actorRepo.deleteById(id);
//		} else {
//			System.out.println("Error - actor not found for id " + id);
//		}
//		return a.get();
//	}
	
}
