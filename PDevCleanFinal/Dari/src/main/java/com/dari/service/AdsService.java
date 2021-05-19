package com.dari.service;

import java.util.List;
import java.util.Map;

import com.dari.model.Ads;
import com.dari.model.Typeads;

public interface AdsService {

	

	void deleteAdsByID(long adID);

	List<Ads> findAllad();



	Ads updatead(Ads ad);


	int nbrlike();

	int mostlikedadd();

	int nbrdislike();

	Ads Incrementlikes(Long idad);

	Ads Incrementdislikes(Long idad);

	Ads findbyid(Long idad);

	int getnblikes(Long idad);

	int getnbdislikes(Long idad);
	

	List<Ads> filterAds(String location, float price, int nbRooms, Typeads kindofgood);

	Ads addnewad(Ads newad, Long userid); 


}
