package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.MovieCollection;
import com.bmdb.db.MovieCollectionRepo;

@CrossOrigin
@RestController
@RequestMapping("/movie-collections")
public class MovieCollectionController {

	@Autowired
	private MovieCollectionRepo movieCollectionRepo;
	
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
		return m;
	}
	
	// Update a movieCollection
	@PutMapping("/")
	public MovieCollection updateMovieCollection(@RequestBody MovieCollection m) {
		m = movieCollectionRepo.save(m);
		return m;
	}
	
	// Delete a movieCollection by id
	@DeleteMapping("{id}")
	public MovieCollection deleteMovieCollection(@PathVariable int id) {
		// Optional type will wrap a movieCollection
		Optional<MovieCollection> m = movieCollectionRepo.findById(id);
		// isPresent() will return true if a movieCollection was found
		if (m.isPresent()) {
			movieCollectionRepo.deleteById(id);
		} else {
			System.out.println("Error - movieCollection not found for id " + id);
		}
		return m.get();
	}
	
}
