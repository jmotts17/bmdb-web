package com.bmdb.business;

import javax.persistence.*;

@Entity
public class MovieGenre {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="MovieId")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name="GenreId")
	private Genre genre;
	
	// Constructors
	public MovieGenre() {
		super();
	}

	public MovieGenre(int id, Movie movie, Genre genre) {
		super();
		this.id = id;
		this.movie = movie;
		this.genre = genre;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
		
}
