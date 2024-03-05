package com.demo.myticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.myticket.dao.TheatreDao;
import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.Theatre;
import com.demo.myticketexception.IdNotFoundException;

@Service
public class TheatreService {

	@Autowired
	private TheatreDao theatreDao;

	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre) {
		Theatre savedTheatre=theatreDao.saveTheatre(theatre);
		ResponseStructure<Theatre> responsestructure=new ResponseStructure<Theatre>();
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setMessage("Theatre saved");
		responsestructure.setData(savedTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>> (responsestructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<List<Theatre>>> getTheatresByMovieAndCity(int movieId, int cityId) {
		
		List<Theatre> getTheatre=theatreDao.getTheatresByMovieAndCity(movieId,cityId);
		if(getTheatre !=null)
		{
			ResponseStructure<List<Theatre>> responsestructure=new ResponseStructure<List<Theatre>>();
			responsestructure.setStatusCode(HttpStatus.FOUND.value());
			responsestructure.setMessage("List of Theatres retrived");
			responsestructure.setData(getTheatre);
			return new ResponseEntity<ResponseStructure<List<Theatre>>> (responsestructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}

}
