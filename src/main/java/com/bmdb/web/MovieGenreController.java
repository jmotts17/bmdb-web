package com.bmdb.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.business.MovieGenre;
import com.bmdb.db.MovieGenreRepo;

@CrossOrigin
@RestController
@RequestMapping("/movie-genres")
public class MovieGenreController {

	@Autowired
	private MovieGenreRepo movieGenreRepo;
	
	// Get all movie genres
	@GetMapping("/")
	public List<MovieGenre> getAll() {
		return movieGenreRepo.findAll();
	}
	
	// Get a movie genre by id
	@GetMapping("/{id}")
	public Optional<MovieGenre> getById(@PathVariable int id) {
		return movieGenreRepo.findById(id);
	}
	
	// Add a movie genre
	@PostMapping("/")
	public MovieGenre addMovieGenre(@RequestBody MovieGenre mg) {
		mg = movieGenreRepo.save(mg);
		return mg;
	}
	
	// Update a movie genre
	@PutMapping("/")
	public MovieGenre updateMovieGenre(@RequestBody MovieGenre mg) {
		mg = movieGenreRepo.save(mg);
		return mg;
	}
	
	// Delete a movie genre by id
	@DeleteMapping("{id}")
	public MovieGenre deleteMovieGenre(@PathVariable int id) {
		Optional<MovieGenre> mg = movieGenreRepo.findById(id);
		
		if (mg.isPresent()) {
			movieGenreRepo.deleteById(id);
		} else {
			System.out.println("Error - movie genre not found for id " + id);
		}
		
		return mg.get();
	}
	
	// Returns all movies by a specified genre
	@GetMapping("/get-movies-by-genre")
	public List<Movie> getMoviesByGenre(@RequestParam String genre) {
		
		List<MovieGenre> mgList = new ArrayList<>();
		mgList = movieGenreRepo.findByGenreName(genre);
		List<Movie> movieList = new ArrayList<>();
		
		for(MovieGenre mg: mgList) {
			movieList.add(mg.getMovie());
		}
		
		return movieList;
	}
}
