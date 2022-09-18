package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dto.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public List<Movie> findByName(String name);
	public List<Movie> findByRatings(double ratings);

}
