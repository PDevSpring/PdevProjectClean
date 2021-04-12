package com.dari.service;

import java.util.List;

import com.dari.model.Ads;
/*import com.dari.model.Notification;
import com.dari.model.User;*/
import com.dari.model.WishList;

public interface WishListService {

	public WishList addWishList(WishList wl);

	public String deleteWishList(long id);

	public WishList updateWishList(WishList wl);
	
	public List<WishList> getAllWhishListsByClient(long id);
	
	public List<WishList> retrieveAllWishLists();
	
//	public Boolean comparaison(WishList wl, Ads ad);

	public boolean createNotificati(long id);

	//public Boolean comparaison(long adid, long wishid);

	Boolean comparaison(WishList wl, Ads ad);

//	long getWishListId(WishList w);

/*	Notification createNotificati(Ads ad ,User user , WishList wl);*/
	
}
