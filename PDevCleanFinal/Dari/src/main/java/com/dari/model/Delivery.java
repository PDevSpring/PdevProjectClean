package com.dari.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_Delivery")
public class Delivery {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEL_ID")
	public long deliveryId;
	
	public float Price;
	public String moreinfo;
	
	public String adress;
	@Enumerated(EnumType.STRING)
	public OrderStatus orderstatus;
	
	@ManyToOne
	public User user;
	
	@OneToMany
	public List<Fourniture> fournituress;
}
