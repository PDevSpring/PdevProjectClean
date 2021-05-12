package com.dari.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Cart;
import com.dari.model.Delivery;
import com.dari.model.Fourniture;
import com.dari.model.OrderStatus;
import com.dari.model.User;
import com.dari.repository.CartRepository;
import com.dari.repository.DeliveryRepository;
import com.dari.repository.FournitureRepository;
import com.dari.repository.UserRepository;
@Service

public class CartServiceImpl implements CartService {
	
	@Autowired
	FournitureService fourservice;
	@Autowired
	DeliveryService deliveryservice;
	
	@Autowired
	FournitureRepository fourrep;
	
	@Autowired
	UserRepository userrep;
	@Autowired 
	DeliveryRepository delrep;
	@Autowired 
	CartRepository cartrep;
	
	
	@Override
	public Cart createCart (Cart c,Long userID)
	{
		c.setUser(userrep.findById(userID).get());
		c.setTotalPrice(0);
		return cartrep.save(c);
	}
	
	@Override
	public List<Fourniture> getfourniturescart (Long cardid)
	{
		
		Cart c=cartrep.findById(cardid).get();
		List<Fourniture> list =  c.getFournitures();
		return list;

	}
	
	@Override
	public Cart getcart(Long cardid)
	{
		
		Cart c=cartrep.findById(cardid).get();
		
		return c;

	}
	
	public Cart getcartbyuser(Long user)
	{
		Cart found = null;
		User u = userrep.findById(user).get();
		List <Cart> carts= (List<Cart>) cartrep.findAll();
		for(Cart c : carts) {
			if(c.getUser().getId()== u.getId())
				{
				found=c;
				}
		
				else 
				{
					return null;
				}
		}
		return found;
		
	}
	
	@Override 
	public Cart addtocart (Long fournitureID,Long CartID)
	{
		Cart c=cartrep.findById(CartID).get();

		Fourniture f= fourrep.findById(fournitureID).get();
		
			f.setCart(c);
			List <Fourniture> fours = c.getFournitures();
			
			fours.add(f);
		
			c.setFournitures(fours);
		
			
			float tprice=c.getTotalPrice();
			c.setTotalPrice(tprice+ (f.getPrice()));
			return cartrep.save(c);
		
		
	}
	
	@Override 
	public Cart removefromcart (Long fournitureID,Long CartID)
	{
		
		Cart c=cartrep.findById(CartID).get();
		
		
		List<Fourniture> list =  c.getFournitures();
		
		Fourniture fremove= fourrep.findById(fournitureID).get();
		

	if(list.size()!=1) {
		for(Fourniture f:list  ) {
			
			if(f.equals(fremove)) {
				
				int fr=list.indexOf(f);
				c.setTotalPrice(c.getTotalPrice()-(f.getPrice())); 
				list.remove(fr);
				f.setCart(null);
			}
		}
	}
	else {fremove.setCart(null);list.clear();c.setTotalPrice(0);}
			
		return cartrep.save(c);
	}
	
	
	@Override 
	public Delivery buyfromcart (String adress,String moreinf,Long CartID)
	{
		Delivery del=new Delivery();
	
		Cart c=cartrep.findById(CartID).get();
		
		List<Fourniture> list =  c.getFournitures();
		OrderStatus o=null;
		c.setFournitures(null);
		del.setFournituress(list);
		del.setAdress(adress);
		del.setMoreinfo(moreinf);
		del.setPrice(c.getTotalPrice());
		del.setUser(c.getUser());
		del.setOrderstatus(o.Processing);
		deliveryservice.adddelivery(del);
		
		for(Fourniture f:list  ) {
			fourservice.BuyFourniturebyid(f.getFournitureId());
			f.setCart(null);
			f.setDelivery(del);
		}
		
		c.setTotalPrice(0);
		cartrep.save(c);
		return del;
	}
	@Override 
	public Delivery shippedorder (Long delID)
	{
		Delivery del =deliveryservice.finddeliverybyid(delID);
		
		
		OrderStatus o=null;
		del.setOrderstatus(o.Shipped);
		delrep.save(del);
	
		
		return del;
	}
	
	
	
	

	
}
