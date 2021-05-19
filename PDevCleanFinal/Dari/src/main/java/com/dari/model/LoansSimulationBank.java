package com.dari.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Loans")
public class LoansSimulationBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDloan")
	public long IdLoan;
	
	public double Taux;
	
	public double Mensuel;
	
	public double CapaciteRembouresement;
	
	public double Interet;
	
	public double Interetall;
	
	public double Mensualite;
	
	public double Principale;
	
	public double MontantRemb;
	
	public double Prixprod;
	
	public double Salaire;
	
	public String Status;
	
	public String StartedDate;
	
	@JsonIgnore
	@ManyToOne
	Bank bank;
	
	@JsonIgnore
	@ManyToOne
	User user;
	
	@JsonIgnore
	@ManyToOne
	Agent agent;
}
