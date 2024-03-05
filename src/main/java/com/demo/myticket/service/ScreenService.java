package com.demo.myticket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.myticket.dao.ScreenDao;
import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.Screen;
import com.demo.myticket.entity.Theatre;
import com.demo.myticket.repository.TheatreRepository;
import com.demo.myticketexception.IdNotFoundException;

@Service
public class ScreenService {
	@Autowired
	private ScreenDao screenDao;
	@Autowired
	private TheatreRepository theatreRepository;

	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen, int theatreId) {
		Optional<Theatre> optional = theatreRepository.findById(theatreId);
		Theatre threatre = optional.get();
		screen.setTheatre(threatre);
		if (threatre != null) {
			Screen savedScreen = screenDao.saveScreen(screen);
			ResponseStructure<Screen> responsestructure = new ResponseStructure<Screen>();
			responsestructure.setStatusCode(HttpStatus.CREATED.value());
			responsestructure.setMessage("Screen Created");
			responsestructure.setData(savedScreen);
			return new ResponseEntity<ResponseStructure<Screen>>(responsestructure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Screen>> getScreenById(int screenId) {
		Screen screens = screenDao.getScreenById(screenId);

		if (screens != null) {
			ResponseStructure<Screen> responsestructure = new ResponseStructure<Screen>();
			responsestructure.setStatusCode(HttpStatus.OK.value());
			responsestructure.setMessage("Screen Created");
			responsestructure.setData(screens);
			return new ResponseEntity<ResponseStructure<Screen>>(responsestructure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

}
