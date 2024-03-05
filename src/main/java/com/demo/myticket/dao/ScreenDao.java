package com.demo.myticket.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.myticket.entity.Screen;
import com.demo.myticket.repository.ScreenRepository;

@Repository
public class ScreenDao {
	@Autowired
	private ScreenRepository screenRepository;

	public Screen saveScreen(Screen screen) {
		return screenRepository.save(screen);
	}

	public Screen getScreenById(int screenId) {

		Optional<Screen> optional = screenRepository.findById(screenId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
