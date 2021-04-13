package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.service.FilterAdsService;
import com.dari.model.Ads;

@RestController
@RequestMapping("/App/filterads")
public class FilterAdsController {

	@Autowired 
	FilterAdsService filterAdsService;
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	
	@GetMapping("/Location/{loc}")
	
	List<Ads> FilterbyLocation(@PathVariable("loc") String loc  ){
		List<Ads> list = filterAdsService.FilterLocation(loc);
		return list ;
	}
}
