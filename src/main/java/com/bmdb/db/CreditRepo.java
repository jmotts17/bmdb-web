package com.bmdb.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Credit;

public interface CreditRepo extends JpaRepository<Credit, Integer> {

	// Find CreditRepo by Actor Name
	public List<Credit> findByActorFirstNameAndActorLastName(String firstName, String lastName);
	
}
