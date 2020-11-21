package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Genre;
import com.bmdb.db.GenreRepo;


@CrossOrigin
@RestController
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreRepo genreRepo;
	
	// Get all genres
	@GetMapping("/")
	public List<Genre> getAll() {
		return genreRepo.findAll();
	}
	
	// Get a genre by id
	@GetMapping("/{id}")
	public Optional<Genre> getById(@PathVariable int id) {
		return genreRepo.findById(id);
	}
	
	// Add a genre
	@PostMapping("/")
	public Genre addGenre(@RequestBody Genre g) {
		g = genreRepo.save(g);
		return g;
	}
	
	// Update a genre
	@PutMapping("/")
	public Genre updateGenre(@RequestBody Genre g) {
		g = genreRepo.save(g);
		return g;
	}
	
	// Delete a genre by id
	@DeleteMapping("{id}")
	public Genre deleteGenre(@PathVariable int id) {
		// Optional type will wrap a genre
		Optional<Genre> a = genreRepo.findById(id);
		// isPresent() will return true if a genre was found
		if (a.isPresent()) {
			genreRepo.deleteById(id);
		} else {
			System.out.println("Error - genre not found for id " + id);
		}
		return a.get();
	}
	
}
