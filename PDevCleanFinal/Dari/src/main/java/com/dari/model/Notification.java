package com.dari.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long NotificationId ;
	@Column
	private String message;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name= "AdID")
	private Ads ads;

}