package com.dari.model;




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
@Table(name = "FAVORITE_AD")
public class FavoriteAd {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdF;
	
	@OneToOne
	private User user ;
	
    @OneToOne
	private Ads ad;

	
	
	
	
	
}
