package com.dari.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	
	private String firstName ; 
	private String lastName ; 
	private String email ; 
	private String userName ; 
	private String password ; 
	private String role ;
	private String image ; 
	private Instant created;
	private boolean enabled;

}