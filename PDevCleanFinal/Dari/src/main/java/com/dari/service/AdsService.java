package com.dari.service;

import java.util.List;

import com.dari.model.Ads;

public interface AdsService {

	

	void deleteAdsByID(long adID);

	List<Ads> findAllad();



	Ads updatead(Ads ad);

	Ads addnewad(Ads newad);

	int nbrlike();

	int mostlikedadd();

	int nbrdislike();

	Ads Incrementlikes(Long idad);

	Ads Incrementdislikes(Long idad);

	Ads findbyid(Long idad);

	int getnblikes(Long idad);

	int getnbdislikes(Long idad);


}
