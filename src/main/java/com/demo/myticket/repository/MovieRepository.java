package com.demo.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
