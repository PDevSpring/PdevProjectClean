package com.dari.service;

import com.dari.model.Cart;
import com.dari.model.Delivery;

public interface CartService {

	Cart addtocart(Long fournitureID, Long CartID);

	Cart createCart(Cart c, Long userID);

	Cart removefromcart(Long fournitureID, Long CartID);

	Delivery buyfromcart(String adress, String moreinf, Long CartID);

	Delivery shippedorder(Long delID);

}
