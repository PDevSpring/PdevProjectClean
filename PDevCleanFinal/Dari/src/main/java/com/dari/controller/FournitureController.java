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

import com.dari.model.FournitureType;
import com.dari.model.Fourniture;
import com.dari.service.FournitureService;

@RestController
@RequestMapping("/App/Four")
public class FournitureController {
	
	
	@Autowired
	private	FournitureService fourservice;

	
	@PostMapping("/addfour")
	@ResponseBody
	public Fourniture addfour(@RequestBody Fourniture f )
	{
		fourservice.AddFour(f);
		return f;
	}
	
	@DeleteMapping("/deletefour/{fourid}")
	@ResponseBody
	public void deletefourniturebyid(@PathVariable ("fourid") Long FournitureId )
	{
		fourservice.deleteFour(FournitureId);
	}
	
	
	// NOT SURE :/ 
	@GetMapping("/getallfour")
	@ResponseBody
	public List<Fourniture> Getallfourniture(){
		return (List<Fourniture>) fourservice.getallfourniture();
	}
	
	@GetMapping("/getfourbyid/{fourid}")
	@ResponseBody
	public Fourniture getfourbyid(@PathVariable ("fourid") Long FournitureId )
	{
		return fourservice.findFourniture(FournitureId);
	}
	
	@GetMapping("/getfourpricebyid/{fourid}")
	@ResponseBody
	public float getfourpricebyid(@PathVariable ("fourid") Long FournitureId )
	{
		return fourservice.findFourniture(FournitureId).getPrice();
	}
	
	@GetMapping("/getfourstatusbyid/{fourid}")
	@ResponseBody
	public FournitureType getfourstatusebyid(@PathVariable ("fourid") Long FournitureId )
	{
		return fourservice.findFourniture(FournitureId).getType();
	}
	
	@GetMapping("/buyfour/{fourid}")
	@ResponseBody
	public Fourniture BuyFourniture (@PathVariable ("fourid") long fid) {
		return fourservice.BuyFourniturebyid(fid);
		
	}
}
