package com.demo.myticket.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Screen {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
private int screenId;
	private String screenName;
	private int capacity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="theatreId")
	private Theatre theatre;
	
//	@OneToMany(mappedBy = "screen")
//	private List<Ticket> tickets;
}
