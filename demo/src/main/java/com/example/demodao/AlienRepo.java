package com.example.demodao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer> {
	

	
	  List<Alien> findByName(String name);
	 
	 
	  List<Alien> findByIdGreaterThan(int id);
	  
	  @Query("from Alien where lang=?1 order by name") List<Alien>
	  findByLangOrderBy(String lang);
	 
		/*
		 * @Query("count(),lang from Alien group by lang ") List<Alien>
		 * groupingOnName(int id);
		 */
}
