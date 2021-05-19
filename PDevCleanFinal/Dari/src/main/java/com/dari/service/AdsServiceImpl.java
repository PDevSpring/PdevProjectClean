package com.dari.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Ads;
import com.dari.model.Typeads;
import com.dari.repository.AdsRepository;
import com.dari.repository.UserRepository;




@Service
public class AdsServiceImpl implements AdsService {

	@Autowired
	private AdsRepository adsrepository;
	@Autowired
	private UserRepository userrep;

	
	@Override
	public Ads updatead (Ads ad) {
		return adsrepository.save (ad);
		
	}
	
	@Override
	public void deleteAdsByID (long adID) {
		Ads ad = adsrepository.findById(adID).get();
	    adsrepository.delete(ad);
	    }

	@Override
	public List<Ads> findAllad() {
		List<Ads> ad = (List<Ads>) adsrepository.findAll();
		return ad;
	}
	
	@Override
	public Ads findbyid(Long idad)
	{
		return adsrepository.findById(idad).orElse(null);
	}

	@Override
	public Ads  addnewad(Ads newad,Long userid) {
		newad.setUser(userrep.findById(userid).get());
		Ads ad = adsrepository.save (newad);
		return ad;
	}
	
	@Override 
	public int nbrlike() {
		int nb=0;
		List<Ads> list= (List<Ads>) adsrepository.findAll();
		for (Ads ad: list){
			nb+=ad.getLikesNB();
		}
		return nb;
	}
	
	@Override 
	public int nbrdislike() {
		int nb=0;
		List<Ads> list= (List<Ads>) adsrepository.findAll();
		for (Ads ad: list){
			nb+=ad.getDislikeNB();
		}
		return nb;
	}
	
	
	@Override
	public int getnblikes(Long idad)
	{	int a;
	Ads ad=adsrepository.findById(idad).get();
		return a=ad.getLikesNB();
		}
	@Override
	public int getnbdislikes(Long idad)
	{	int a;
	Ads ad=adsrepository.findById(idad).get();
		return a=ad.getDislikeNB();
		}
	
	
	@Override
	public int mostlikedadd() {	
		int k=0;
		List<Ads> list= (List<Ads>) adsrepository.findAll();
		for(Ads ad: list ) {

			if(ad.getLikesNB() > k) {
				k=ad.getLikesNB();	  
			}  
		}

		return k;

	}
	
	
	
	@Override
	public Ads Incrementlikes(Long idad)
	{	int a;
	Ads ad=adsrepository.findById(idad).get();
		a=ad.getLikesNB();
		a++;
		ad.setLikesNB(a);
		adsrepository.save(ad);
		return ad;
	}
	@Override
	public Ads Incrementdislikes(Long idad)
	{	int a;
	Ads ad=adsrepository.findById(idad).get();
		a=ad.getDislikeNB();
		a++;
		ad.setDislikeNB(a);
		adsrepository.save(ad);
		return ad;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Ads> filterAds(String location, float price, int nbRooms, Typeads kindofgood ) {
	    List<Ads> adsList = findAllad();
	   
	    if (location.equals("") == false) {
	        adsList= adsList.stream().filter(ad -> ad.getLocation().equals(location)).collect(Collectors.toList());
	    }
	    if (price != 0) {
	        adsList= adsList.stream().filter(ad -> ad.getPrice()==(price)).collect(Collectors.toList());
	    }
	    if (nbRooms != 0) {
	        adsList= adsList.stream().filter(ad -> ad.getRoomsNb()>=(nbRooms)).collect(Collectors.toList());
	    }
	    if (kindofgood.equals("") == false) {
	        adsList= adsList.stream().filter(ad -> ad.getKindofgood().equals(kindofgood)).collect(Collectors.toList());
	    }
	    return adsList;
	}
		 
	 }
	


