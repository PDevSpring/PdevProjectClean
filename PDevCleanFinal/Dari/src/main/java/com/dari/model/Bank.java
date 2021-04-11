package com.dari.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banks")
@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbank")
	private long bankId ; 
	
	@Column(name = "Namebank")
	public String namebank;
	
	@Column(name = "DESCRIPTION")
	public String descbank;

	public String adressbank;

	public float margeInteretbank;

	private float taux;
	

	@JsonIgnore
	@OneToOne//(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="bank")
	private Agent agent;
	
	@JsonIgnore
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bank")
	private List<LoansSimulationBank> loansSimulationbank;

}
