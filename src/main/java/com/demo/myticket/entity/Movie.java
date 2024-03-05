package com.demo.myticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieTitle;
	private String movieGenre;
	private double duration;
	private String movieReleaseData;

//	@OneToMany(mappedBy = "movie")
//	private List<Ticket> ticket;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "theatreId")
	private Theatre theatre;
}
