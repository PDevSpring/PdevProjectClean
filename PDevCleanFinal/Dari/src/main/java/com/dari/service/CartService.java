package com.dari.service;

import java.util.List;

import com.dari.model.Cart;
import com.dari.model.Delivery;
import com.dari.model.Fourniture;

public interface CartService {


	Cart createCart(Cart c, Long userID);


	Delivery shippedorder(Long delID);

	
	List<Fourniture> getfourniturescart(Long cardid);


	Cart getcart(Long cardid);


	Cart getcartbyuser(Long user);


	Cart removefromcart(Long fournitureID, Long CartID);


	Cart addtocart(Long fournitureID, Long CartID);


	Delivery buyfromcart(float deliveryType, String adress, String moreinf, Long CartID);


	List<Cart> findallcarts();


	Cart causer(Long userid);



}
