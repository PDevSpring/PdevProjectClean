package com.dari.model;

import java.util.Date;

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
public class Fourniture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long MeetingId ; 
	
	private Date date ; 
	private String WhithWho ; 

}

