package com.demo.myticket.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.myticket.entity.Movie;
import com.demo.myticket.repository.MovieRepository;

@Repository
public class MovieDao {

	@Autowired
	private MovieRepository movieRepository;

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie getMovieById(int movieId) {
		Optional<Movie> movie=movieRepository.findById(movieId);
		if(movie.isPresent())
		{
			return movie.get();
		}
		return null;
	}

}
