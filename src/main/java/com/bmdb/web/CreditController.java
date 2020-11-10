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
	
	// Update a credit
	@PutMapping("/")
	public Credit updateCredit(@RequestBody Credit c) {
		c = creditRepo.save(c);
		return c;
	}
	
	// Delete a credit by id
	@DeleteMapping("{id}")
	public Credit deleteCredit(@PathVariable int id) {
		// Optional type will wrap a credit
		Optional<Credit> c = creditRepo.findById(id);
		// isPresent() will return true if a credit was found
		if (c.isPresent()) {
			creditRepo.deleteById(id);
		} else {
			System.out.println("Error - credit not found for id " + id);
		}
		return c.get();
	}
	
}
