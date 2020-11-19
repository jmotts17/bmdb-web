package com.bmdb.business;

import javax.persistence.*;

@Entity
public class MovieCollection {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;
	@ManyToOne
	@JoinColumn(name="MovieId")
	private Movie movie;
	private double purchasePrice;
	
	// Constructors
	public MovieCollection() {
		super();
	}

	public MovieCollection(int id, User user, Movie movie, double purchasePrice) {
		super();
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.purchasePrice = purchasePrice;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
}
