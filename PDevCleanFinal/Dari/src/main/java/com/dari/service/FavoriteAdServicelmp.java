package com.dari.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import com.dari.model.FavoriteAd;

import com.dari.model.User;
import com.dari.model.Ads;
import com.dari.repository.AdsRepository;
import com.dari.repository.FavoriteAdRepository;

import com.dari.repository.UserRepository;
import com.dari.service.MailService;

@Service
public class FavoriteAdServicelmp implements FavoriteAdService {

	public static final Logger L = LogManager.getLogger(FavoriteAdServicelmp.class);
	
@Autowired
private AdsRepository adsRepository ;
@Autowired
private FavoriteAdRepository favoriteAdRepository;
@Autowired
private UserRepository userRepository;
@Autowired 
private MailService mail; 


@Override
public void addFav(long adId, long idU) {
	
	if(favoriteAdRepository.getVoteBySujetAndUser(adId,idU)==null)
	{	
		FavoriteAd fav = new FavoriteAd();
		Ads ad = adsRepository.findById(adId).get();
		User user = userRepository.findById(idU).get();
		fav.setAd(ad);
	    fav.setUser(user);
		favoriteAdRepository.save(fav);
		
	}
	else 
	{
     L.info("erreur");
	}
	}


@Override
public String deleteFav(long id){

		favoriteAdRepository.delete(favoriteAdRepository.findById(id).get());
		return "add deleted" ; 
		
	}

	@Override
	public  List<FavoriteAd> GetAllFavByUser(long id) {
	List<FavoriteAd> wlls = new ArrayList<>();
	List<FavoriteAd> wls = new ArrayList<>();
	User user = userRepository.findById(id).get();
	wlls=(List<FavoriteAd>)favoriteAdRepository.findAll();
	for (FavoriteAd wll : wlls) {
	if(wll.getUser() == user)
		{
		wls.add(wll);
		  
	}
		
}
return wls;
}
	@Override
	public List<FavoriteAd> retrieveAllfav() {
		List<FavoriteAd> wls =(List<FavoriteAd>)favoriteAdRepository.findAll();
		for (FavoriteAd wl : wls) {
			L.info("whishlist +++"+wl);
		}
		return wls;
	}
	
	@Override
	public FavoriteAd GetFavById(long id) {
		FavoriteAd favAd = favoriteAdRepository.findById(id).get();
		return favAd;
	}
	

	@Override
	public  void changementPrix(long adid , float np ) throws MailException
	{float op ;
	//String B = null ;
	List<User> user= new ArrayList<>();
	List<FavoriteAd> favorite =(List<FavoriteAd>)favoriteAdRepository.findAll();
	Ads ad = adsRepository.findById(adid).get();
	op = ad.getPrice();
	ad.setPrice(np);
	adsRepository.save(ad);

		//recherche des User qui ont favoriser cette annonce
		for (FavoriteAd fav : favorite)
		{
			if(adid==fav.getAd().getAdID())
			{
				user.add(fav.getUser());
				
			}
		}
		//tester les prix
		for(User u: user)
		{
			if (op < np)
			{
			//	B="<";
			
				String email =u.getEmail();
				String body ="Hello , \r the price in your favorite ad has creased : "+ ad.getPrice();
				//the ad indicated above change 
				String subject="Hello "+u.getFirstName()+" check it ";
				mail.Sendd(email,body,subject);
				
			}
			else if (op > np)
			{ 	
				//B =">";
				String email =u.getEmail();
				String body ="Hello , \r the price in your favorite ad has decreased to : "+
						ad.getPrice();
				//the ad indicated above change 
				String subject="Hello "+u.getFirstName()+" check it ";
				mail.Sendd(email,body,subject);
				
			}
		}
		//return B;
		
		}
			
	}


	
	


