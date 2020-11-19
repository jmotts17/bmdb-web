package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.MovieCollection;
import com.bmdb.business.User;
import com.bmdb.db.MovieCollectionRepo;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/movie-collections")
public class MovieCollectionController {

	@Autowired
	private MovieCollectionRepo movieCollectionRepo;
	@Autowired
	private UserRepo userRepo;
	
	// Get all movieCollections
	@GetMapping("/")
	public List<MovieCollection> getAll() {
		return movieCollectionRepo.findAll();
	}
	
	// Get a movieCollection by id
	@GetMapping("/{id}")
	public Optional<MovieCollection> getById(@PathVariable int id) {
		return movieCollectionRepo.findById(id);
	}
	
	// Add a movieCollection
	@PostMapping("/")
	public MovieCollection addMovieCollection(@RequestBody MovieCollection m) {
		m = movieCollectionRepo.save(m);
		recalculateCollectionValue(m);
		return m;
	}
	
	// Update a movieCollection
	@PutMapping("/")
	public MovieCollection updateMovieCollection(@RequestBody MovieCollection m) {
		m = movieCollectionRepo.save(m);
		recalculateCollectionValue(m);
		return m;
	}
	
	// Delete a movieCollection by id
	@DeleteMapping("{id}")
	public MovieCollection deleteMovieCollection(@PathVariable int id) {
		Optional<MovieCollection> m = movieCollectionRepo.findById(id);

		if (m.isPresent()) {
			movieCollectionRepo.deleteById(id);
			recalculateCollectionValue(m.get());
		} else {
			System.out.println("Error - movieCollection not found for id " + id);
		}
		return m.get();
	}
		
	public void recalculateCollectionValue(MovieCollection m) {
		// get all movie collections for this user
		// loop through them and sum a new total
		double newTotal = 0.0;
		List<MovieCollection> mcs = movieCollectionRepo.findByUserId(m.getUser().getId());
		
		for(MovieCollection mc : mcs) {
			newTotal += mc.getPurchasePrice();
		}
		
		User u = m.getUser();
		u.setCollectionValue(newTotal);
		userRepo.save(u);
	}
	
}
