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
	
	@GetMapping("/ads")
	  List<Ads> all() {
	    return (List<Ads>) adService.findAllad();
	  }
    
	@PostMapping ("/newad")
	Ads newad (@RequestBody Ads newad) {
		return adService.addnewad(newad);
	}
	
	@DeleteMapping("/ad/{ID}")
	void deletead (@PathVariable long adID) {
		adService.deleteAdsByID(adID);
	}
	
	@PutMapping("/ad/{id}")
	@ResponseBody
	public Ads updatead (@RequestBody Ads ad) {
	return adService.updatead(ad);
	}
	

	  

	
}