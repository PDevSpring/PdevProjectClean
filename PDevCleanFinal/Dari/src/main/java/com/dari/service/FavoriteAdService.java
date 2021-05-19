package com.dari.service;

import java.util.List;
import com.dari.model.FavoriteAd;




public interface FavoriteAdService {

	
	public String deleteFav(long id); 

	public List<FavoriteAd> GetAllFavByUser(long id);

	 public void addFav(long adId, long idU);
	
	 public List<FavoriteAd> retrieveAllfav();

	public FavoriteAd GetFavById(long id);

	public void changementPrix(long adid, float np);



	 
	



	
	
   
}
