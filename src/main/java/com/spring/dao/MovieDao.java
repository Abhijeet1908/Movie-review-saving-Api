package com.spring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Movie;
import com.spring.repository.MovieRepository;

@Repository
public class MovieDao {
	@Autowired
	MovieRepository repository;

	public Movie saveMovie(Movie movie) {
		return repository.save(movie);
	}

	public Movie findMovieByid(int id) {
		Optional<Movie> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Movie> findMoviesByName(String name) {
		return repository.findByName(name);
	}

	public List<Movie> findMoviesByRatings(double ratings) {
		return repository.findByRatings(ratings);
	}

	public List<Movie> findAllMovies() {
		return repository.findAll();
	}
	public Movie deleteMovieById(int id) {
	Movie m	=findMovieByid(id);
	if(m!=null) {
		repository.deleteById(id);
		return m;
	}
	return null;
	}

}
