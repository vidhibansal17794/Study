package com.example.demodao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer> {
	

	

}
