package com.dari.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Ads;
import com.dari.repository.AdsRepository;


@Service
public class FilterAdsServiceImpl implements FilterAdsService {

	@Autowired
	AdsRepository adsrepository;
	
	@Override
	public List<Ads> FilterLocation(String Location){
		List<Ads> ads = (List<Ads>)adsrepository.findAll();
		List <Ads> list =  new ArrayList<>() ;
		for ( Ads ad : ads ) {
			if (Location.equals(ad.getLocation())) {
				list.add(ad);
			}
		}
		return list;
		
	}
	
	@Override
	public List<Ads> FilterType(String Type){
		List<Ads> ads = (List<Ads>)adsrepository.findAll();
		List <Ads> list =  new ArrayList<>() ;
		for ( Ads ad : ads ) {
			if (Type.equals(ad.getKindofgood())) {
				list.add(ad);
			}
		}
		return list;
	}
	
	public List<Ads> FilterByPrice (float maxprice){
		List<Ads> ads = (List<Ads>)adsrepository.findAll();
		List <Ads> list =  new ArrayList<>() ;
		for ( Ads ad : ads ) {
			if (maxprice >= (ad.getPrice())) {
				list.add(ad);
			}
		}
		return list;}
	
	
	public List<Ads> FilterByNumber (int number){
		List<Ads> ads = (List<Ads>)adsrepository.findAll();
		List <Ads> list =  new ArrayList<>() ;
		for ( Ads ad : ads ) {
			if (number == (ad.getRoomsNb())) {
				list.add(ad);
			}
		}
		return list;}
	}
