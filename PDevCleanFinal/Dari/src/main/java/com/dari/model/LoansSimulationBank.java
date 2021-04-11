package com.dari.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "T_Loans")
public class LoansSimulationBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDloan")
	private long IdLoan;
	
	private double Taux;
	
	private double Mensuel;
	
	private double CapaciteRembouresement;
	
	private double Interet;
	
	private double Interetall;
	
	private double Mensualite;
	
	private double Principale;
	
	private double MontantRemb;
	
	private double Prixprod;
	
	private double Salaire;
	
	private String Status;
	
	private Date StartedDate;
	
	
	@ManyToOne
	Bank bank;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Agent agent;
}
