package com.dari.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dari.model.Cart;
import com.dari.model.Delivery;
import com.dari.model.FileDB;
import com.dari.model.Fourniture;
import com.dari.model.FournitureType;
import com.dari.model.ResponseFile;
import com.dari.model.ResponseMessage;
import com.dari.repository.FournitureRepository;
import com.dari.service.CartService;
import com.dari.service.DeliveryService;
import com.dari.service.FournitureService;
import org.springframework.lang.Nullable;

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

	@Autowired
	private FournitureRepository fourrep;

	 
	 @GetMapping("/getfourimg/{idf}")
	 public FileDB getfourim(@PathVariable Long idf) {
	  Fourniture f=fourrep.findById(idf).get();
	  FileDB fileDB = fourservice.getim(f.getImage().getId());
	  return fileDB;
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	    FileDB fileDB = fourservice.getim(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	
	
	  
	 /*@PostMapping("/addfourimg/{fourid}")
	 public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file
			  										  ,@PathVariable ("fourid") Long fourid) 
	 {
	    String message = "";
	    try {
	    	System.out.println(file);
	    Fourniture f=fourrep.findById(fourid).get();
	    FileDB ff=fourservice.store(f, file);
	    f.setImage(ff);
	    fourrep.save(f);
	      message = "Uploaded the file successfully: " ;
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " ;
	      return   ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }*/

		@PostMapping("/Fournitureup")
		@ResponseBody
		@Transactional  
		public Object UploadimageFourniture(@RequestParam("file") @Nullable  MultipartFile file,
										@RequestParam("identifier") Long id) {
					Fourniture four=fourrep.findById(id).get();					
					if(four==null)
					{
						Map<String, String> errorDetails= new HashMap<>();
						errorDetails.put("message", "produit non definit");
						return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
					
					}
					if(file!=null) {
						FileDB image=four.getImage();
						if(image==null)
						{
							image= new FileDB();
							image.setFourniture(four);
							four.setImage(image);
						}
						try {
							image.setData(file.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
						image.setName(file.getOriginalFilename());
						fourservice.saveImage(image);
						fourservice.updateFourniture(four);
					}
			return four;
			
		}
	  
	@PostMapping("/addfour/{userid}")
	@ResponseBody
	public Fourniture addfour(@RequestBody Fourniture f ,@PathVariable("userid") Long usrid)
	{
    	return fourservice.AddFour(f,usrid);
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
		return fourservice.getOwner(uid);
	}
	
	@GetMapping("/getfourstatusbyid/{fourid}")
	@ResponseBody
	public boolean getfourstatusebyid(@PathVariable ("fourid") Long FournitureId )
	{
		return fourservice.findFourniture(FournitureId).isType();
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
	@GetMapping("/getcartall")
	@ResponseBody
	public List<Cart>  getall () {
		return cartservice.findallcarts();
	}
	
	@GetMapping("/getcartuser/{userid}")
	@ResponseBody
	public Cart getcartbyuserr (@PathVariable ("userid") long uid) {
		return cartservice.causer(uid);
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

	@PostMapping("/removefcart/{cartid}/{fourid}")
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

		float deliverytype=del.getDeliverytype();
		String add=del.getAdress();
		String inf=del.getMoreinfo();
		
		return cartservice.buyfromcart(deliverytype,add,inf,cid);
	
	}
	
	@PostMapping("/shiporder/{delid}")
	@ResponseBody
	public Delivery buytcart(@PathVariable("delid") Long did)
	{
		
		return cartservice.shippedorder(did);
		

	}
	
	@GetMapping("/getdel/{fourid}")
	@ResponseBody
	public Delivery Getallownerdeleviry(@PathVariable("fourid") Long fid){
		return delservice.getownertodeliver(fid);
				
	}
	
	
	@GetMapping("/getalldelbyuser/{uid}")
	@ResponseBody
	public List<Delivery> finddeluser (@PathVariable("uid") Long userid)
	{
		return delservice.finddeliverybyuserid(userid);
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

