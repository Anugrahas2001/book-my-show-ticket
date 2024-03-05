package com.demo.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
