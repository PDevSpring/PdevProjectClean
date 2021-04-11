package com.dari.service;

import java.util.Map;

import com.dari.model.Fourniture;

public interface ShoppingCartService {

	Map<Fourniture, Integer> getProductsInCart();

	void addProduct(Fourniture product);

	void removeProduct(Fourniture product);

	String checkout(Long id);

}
