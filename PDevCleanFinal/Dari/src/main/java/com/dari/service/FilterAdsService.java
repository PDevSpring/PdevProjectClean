package com.dari.service;

import java.util.List;

import com.dari.model.Ads;
import com.dari.model.Typeads;



public interface FilterAdsService {
	

	//public List<Ads> Filter();

	//public List<Ads> FilterLocation();

	public List<Ads> FilterLocation(String Location);

	
	public List<Ads> FilterByPrice (float maxprice);
	
	public List<Ads> FilterByNumber (int number);

	List<Ads> FilterType(Typeads Type);
}
