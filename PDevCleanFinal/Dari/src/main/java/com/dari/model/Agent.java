package com.dari.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Agents")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idag")
	private long Id;
	private String Firstname;
	private String Lastname;
	private Date datenaissance;
	private String Email;
	private String Password;
	private int Phone;
	private String Adress;
	

	
	@OneToOne
	private Bank bank;
	
	//private String (long idbank)
}
