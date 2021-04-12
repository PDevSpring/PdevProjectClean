package com.dari.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Rent;
import com.dari.model.Sell;
import com.dari.service.SellAndRentService;




@RestController
@RequestMapping("/SellAndRent")
public class SellAndRentController {

		@Autowired
		private SellAndRentService sellAndRentService; 
  
  @GetMapping("/sellAds")
  @ResponseBody 
	 public List<Sell> getSell() {
		 List<Sell> list = sellAndRentService.SellAds();
		 return list; } 

  @GetMapping("/RentAds")
  @ResponseBody 
	 public List<Rent> getRent() {
		 List<Rent> list = sellAndRentService.RentAds();
		 return list; }
  
  @GetMapping("/RentAdsTypeRent")
  @ResponseBody 
	 public List<Rent> getRentTypeRent() {
		 List<Rent> list = sellAndRentService.RentAdsTypeRent();
		 return list; }
  
  @GetMapping("/RentAdsTypeHolidays")
  @ResponseBody 
	 public List<Rent> getRentTypeHolidays() {
		 List<Rent> list = sellAndRentService.RentAdsTypeHolidays();
		 return list; }
  
  @GetMapping("/RentAdsTypeTemp")
  @ResponseBody 
	 public List<Rent> getRentTypeTemp() {
		 List<Rent> list = sellAndRentService.RentAdsTypeTemp();
		 return list; }
  
}
