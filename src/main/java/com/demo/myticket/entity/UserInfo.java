package com.demo.myticket.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Size(min = 4, message = "Username should be atleast 4 characters")
	private String userName;
	 @Column(unique = true)
	  @Email(message = "Please enter valid email")
	private String userEmail;
	 @Size(min = 10, max=10)
	private String userPhone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Ticket> ticket;
}
