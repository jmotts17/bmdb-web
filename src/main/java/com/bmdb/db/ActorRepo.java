package com.bmdb.db;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Actor;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

	// Find actors by gender
	List<Actor> findByGender(String gender);
	
	// Find actors by last name
	List<Actor> findByLastName(String lastName);
	
	// Find actors whose last name starts with a specific letter
	List<Actor> findByLastNameLike(String letter);

	// Find all actors born between a specific date
	List<Actor> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
	
}
