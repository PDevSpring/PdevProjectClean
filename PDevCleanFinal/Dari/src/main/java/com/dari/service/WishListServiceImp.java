package com.dari.service;

import java.util.ArrayList;
/*import java.util.Date;*/
import java.util.List;
import com.dari.service.MailService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Ads;

import com.dari.model.User;
import com.dari.model.WishList;
import com.dari.repository.AdsRepository;
import com.dari.repository.UserRepository;
import com.dari.repository.WishListRepository;



//import com.dari.repository.NotificationRepository;
@Service
public class WishListServiceImp implements WishListService {
	public static final Logger L = LogManager.getLogger(WishListServiceImp.class);
	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MailService mail;
	@Autowired
	AdsRepository adsRepository;

	@Override	
	public WishList addWishList(WishList wishList) {
		
		return wishListRepository.save(wishList);
	}

	@Override
	public String deleteWishList(long id) {
		
		wishListRepository.deleteById(id);
		return "deleted";
	}

	@Override
	public WishList updateWishList(WishList wishList) {
		
		return wishListRepository.save(wishList);
	}
	
	public List<WishList> retrieveAllWishLists() {
		List<WishList> wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wl : wls) {
			L.info("favoriteAd +++"+wl);
		}
		return wls;
	}
	
	public List<WishList> getAllWhishListsByClient(long id) {
		List<WishList> wlls = new ArrayList<>();
		List<WishList> wls = new ArrayList<>();
		User user = userRepository.findById(id).get();
		wlls=(List<WishList>)wishListRepository.findAll();
		for (WishList wll : wlls) {
		if(wll.getUser() == user)
			{
			wls.add(wll);
			  
		}
			
	}
	return wls;	
	}
	
	
@Override
	public Boolean comparaison(WishList wl, Ads ad) {
		//Ads ad = adsRepository.findById(adid).get();
		//WishList wl = wishListRepository.findById(wishid).get();
		boolean k = false ;
		if (ad.getPrice()>wl.getBudgetmin() || ad.getPrice()<wl.getBudgetmax() || ad.getSurface()>wl.getSurfacemin()|| ad.getSurface()<wl.getSurfacemax()
				|| ad.getServiceType().equals(wl.getServiceType())
				|| ad.getRoomsNb()== wl.getRoomsNb() 
						|| ad.getGarden().equals(wl.getGarden()) 
						|| ad.getSwimmingPool().equals(wl.getSwimmingPool())
						|| ad.getAirConditioner().equals(wl.getAirConditioner()) 
						|| ad.getHeater().equals(wl.getHeater()) 
						|| ad.getFurnished().equals(wl.getFurnished()) 
						|| ad.getLocation().equals(wl.getLocation())
						|| ad.getBalconiesNb()== wl.getBalconiesNb()
								|| ad.getGaragesNb()== wl.getGaragesNb()
										|| ad.getBathroomsNb()== wl.getBathroomsNb()
				
				){
			k= true;
		}	
		L.info("Alerte++++++++++:"+k);
		return k;		
		}

	
@Override
public boolean createNotificati(long  id ){
	boolean a = false ;
	Ads ad = adsRepository.findById(id).get();
	List<WishList> list =(List<WishList>)wishListRepository.findAll();
	//List<User> user = new ArrayList<>();
	//List<User> user= new ArrayList<>();
	
	for (WishList wll : list)
		
	{	
		
		if(comparaison(wll,ad))
		{
			
			String email =wll.getUser().getEmail();
			String body ="Hello , \r Something in your wishlist has been added to our Ads list check it : "+
					ad.getDescription();
			//the ad indicated above change 
			String subject="Hello "+wll.getUser().getFirstName()+" we may find something you like";
			mail.Sendd(email,subject,body);
			
			a=true ;
		}
	}

	
	return a;
}


	
}
	
	
