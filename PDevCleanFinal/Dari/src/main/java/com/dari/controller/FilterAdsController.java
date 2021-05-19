package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.service.FilterAdsService;
import com.dari.model.Ads;
import com.dari.model.Typeads;
@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/App1")
public class FilterAdsController {

	@Autowired 
	FilterAdsService filterAdsService;
	
	
	@GetMapping("/Location/{loc}")
	
	List<Ads> FilterbyLocation(@PathVariable("loc") String loc  ){
		List<Ads> list = filterAdsService.FilterLocation(loc);
		return list ;
	}
	
	@GetMapping("/Type/{type}")
	
	List<Ads> FilterbyType(@PathVariable("type") Typeads type  ){
		List<Ads> list = filterAdsService.FilterType(type);
		return list ;
	}
	
	@GetMapping("/price/{prix}")
	
	List<Ads> FilterPrices(@PathVariable("prix") float p  ){
		List<Ads> list = filterAdsService.FilterByPrice(p);
		return list ;
	}
	
	@GetMapping("/Nbrooms/{nb}")
	
	List<Ads> FilterPrices(@PathVariable("nb") int nb  ){
		List<Ads> list = filterAdsService.FilterByNumber(nb);
		return list ;
	
}
	}
