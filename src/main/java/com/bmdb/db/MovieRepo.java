package com.bmdb.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	// Find movies by rating
	List<Movie> findByRating(String rating);
	
	// Find movies by director
	List<Movie> findByDirector(String director);
	
	// Find movies by year
	List<Movie> findByYear(int year);
	
}
