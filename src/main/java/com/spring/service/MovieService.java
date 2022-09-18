package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.dao.MovieDao;
import com.spring.dto.Movie;
import com.spring.exception.MovieNotSavedException;
import com.spring.exception.NoDataFoundForGivenNameException;
import com.spring.exception.NoDataFoundForGivenRatingException;
import com.spring.exception.NoDataFoundInDataBaseException;
import com.spring.exception.NoIdFoundException;
import com.spring.responseStructure.ResponseStructure;

@Service
public class MovieService {
	@Autowired
	MovieDao dao;

	public ResponseStructure<Movie> saveMovie(Movie movie) {
		if (movie.getName() != null && movie.getReview() != null && movie.getRatings() != 0.0) {
			Movie m = dao.saveMovie(movie);
			ResponseStructure<Movie> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.ACCEPTED.value());
			rs.setMessage("movie Saved Sucessfully");
			return rs;
		}
		throw new MovieNotSavedException();

	}

	public ResponseStructure<Movie> findMovieByid(int id) {
		Movie m = dao.findMovieByid(id);
		if (m != null) {
			ResponseStructure<Movie> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("movie data found");
			return rs;
		}
		throw new NoIdFoundException();
	}

	public ResponseStructure<List<Movie>> findMoviesByName(String name) {
		List<Movie> m = dao.findMoviesByName(name);
		if (m.size() != 0) {
			ResponseStructure<List<Movie>> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("movie data found");
			return rs;
		}
		throw new NoDataFoundForGivenNameException();
	}

	public ResponseStructure<List<Movie>> findMoviesByRatings(double ratings) {
		List<Movie> m = dao.findMoviesByRatings(ratings);
		if (m.size() != 0) {
			ResponseStructure<List<Movie>> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("movie data found");
			return rs;
		}
		throw new NoDataFoundForGivenRatingException();
	}

	public ResponseStructure<List<Movie>> findAllMovies() {
		List<Movie> m = dao.findAllMovies();
		if (m.size() != 0) {
			ResponseStructure<List<Movie>> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("movie data found");
			return rs;
		}
		throw new NoDataFoundInDataBaseException();
	}
	public ResponseStructure<Movie> deleteMovieById(int id) {
		Movie m = dao.deleteMovieById(id);
		if (m != null) {
			ResponseStructure<Movie> rs = new ResponseStructure<>();
			rs.setData(m);
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("movie data deleted sucessfully");
			return rs;
		}
		throw new NoIdFoundException();
	}
	

}
