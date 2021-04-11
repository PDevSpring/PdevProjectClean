package com.dari.controller;





public class PurchasingController {
	/*
	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepository userrep;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private FournitureService fourservice;
	
	@Autowired
	private DeliveryService deliveryservice;
	

	//----------------------------------------FOURNITURE---------------------
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
	//--------------------------PURCHASE---------------------------
	@PostMapping("/buyfour/{fourid}/{iduser}/{iddelivery}/")
	@ResponseBody
	public Order BuyFourniture (@PathVariable ("fourid") long fid,
								@PathVariable ("iduser") long iduser,
								@PathVariable ("iddelivery") long iddelivery) {
		
		Delivery delivery=deliveryservice.adddelivery(del);
		User user = userrep.findById(iduser).get();
		Fourniture four=fourservice.BuyFourniturebyid(fid);
		Order order;
		order.setFourniture(four);
		order.setDelivery(delivery);
		order.setUser(user);
		
		
		return order;
		
	}
	
	@PostMapping("/adddelivery/")
	
	
	
	

	@PostMapping("/addtocart/{idfr}/{idus}")
	@ResponseBody
	public Cart addtocartfourniture(@PathVariable ("idfr") Long idfour,@PathVariable ("idus") Long iduser) 
	{
		Fourniture four= fourservice.findFourniture(idfour);
		User user = userrep.findById(iduser).get();
		user.getCart().setFour(four);
		return user.getCart();
		
	}
	
	@DeleteMapping("/deletefromcart/{idus}")
	@ResponseBody
	public Cart deletetocartfourniture(@PathVariable ("idus") Long iduser) 
	{
		User user = userrep.findById(iduser).get();
		user.setCart(null);
		return user.getCart();	
	}
	
*/
	

}
