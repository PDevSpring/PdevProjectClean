package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.FournitureType;
import com.dari.repository.DeliveryRepository;
import com.dari.model.Cart;
import com.dari.model.Delivery;
import com.dari.model.Fourniture;
import com.dari.service.CartService;
import com.dari.service.DeliveryService;
import com.dari.service.FournitureService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/App/Four")
public class FournitureController {
	
	
	@Autowired
	private	FournitureService fourservice;
	
	@Autowired
	private	CartService cartservice;
	
	@Autowired
	private DeliveryService delservice;
	

	
	@PostMapping("/addfour/{userid}")
	@ResponseBody
	public Fourniture addfour(@RequestBody Fourniture f ,@PathVariable("userid") Long usrid)
	{
		fourservice.AddFour(f,usrid);
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
	
	@GetMapping("/getfourownerbyid/{userid}")
	@ResponseBody
	public List<Fourniture> getfourownerbyid(@PathVariable ("userid") Long uid )
	{
		return cartservice.getcartbyuser(uid).getFournitures();
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
	//----------------------------------------------------------------------------
	
	@GetMapping("/getcartfour/{cartid}")
	@ResponseBody
	public List<Fourniture> getcartf (@PathVariable ("cartid") long cid) {
		return cartservice.getfourniturescart(cid);
		
	}
	
	@GetMapping("/getcartuser/{userid}")
	@ResponseBody
	public Cart getcartbyuserr (@PathVariable ("userid") long uid) {
		return cartservice.getcartbyuser(uid);
	}
	
	@GetMapping("/getcart/{cartid}")
	@ResponseBody
	public Cart getcart (@PathVariable ("cartid") long cid) {
		return cartservice.getcart(cid);
		
	}
	
	
	
	@PostMapping("/createcart/{userid}")
	@ResponseBody
	public Cart createcart(@PathVariable("userid") Long usrid)
	{ 	Cart c = new Cart();
		cartservice.createCart(c, usrid);
		return c;
	}

	@PostMapping("/addcart/{cartid}/{fourid}")
	@ResponseBody
	public Cart addtcart(@PathVariable("cartid") Long cid,@PathVariable("fourid") Long fid)
	{
		Cart c=cartservice.addtocart(fid, cid);
		return c;
	}

	@PostMapping("/removefcart/{cartid}/{fourid}/{q}")
	@ResponseBody
	public Cart removetcart(@PathVariable("cartid") Long cid
			 				,@PathVariable("fourid") Long fid )
	{
		return cartservice.removefromcart(fid, cid);
	
	}


	@PostMapping("/buycart/{cartid}")
	@ResponseBody
	public Delivery buytcart(@RequestBody Delivery del ,@PathVariable("cartid") Long cid)
	{
		System.out.println("cart"+ cid);
		System.out.println(del);
		System.out.println("cart"+ cid);


		String add=del.getAdress();
		String inf=del.getMoreinfo();
		
		return cartservice.buyfromcart(add,inf,cid);
	
	}
	
	@PostMapping("/shiporder/{delid}")
	@ResponseBody
	public Delivery buytcart(@PathVariable("delid") Long did)
	{
		
		return cartservice.shippedorder(did);
		

	}
	
	@GetMapping("/getalldel")
	@ResponseBody
	public List<Delivery> Getalldeleviry(){
		return delservice.getalldeleviry();
	}
	
	@PutMapping("/modifdelivery/{delid}")
	@ResponseBody
	public Delivery madrdelivery(@PathVariable("delid") Long did,@RequestBody String adr){
		return delservice.modadressdelivery(did,adr);
	}
	
	@GetMapping("/getdelbyid/{delid}")
	@ResponseBody
	public Delivery getdelbyid(@PathVariable ("delid") Long did )
	{
		return delservice.finddeliverybyid(did);
	}
	
	@DeleteMapping("/deletedelbyid/{delid}")
	@ResponseBody
	public void deletedelbyid(@PathVariable ("delid") Long did )
	{
		 delservice.deletedeliverybyid(did);
	}
	
	

	

}

