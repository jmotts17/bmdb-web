package com.bmdb.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.MovieGenre;

public interface MovieGenreRepo extends JpaRepository<MovieGenre, Integer> {

	// Find movies by genre
	public List<MovieGenre> findByGenreName(String genre);
	
}
