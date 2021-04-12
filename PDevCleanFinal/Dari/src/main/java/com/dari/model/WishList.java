package com.dari.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WISHLIST")
public class WishList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdW;
	private int surfacemin; 
	private int surfacemax; 
	private int budgetmin; 
	private int budgetmax;
	private String ServiceType ; 
	private int RoomsNb ; 
	private int BathroomsNb ; 
	private int BalconiesNb ; 
	private int GaragesNb ;	
	private Boolean AirConditioner ; 
	private Boolean Heater ; 
	private Boolean SwimmingPool ; 
	private Boolean Garden ; 
	private Boolean Furnished ;
	private String location;
	
	@ManyToOne
	User user;
	
	
	
	}



	

