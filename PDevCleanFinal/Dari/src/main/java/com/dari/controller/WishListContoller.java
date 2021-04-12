package com.dari.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.WishList;
import com.dari.service.WishListService;



@RestController
public class WishListContoller {

	@Autowired
	private WishListService wishListService;
	

	
	
	
	
///////////////////// WishList//////////////////////////////////
	 
	 
		// localhost:3000/remove-wishList/2 
			//DELETE
		 
		 @DeleteMapping("/remove-wishList/{wishList-id}") 
		 @ResponseBody 
		 public String removeWishList(
				 @PathVariable("wishList-id") int Id) { 
			 wishListService.deleteWishList(Id);
			 return "deleted"; 
			 
		 	}
		 
		// localhost:3000//modify-wishList
		 /*{
        "surfacemin": 2 ,
        "surfacemax": 2,
        "budgetmin": 1,
        "budgetmax": 1,
        "location": "1",
        "user": {
            "id": 1,
            "firstName": "bb",
            "lastName": "j",
            "email": "melek",
            "userName": "kk",
            "password": "kk",
            "role": "kk",
            "image": "nn",
            "wishLists": []
        },
        "airConditioner": true,
        "garden": true,
        "roomsNb": 1,
        "furnished": true,
        "serviceType": "1",
        "swimmingPool": true,
        "bathroomsNb": 1,
        "balconiesNb": 1,
        "heater": true,
        "garagesNb": 1,
        "idW": 1
    }*/
			
		 //PUT
		 @PutMapping("/modify-wishList")
		 @ResponseBody 
		 public WishList modifyWishList(@RequestBody WishList user) { 
			 return wishListService.updateWishList(user);
		 }
		 
		// localhost:3000/add-wishList
		/*   {
		        "surfacemin": 88,
		        "surfacemax": 77,
		        "budgetmin": 10,
		        "budgetmax": 12,
		        "location": "loc",
		        "user": {
		            "id":1 ,
		            "firstName": "bb",
		            "lastName": "j",
		            "email": "melek",
		            "userName": "kk",
		            "password": "kk",
		            "role": "kk",
		            "image": "nn",
		            "wishLists": []
		        },
		        "airConditioner": true,
		        "garden": true,
		        "roomsNb": 8,
		        "furnished": true,
		        "serviceType": "ppp",
		        "swimmingPool": true,
		        "bathroomsNb": 2,
		        "balconiesNb": 2,
		        "heater": true,
		        "garagesNb": 2
		        
		    }*/
		 @PostMapping("/add-wishList") 
		 @ResponseBody 
		 public WishList addWishList(@RequestBody WishList u) { 
			 WishList wishList = wishListService.addWishList(u);	
			 return wishList; 
			 }
		 
		 // localhost:3000/getAllWhishListsByClient/1
		 @GetMapping(value = "getAllWhishListsByClient/{idC}")
		 @ResponseBody
		 public List<WishList> getAllWhishListsByClient(@PathVariable("idC") long idClient) {
			return wishListService.getAllWhishListsByClient(idClient);
		 }
		 
		 // localhost:3000/retrieve-all-wishLists
			//GET
		 @GetMapping("/retrieve-all-wishLists") 
		 @ResponseBody 
		 public List<WishList> getWishLists() {
			 List<WishList> list = wishListService.retrieveAllWishLists();
			 return list; } 
		/* 
		 @GetMapping("comparaison/{adid}/{wishid}")
		 @ResponseBody
		 public boolean compar (@PathVariable("adid") long adid, @PathVariable("wishid") long wishid) {
			try {boolean a =wishListService.comparaison(adid,wishid );
			 return a;
			 } catch (Exception e) {
				 return false;
			 }
		 }*/
		 
		 @PostMapping("notif/{id}")
		 @ResponseBody
		 public boolean comparaisonf (@PathVariable("id") long id) {
			boolean a =wishListService.createNotificati(id );
			 return a;
			 
		 }
		
	
	}

	
	

