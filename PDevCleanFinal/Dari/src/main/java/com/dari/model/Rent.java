package com.dari.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rent extends Ads{

	//@Temporal(TemporalType.DATE)
	private String StartDate;
	//@Temporal(TemporalType.DATE)
	private String EndDate;
	@Enumerated(EnumType.STRING)
	@NotNull
	private RentType renttype;
	
	
	}
	
	
	
	
	
	
	
	

