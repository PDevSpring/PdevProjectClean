package com.dari.model;



import javax.persistence.Column;
import javax.persistence.Entity;
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
	public long FournitureId ;
	
	@Column(name = "quantity", nullable = false)
	public Integer quantity;
	 
	public boolean type;
	
	
	public String Description ; 
	public String Name ; 
	
	
	public float Price ;
		
	public long usercard;

	public String pubDate;
	//mappedBy = "fourniture")

    @OneToOne
    @JsonIgnore
	public FileDB image;
	
	@JsonIgnore
	@OneToOne
	public User user;

	@JsonIgnore
	@ManyToOne
	public Delivery delivery;
	
	@JsonIgnore
	@ManyToOne
	public Cart cart;
	
	}




