package com.dari.model;

import java.util.List;

import javax.persistence.ElementCollection;
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
public class Ads {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long AdID ; 
	
	private String Object ; 
	private String Description ; 
	private String location ; 
	private String ServiceType ; 
	@ElementCollection
	private  List <String> image ;
	private int RoomsNb ; 
	private int BathroomsNb ; 
	private int Surface ; 
	private int BalconiesNb ; 
	private int GaragesNb ;
	private int Price ; 
	
	private Boolean AirConditioner ; 
	private Boolean Heater ; 
	private Boolean SwimmingPool ; 
	private Boolean Garden ; 
	private Boolean Furnished ;
	
	private String type ;

}

		


