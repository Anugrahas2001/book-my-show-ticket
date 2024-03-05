package com.demo.myticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

	List<Theatre> findAllByMovie_MovieIdAndCity_CityId(int movieId, int cityId);

	

}
