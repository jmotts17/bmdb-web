package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Genre {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	// Constructors
	public Genre() {
		super();
	}

	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
