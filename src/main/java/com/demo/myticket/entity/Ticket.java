package com.demo.myticket.entity;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ticketId;
@CreationTimestamp
private LocalTime bookingTime;
private int seatNum;
private double ticketfare;

@ManyToOne
//@JoinColumn(name="screenId")
private Screen screen;

@ManyToOne
@JoinColumn(name="userId")
private UserInfo user;

@ManyToOne
//@JoinColumn(name="movieId")
private Movie movie;
}
