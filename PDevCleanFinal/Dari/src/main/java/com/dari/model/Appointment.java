package com.dari.model;

	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	public class Appointment{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long AppointmentId;
		@Temporal(TemporalType.DATE)
		private Date date ;  
		private String state;
		private int Heure;
		private String Attendance;
		
		@JsonIgnore
		@ManyToOne
		private User user;
		@JsonIgnore
		@ManyToOne
		private Ads ad;
	}


