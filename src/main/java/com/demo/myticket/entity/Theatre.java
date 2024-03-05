package com.demo.myticket.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theatre")
	private List<Movie> movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cityId")
	private City city;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theatre")
	private List<Screen> screen;

}
