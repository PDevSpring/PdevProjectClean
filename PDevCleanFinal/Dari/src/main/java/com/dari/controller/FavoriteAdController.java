package com.dari.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.service.FavoriteAdService;
import com.dari.service.MailSendService;
import com.dari.service.UserService;
import com.dari.model.FavoriteAd;





@RestController
public class FavoriteAdController {

	 @Autowired 
	 FavoriteAdService favoriteAdService;
	 @Autowired
	 UserService userService;
	 @Autowired
	 MailSendService mailSendService;
	 
		/////////////////// Favoris //////////////////////////////////
	 
	// localhost:3000/addFav/1/1
	 @PostMapping("/addFav/{adId}/{idC}") 
	 @ResponseBody 
	 public String favoriserAnnonce(@PathVariable("adId") long adId, @PathVariable("idC") long idC) { 
		try { favoriteAdService.addFav(adId,idC);
		 return "fav added";}
		catch (Exception e) {
			return "erreur";
		}
		
	
		 }
	 


			//DELETE
	 // localhost:3000/deleteFav/{favoris-idF} 
		 @DeleteMapping("/deleteFav/{idF}") 
		 @ResponseBody 
		 public String removeFavorisAd(
				 @PathVariable("idF") int Id) { 
			 favoriteAdService.deleteFav(Id);
			 return "fav deleted";
		 	}
			
		// localhost:3000/getAllFavoritesByUser/2
		 @GetMapping("/getAllFavoritesByUser/{id}")
		    @ResponseBody
			public List<FavoriteAd> getAllFavoris(@PathVariable("id") long userId) {
			  System.out.println("c'est bon");
				return favoriteAdService.GetAllFavByUser(userId);
			}
	
		//GET
		 @GetMapping("/retrieve-all-fav") 
		 @ResponseBody 
		 public List<FavoriteAd> getfavlist() {
			 List<FavoriteAd> list = favoriteAdService.retrieveAllfav();
			 return list;
			 } 
		 
		//GET
		 @GetMapping("/retrieveById/{id}") 
		 @ResponseBody 
		 public FavoriteAd retrieveFavById (@PathVariable("id") long Id) {
			 FavoriteAd favAd = favoriteAdService.GetFavById(Id);
			 return favAd;
			 } 
		 
		
		 
		 ////localhost:3000/Mail/
		 @PostMapping("/Mail/{adId}/{np}")
		 @ResponseBody
		 public String changePrix(@PathVariable("adId") long adId , @PathVariable("np") long np) {
			 favoriteAdService.changementPrix (adId, np);
			 return "true";
		
		 }
		 
		 
}
