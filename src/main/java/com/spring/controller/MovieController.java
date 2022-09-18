package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Movie;
import com.spring.responseStructure.ResponseStructure;
import com.spring.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService service;
	
	/*
	 * This method is used to save the data in the database it takes object as 
	 * parameter ,by @RequestBody we are accessing object from the request
	 */
	@PostMapping("/movie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie ) {
		return service.saveMovie(movie);
	}
	/*
	 * This method is used to fetch the data from the database whose id matches 
	 * with the id provided in the request, to access the id we need to use 
	 * @PathVariable 
	 */
	@GetMapping("/movie/{id}")
	public ResponseStructure<Movie> findMovieById(@PathVariable("id")int id ) {
		return service.findMovieByid(id);
	}
	/*
	 * This method is used to fetch the data from the database whose name matches 
	 * with the name provided in the request, to access the name we need to use 
	 * @RequestParam
	 */
	@GetMapping("/moviebyname")
	public ResponseStructure<List<Movie>> findMoviesByName(@RequestParam("name")String name) {
		return service.findMoviesByName(name);
	}
	/*
	 * This method is used to fetch the data from the database whose rating matches 
	 * with the rating provided in the request, to access the rating we need to use 
	 * @RequestParam
	 */
	@GetMapping("/moviebyrating")
	public ResponseStructure<List<Movie>> findMoviesByRating(@RequestParam("rating")double rating) {
		return service.findMoviesByRatings(rating);
	}
	/*
	 * This method fetches all the entries from the database
	 */
	@GetMapping("/movie")
	public ResponseStructure<List<Movie>> findAllMovies() {
		return service.findAllMovies();
	}
	/*This method is used to update the data in the database it takes object as 
	 * parameter and by @RequestBody we are accessing object from the request
	 * if data with the given id is not present then new entry is created
	 */
	@PutMapping("/movie")
	public ResponseStructure<Movie> updateMovie(@RequestBody Movie movie ) {
		return service.saveMovie(movie);
	}
	/*
	 * This method is used to delete the data from the database whose id matches 
	 * with the id provided in the request, to access the id we need to use 
	 * @PathVariable 
	 */
	@DeleteMapping("/movie/{id}")
	public ResponseStructure<Movie> deleteMovieById(@PathVariable("id")int id ) {
		return service.deleteMovieById(id);
	}

}
