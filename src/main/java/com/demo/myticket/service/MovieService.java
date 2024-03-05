package com.demo.myticket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.myticket.dao.MovieDao;
import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.Movie;
import com.demo.myticket.entity.Theatre;
import com.demo.myticket.repository.TheatreRepository;
import com.demo.myticketexception.IdNotFoundException;
import com.demo.myticketexception.IdNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;
	@Autowired
	private TheatreRepository theatreRepository;

	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie, int theatreId) {
		Optional<Theatre> optional = theatreRepository.findById(theatreId);
		if (optional.isPresent()) {
			movie.setTheatre(optional.get());
			Movie savedMovie = movieDao.saveMovie(movie);
			ResponseStructure<Movie> responsestructure = new ResponseStructure<Movie>();
			responsestructure.setStatusCode(HttpStatus.CREATED.value());
			responsestructure.setMessage("Movie Created");
			responsestructure.setData(savedMovie);
			return new ResponseEntity<ResponseStructure<Movie>>(responsestructure, HttpStatus.CREATED);
		}

		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Movie>> getMovieById(int movieId) {
		Movie getMovie = movieDao.getMovieById(movieId);
		if (getMovie != null) {
			ResponseStructure<Movie> responsestructure = new ResponseStructure<Movie>();
			responsestructure.setStatusCode(HttpStatus.FOUND.value());
			responsestructure.setMessage("Movie data retrived");
			responsestructure.setData(getMovie);
			return new ResponseEntity<ResponseStructure<Movie>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}

}
