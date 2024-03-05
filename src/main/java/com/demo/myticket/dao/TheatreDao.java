package com.demo.myticket.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.myticket.entity.Theatre;
import com.demo.myticket.repository.TheatreRepository;

@Repository
public class TheatreDao {

	@Autowired
	private TheatreRepository theatreRepository;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepository.save(theatre);
	}

	public List<Theatre> getTheatresByMovieAndCity(int movieId, int cityId) {
		List<Theatre> theatreObj=theatreRepository.findAllByMovie_MovieIdAndCity_CityId(movieId, cityId);
		return theatreObj;
	}

}
