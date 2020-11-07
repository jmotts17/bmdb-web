package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {

	/* 
	 * A controller will implement 5 CRUD methods
	 * 1) GET ALL
	 * 2) GET BY ID
	 * 3) POST - Insert
	 * 4) PUT - Update
	 * 5) DELETE - delete 
	 */
	
	@Autowired
	private MovieRepo movieRepo;
	
	// Get all movies
	@GetMapping("/")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	
	// Get a movie by id
	@GetMapping("/{id}")
	public Optional<Movie> getById(@PathVariable int id) {
		return movieRepo.findById(id);
	}
	
	// Add a movie
	@PostMapping("/")
	public Movie addMovie(@RequestBody Movie m) {
		m = movieRepo.save(m);
		return m;
	}
	
}
