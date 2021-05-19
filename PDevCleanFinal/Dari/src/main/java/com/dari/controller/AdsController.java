package com.dari.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


import com.dari.model.Ads;
import com.dari.model.Typeads;
import com.dari.service.AdsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/App")

public class AdsController {
	
	@Autowired
	private AdsService adService ; 
	
	@GetMapping("/ads")
	  List<Ads> all() {
	    return (List<Ads>) adService.findAllad();
	  }
    
	@PostMapping ("/newad/{userid}")
	@ResponseBody
	Ads newad (@RequestBody Ads newad,@PathVariable("userid") Long userid) {
		return adService.addnewad(newad,userid);
	}
	
	@DeleteMapping("/deletead/{ID}")
	@ResponseBody
	public void DeleteAd (@PathVariable("ID") Long adID) {
		adService.deleteAdsByID(adID);
	}
	
	@PutMapping("/updatead/{id}")
	@ResponseBody
	public Ads updatead (@RequestBody Ads ad) {
	return adService.updatead(ad);
	}
	
	@GetMapping("/findad/{id}")
	@ResponseBody
	public Ads Findbyid (@PathVariable("id") Long adId) {
		return  adService.findbyid(adId);
	}
	
	
	
	@PutMapping("/incLikesad/{id}")
	@ResponseBody
	public Ads IncrLikes(@PathVariable("id") Long adId) {
		return adService.Incrementlikes(adId);
	}
	
	
	@PutMapping("/incDislikesad/{id}")
	@ResponseBody
	public Ads IncrDislikes(@PathVariable("id") Long adId) {
		return adService.Incrementdislikes(adId);
	}
	
	@GetMapping("/getlike/{id}")
	@ResponseBody
	  public int getlikesad(@PathVariable("id") Long adId) {
	    return adService.getnblikes(adId);
	  }
	
	@GetMapping("/getdislike/{id}")
	@ResponseBody
	  public int getdislikesad(@PathVariable("id") Long adId) {
	    return adService.getnbdislikes(adId);
	  }
	
	@GetMapping("/getmostliked")
	@ResponseBody
	  public int getmostliked() {
	    return adService.mostlikedadd();
	  }
	
	@GetMapping("/getallliked")
	@ResponseBody
	  public int nbrlike() {
	    return adService.nbrlike();
	  }
	
	@GetMapping("/getalldisliked")
	@ResponseBody
	  public int nbrdislike() {
	    return adService.nbrdislike();
	  }
	
	@GetMapping("/filter")
	@ResponseBody
	public List<Ads> filterAds(@RequestParam String location, @RequestParam float price, @RequestParam int nbRooms, @RequestParam Typeads kindofgood ) {
	    return adService.filterAds(location, price, nbRooms, kindofgood);
	}


	  

	
}