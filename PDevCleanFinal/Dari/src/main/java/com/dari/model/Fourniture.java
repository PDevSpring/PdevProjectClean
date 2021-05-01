package com.dari.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Fourniture")
public class Fourniture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "F_ID")
	private long FournitureId ;
	
	@Column(name = "quantity", nullable = false)
	 private Integer quantity;
	 
	@Enumerated(EnumType.STRING)
	private FournitureType type;
	
	
	private String Description ; 
	
	
	private float Price ;
		
	private long usercard;

	private String pubDate;
	
	private String Image1 ; 
	private String Image2 ;
	
	@JsonIgnore
	@OneToOne
	private User user;
	

	@JsonIgnore
	@ManyToOne
	private Delivery delivery;
	
	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	}




