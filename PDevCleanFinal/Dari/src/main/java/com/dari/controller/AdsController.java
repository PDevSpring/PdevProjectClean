package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


import com.dari.model.Ads;
import com.dari.service.AdsService;

@RestController
@RequestMapping("/App/Ads")
public class AdsController {
	
	@Autowired
	private AdsService adService ; 
	
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@GetMapping("/ads")
	  List<Ads> all() {
	    return (List<Ads>) adService.findAllad();
	  }
    
	@PostMapping ("/newad")
	@ResponseBody
	Ads newad (@RequestBody Ads newad) {
		return adService.addnewad(newad);
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


	  

	
}